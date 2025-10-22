package GranPremio;

public class Jinete extends Persona {
	private int aniosExperiencia;


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
	
	

}
