package com.mx.openbank.i2.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** Starts the application */
@Configuration
@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.mx.openbank.*")
public class Main  implements WebMvcConfigurer{

	/**
	 * Runs the application with some arguments
	 *
	 * @param args The arguments used to start the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	

//	  @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/**")
//	                .allowedOrigins("http://10.1.4.195")  // o la URL de tu frontend
//	                .allowedMethods("GET", "POST", "PUT", "DELETE")
//	                .allowedHeaders("*");
//	    }
//		
  
	
}
