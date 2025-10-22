package GranPremio;

import java.util.List;

public class Carrera {
	private String nombre;
	private int numMetros;
	private List<Caballo> caballosParticipantes;
	private List<Apuesta> apuestas;
	
	public Carrera(String nombre, int numMetros) {
		super();
		this.nombre = nombre;
		this.numMetros = numMetros;
	}
	
	
	public Carrera(String nombre, int numMetros, List<Caballo> caballosParticipantes) {
		super();
		this.nombre = nombre;
		this.numMetros = numMetros;
		this.caballosParticipantes = caballosParticipantes;
	}
	
	


	public Carrera(String nombre, int numMetros, List<Caballo> caballosParticipantes, List<Apuesta> apuestas) {
		super();
		this.nombre = nombre;
		this.numMetros = numMetros;
		this.caballosParticipantes = caballosParticipantes;
		this.apuestas = apuestas;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumMetros() {
		return numMetros;
	}
	public void setNumMetros(int numMetros) {
		this.numMetros = numMetros;
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
