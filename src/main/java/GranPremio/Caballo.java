package GranPremio;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import GranPremio.Interfaces.Avanzable;
import GranPremio.Interfaces.Imprimible;
import GranPremio.Interfaces.Participable;
import GranPremio.Interfaces.Reseteable;
import utils.MiLogger;
import utils.SimUtils;

public class Caballo implements Reseteable,Participable,Avanzable,Imprimible {
	
	private String nombre;
	private double peso;
	private int velocidad;
	private int experiencia;
	private Jinete jinete;
	private int metrosRecorridos;
	private String id;
	
	public Caballo(String nombre, Jinete jinete) {
		super();
		
		this.nombre = nombre;
		this.peso = ThreadLocalRandom.current().nextInt(20, 30);
		this.velocidad = ThreadLocalRandom.current().nextInt(20, 51);
		this.experiencia = ThreadLocalRandom.current().nextInt(0, 10);
		this.jinete = jinete;
		
	}
	
	@Override
	public void restear() {
		
		this.metrosRecorridos = 0;
	}
	
	void sumarExperiencia(int puntos) {
		this.experiencia+=puntos;
		
	}
	@Override
	public String getId() {
		this.id= this.getNombre()+SimUtils.generarNumRandom(100);
		return id;
	}
	@Override
	public int calcularAvanceTurno() {
		// TODO Auto-generated method stub
		int baseAleatoria= SimUtils.generarNumRandom(10);
		MiLogger.info("La base aleatoria es "+baseAleatoria);
		int avanceMetros= (int) (baseAleatoria+velocidad+experiencia-peso+jinete.getAniosExperiencia());
		if (avanceMetros < 0) {
			avanceMetros = 0;
		}
		MiLogger.info("El caballo "+nombre+" avanza "+avanceMetros);
		return avanceMetros;
	}
	@Override
	public void aplicarAvance(double avanceMetros) {
		this.metrosRecorridos+=avanceMetros;
		
	}
	@Override
	public void imprimeDatos() {
		String texto = nombre+" Exp "+experiencia+" Peso "+peso+" Vel "+velocidad+" y su jinete es "+jinete.getNombre();
		MiLogger.info(texto);
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPeso() {
		return peso;
	}

	public double getVelocidad() {
		return velocidad;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	public Jinete getJinete() {
		return jinete;
	}
	public void setJinete(Jinete jinete) {
		this.jinete = jinete;
	}
	public int getMetrosRecorridos() {
		return metrosRecorridos;
	}
	public void setMetrosRecorridos(int metrosRecorridos) {
		this.metrosRecorridos = metrosRecorridos;
	}
	
	
}
