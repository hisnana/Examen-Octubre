package GranPremio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.MiLogger;
import utils.SimUtils;

public class GranPremio {
	private String nombre;
	private List<Carrera> carreras;
	private List<Apostante> apostantes;
	


	public GranPremio(String nombre) {
		super();
		this.nombre = nombre;
		this.carreras = new ArrayList<Carrera>();
		this.apostantes = new ArrayList<Apostante>();
	}

	//Getters and setters

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<Carrera> getCarreras() {
		return carreras;
	}



	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public List<Apostante> getApostantes() {
		return apostantes;
	}



	public void setApostantes(List<Apostante> apostantes) {
		this.apostantes = apostantes;
	}


	



	public void empezarGranPremio(GranPremio granPremio) {
		
		Carrera carrera1 = new Carrera("Carrera1",100);
		Carrera carrera2 = new Carrera("Carrera2",200);
		Carrera carrera3 = new Carrera("Carrera3",400);
		granPremio.getCarreras().add(carrera1);
		granPremio.getCarreras().add(carrera2);
		granPremio.getCarreras().add(carrera3);
		
		Apostante apostante1 = new Apostante("apostate1",33,200);
		Apostante apostante2 = new Apostante("apostate2",20,400);
		Apostante apostante3 = new Apostante("apostate3",55,500);
		granPremio.getApostantes().add(apostante1);
		granPremio.getApostantes().add(apostante2);
		granPremio.getApostantes().add(apostante3);
		
		
		Jinete jinete1 = new Jinete("Pepe",35);
		Jinete jinete2 = new Jinete("Paco",35);
		Jinete jinete3 = new Jinete("Pedro",35);
		Caballo caballo1 =new Caballo("Rocinante",jinete1);
		Caballo caballo2 =new Caballo("caballo2",jinete2);
		Caballo caballo3 =new Caballo("caballo3",jinete3);
		caballo1.imprimeDatos();
		caballo2.imprimeDatos();
		caballo3.imprimeDatos();
		
		carrera1.getJinetesParticipantes().add(jinete1);
		carrera1.getJinetesParticipantes().add(jinete2);
		carrera1.getJinetesParticipantes().add(jinete3);
		
		carrera1.getCaballosParticipantes().add(caballo1);
		carrera1.getCaballosParticipantes().add(caballo2);
		carrera1.getCaballosParticipantes().add(caballo3);
		
		carrera2.getJinetesParticipantes().add(jinete1);
		carrera2.getJinetesParticipantes().add(jinete2);
		carrera2.getJinetesParticipantes().add(jinete3);
		
		carrera2.getCaballosParticipantes().add(caballo1);
		carrera2.getCaballosParticipantes().add(caballo2);
		carrera2.getCaballosParticipantes().add(caballo3);
		
		carrera3.getJinetesParticipantes().add(jinete1);
		carrera3.getJinetesParticipantes().add(jinete2);
		carrera3.getJinetesParticipantes().add(jinete3);
		
		carrera3.getCaballosParticipantes().add(caballo1);
		carrera3.getCaballosParticipantes().add(caballo2);
		carrera3.getCaballosParticipantes().add(caballo3);
		
	}
	
	public void apuestas(Carrera carrera) {
		Map<String,Caballo> mapaCaballos = new HashMap<>();
		for (Caballo caballo : carrera.getCaballosParticipantes()) {
			mapaCaballos.put(caballo.getNombre(), caballo);
		}
		for (Apostante apostante : this.apostantes) {
			MiLogger.info("El apostante "+apostante.getNombre()+" con el saldo "+apostante.getSaldo());
			String nombreCaballo = SimUtils.pideDatoCadena("Introduce el caballo por el que apuestas");
			
		}
		for(Apuesta apuesta : carrera.getApuestas() ) {
			
		}
	}
	
	public boolean comenzarCarrera(Carrera carrera) {
		boolean ganador = false;
		for (Caballo caballo : carrera.getCaballosParticipantes()) {
			
			
			if(caballo.getJinete()!= null&&caballo.getMetrosRecorridos()<carrera.getDistanciaObjetivo()) {
				
				int avance = caballo.calcularAvanceTurno();
				caballo.aplicarAvance(avance);
				ganador = false;
				

			}
			if(caballo.getMetrosRecorridos()>=carrera.getDistanciaObjetivo()) {
				ganador = true;
				MiLogger.info("El caballo "+caballo.getNombre()+" es el canador de la carrera "+carrera.getNombre());
				continue;
			}

		}
		return ganador;
		
	}

	public void mostrarResumen() {
		
	}


}
