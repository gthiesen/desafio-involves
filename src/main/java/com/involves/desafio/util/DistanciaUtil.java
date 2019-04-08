package com.involves.desafio.util;

public class DistanciaUtil {

	/**
	 * Calcula a distância em KM entre dois pares de latitude e longitude.
	 * 
	 * @param startLat
	 * @param startLong
	 * @param endLat
	 * @param endLong
	 * @return
	 */
	public static double haversine(double startLat, double startLong, double endLat, double endLong) {
		
		Double RAIO_TOTAL_DA_TERRA = 6371.0; // 6371KM

		double dLat = Math.toRadians((endLat - startLat));
		double dLong = Math.toRadians((endLong - startLong));

		startLat = Math.toRadians(startLat);
		endLat = Math.toRadians(endLat);

		double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat)
				* haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return RAIO_TOTAL_DA_TERRA * c; // <-- d
	}
	
	private static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }


}
