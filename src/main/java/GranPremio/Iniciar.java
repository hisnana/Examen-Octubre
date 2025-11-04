package GranPremio;

import utils.MiLogger;

public class Iniciar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		GranPremio gpGetafe = new GranPremio("GP Getafe");
		
		gpGetafe.empezarGranPremio(gpGetafe);

		MiLogger.info(gpGetafe.getCarreras().get(0).getNombre());

		boolean ganador= false;
		for (Carrera carrera : gpGetafe.getCarreras()) {
			MiLogger.info("Comienza la carrera "+carrera.getNombre()+" con los metros "+carrera.getDistanciaObjetivo());
			do {
				gpGetafe.apuestas(gpGetafe);
				ganador = gpGetafe.comenzarCarrera(carrera);
				
				
			} while (ganador==false);
			MiLogger.info("Fin de la carrera "+carrera.getNombre());
			continue;
		}

	}

}
