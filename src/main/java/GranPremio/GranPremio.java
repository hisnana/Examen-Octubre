package GranPremio;

import java.util.ArrayList;
import java.util.List;

import utils.MiLogger;

public class GranPremio {
	private String nombre;
	private List<Carrera> carreras;
	private List<Apostante> apostantes;
	


	public GranPremio(String nombre) {
		super();
		this.nombre = nombre;
		this.carreras = new ArrayList();
		this.apostantes = new ArrayList();
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
		
	}
	


	public void mostrarResumen() {
		
	}


}
