package GranPremio;

import utils.MiLogger;

public class Iniciar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		GranPremio granPremio = new GranPremio("GP Getafe");
		
		granPremio.empezarGranPremio();

		System.out.println(granPremio.getCarreras().get(1).getNombre());
		Jinete jinete1 = new Jinete("Pepe",35);
		Caballo caballo1 =new Caballo("Rocinante",jinete1);
		String texto = caballo1.getNombre()+" Exp "+caballo1.getExperiencia()+" Peso "+caballo1.getPeso()+" Vel "+caballo1.getVelocidad();
		MiLogger.info(texto);
	}

}
