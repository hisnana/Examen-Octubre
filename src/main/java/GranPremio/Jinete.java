package GranPremio;

import java.util.Random;

import GranPremio.Interfaces.Participable;

public class Jinete extends Persona implements Participable {
	private int aniosExperiencia;
	private String id;


	public Jinete(String nombre, int edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}


	public Jinete(String nombre, int edad, int aniosExperiencia) {
		super(nombre, edad);
		this.aniosExperiencia = aniosExperiencia;
	}


	public int getAniosExperiencia() {
		return aniosExperiencia;
	}


	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}


	@Override
	public String getId() {
		Random random = new Random();
		this.id= this.getNombre()+random.nextInt(100);
		return id;
	}
	
	

}
