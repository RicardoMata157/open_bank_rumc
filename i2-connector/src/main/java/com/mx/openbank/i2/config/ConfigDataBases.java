package com.mx.openbank.i2.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.mx.openbank.i2.repository")
public class ConfigDataBases {

	@Bean
	@Primary
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://10.1.4.149:5432/openBanckDumy"); // modifica la url y el usuario del ambiente de aurora openbank
		dataSource.setUsername("postgres");
		dataSource.setPassword("admin");
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.mx.openbank.i2.entity");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaPropertyMap(properties());
		return factoryBean;
	}

	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManagger(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	private Map<String, Object> properties() {
		Map<String, Object> jpaProperties = new HashMap<>();
		jpaProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		jpaProperties.put(AvailableSettings.HBM2DDL_AUTO, "update"); // se cambia dependiendo a la necesidad modificar a
																		// none si no se desea modificar el ddl
		jpaProperties.put(AvailableSettings.SHOW_SQL, true);
		jpaProperties.put(AvailableSettings.FORMAT_SQL, true);
		return jpaProperties;
	}

}