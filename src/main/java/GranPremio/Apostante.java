package GranPremio;

import GranPremio.Interfaces.Imprimible;
import utils.MiLogger;

public class Apostante extends Persona implements Imprimible {
	private double saldo;
	

	public Apostante(String nombre, int edad, double saldo) {
		super(nombre, edad);
		this.saldo = saldo;
	}

	@Override
	public void imprimeDatos() {
		String texto ="El apostante "+ this.getNombre()+" tiene saldo: "+this.getSaldo();
		MiLogger.info(texto);
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void actualizarSaldo(double importe) {
		
		this.saldo+=importe;
		
	}


}
