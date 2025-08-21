package com.mx.openbank.i2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.openbank.i2.entity.Operacion;

@Repository
public interface RepositoryOperacion extends JpaRepository<Operacion, String> {

	@Query(
		    nativeQuery = true,
		    value =
		    "SELECT " +
		    "   op.transaction_ref, " +
		    "   op.operation_code, " +
		    "   op.external_address2, " +
		    "   CAST(op.operation_date AS TEXT) AS fechaHora, " +
		    "   CAST(op.amount AS TEXT) AS monto, " +
		    "   CASE " +
		    "       WHEN op.operation_code IN (9511,9531,9535,9537,9539,9543,2260,2617,2619,2468,2621,2360,2362,2364,2368,2202,2442,2250,2340,2396,2289,2291,2423,2235,2395,2243,2316,2318,2320,2334,2344,2591,2236,2322,2324,2326,2400,2402,2404,2406,9535,3705,2346,2229,9531,2632,2657,2658,2661,9539,2561,2673,2675,2686,2687,2688,2689,2690,2691,2692,2694,2216,4516,4507,4509,4518,2697) " +
		    "           THEN 'input_tran' " +
		    "       WHEN op.operation_code IN (9512,9532,9536,9538,9540,9544,9536,2257,2259,2618,2467,2620,2357,2359,2361,2363,2201,2439,2249,2317,2319,2288,2290,2422,2234,2590,2345,2228,2242,2315,2333,2339,2343,2321,2323,2325,2399,2401,2403,2405,2485,2604,2282,2292,2294,2296,5021,5022,3704,2655,2656,9540,2644,2424,2649,2560,2672,2674,2693,2696,4517,4506,4508,4519,2698) " +
		    "           THEN 'output_tran' " +
		    "       ELSE 'Otro' " +
		    "   END AS codigoOperacionSalida " +
		    "FROM fcm.pro_operation op " +
		    "WHERE (:IDtransaccion IS NULL OR op.transaction_ref = :IDtransaccion) " +
		    "WHERE (:IDtransaccion IS NULL OR op.transaction_ref = :IDtransaccion) " +
		    "  AND (:latLon IS NULL OR op.external_address2 = :latLon)"
		)
	
		List<Operacion> buscarOperaciones(
		    @Param("IDtransaccion") String transactionId,
		    @Param("codigoEntrada") String codigoEntrada,
		    @Param("codigoSalida") String codigoSalida,
		    @Param("latLon") String latLon
		);
}
