package GranPremio;

import GranPremio.Interfaces.Avanzable;
import GranPremio.Interfaces.Imprimible;
import GranPremio.Interfaces.Participable;
import GranPremio.Interfaces.Reseteable;
import utils.MiLogger;
import utils.Utilidades;

public class Caballo implements Reseteable,Participable,Avanzable,Imprimible {
	
	private String nombre;
	private double peso;
	private double velocidad;
	private int experiencia;
	private Jinete jinete;
	private double metrosRecorridos;
	
	
	public Caballo(String nombre, Jinete jinete) {
		super();
		this.nombre = nombre;
		this.peso = crearPeso();
		this.velocidad = crearVelocidad();
		this.experiencia = crearExperiencia();
		this.jinete = jinete;
		
	}
	double crearPeso() {
		//Calcular peso aleatorio pero entre 200 y 300 kg
		double peso = Math.random()*100;
		if (peso < 20) {
			peso = 20;
		} else if (peso > 30) {
			peso= 30;
		}
		return peso;
		
	}
	double crearVelocidad() {
		//Tiene que ser entre 20 y 50
		double velocidad = Math.random()*100;
		if (velocidad<20) {
			velocidad = 20;
		} else if (velocidad > 50) {
			velocidad = 50;
		}
		return velocidad;
	}
	
	int crearExperiencia() {
		//tiene que ser entre o 10
		int experiencia = Utilidades.generarNumRandom();
		return experiencia;
	}
	@Override
	public void restear() {
		// TODO Auto-generated method stub
		
	}
	
	void sumarExperiencia(int puntos) {
		
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double calcularAvanceTurno() {
		// TODO Auto-generated method stub
		int baseAleatoria= (int) (Math.random()*10);
		MiLogger.info("La base aleatoria es"+baseAleatoria);
		int avanceMetros= (int) (baseAleatoria+velocidad+experiencia-peso+jinete.getAniosExperiencia());
		if (avanceMetros < 0) {
			avanceMetros = 0;
		}
		MiLogger.info("El caballo "+nombre+" avanza "+avanceMetros);
		return avanceMetros;
	}
	@Override
	public void aplicarAvance(double avanceMetros) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String imprimeDatos() {
		// TODO Auto-generated method stub
		return null;
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
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
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
	public double getMetrosRecorridos() {
		return metrosRecorridos;
	}
	public void setMetrosRecorridos(double metrosRecorridos) {
		this.metrosRecorridos = metrosRecorridos;
	}
	
	
}
