package GranPremio;

import GranPremio.Interfaces.Imprimible;

public class Apostante extends Persona implements Imprimible {
	private double saldo;
	
	public Apostante(String nombre, int edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}

	public Apostante(String nombre, int edad, double saldo) {
		super(nombre, edad);
		this.saldo = saldo;
	}

	@Override
	public String imprimeDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
