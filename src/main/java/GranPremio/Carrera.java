package GranPremio;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
	private String nombre;
	private int distanciaObjetivo;
	private List<Caballo> caballosParticipantes;
	private List<Jinete> jinetesParticipantes;
	private List<Apuesta> apuestas;
	


	public Carrera(String nombre, int distanciaObjetivo) {
		super();
		this.nombre = nombre;
		this.distanciaObjetivo = distanciaObjetivo;
		this.caballosParticipantes = new ArrayList<Caballo>();
		this.jinetesParticipantes = new ArrayList<Jinete>();
		this.apuestas = new ArrayList<Apuesta>();
	}


	public double getDistanciaObjetivo() {
		return distanciaObjetivo;
	}


	public void setDistanciaObjetivo(int distanciaObjetivo) {
		this.distanciaObjetivo = distanciaObjetivo;
	}


	public List<Jinete> getJinetesParticipantes() {
		return jinetesParticipantes;
	}


	public void setJinetesParticipantes(List<Jinete> jinetesParticipantes) {
		this.jinetesParticipantes = jinetesParticipantes;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Caballo> getCaballosParticipantes() {
		return caballosParticipantes;
	}
	public void setCaballosParticipantes(List<Caballo> caballosParticipantes) {
		this.caballosParticipantes = caballosParticipantes;
	}


	public List<Apuesta> getApuestas() {
		return apuestas;
	}

	public void setApuestas(List<Apuesta> apuestas) {
		this.apuestas = apuestas;
	}
	
	

}
