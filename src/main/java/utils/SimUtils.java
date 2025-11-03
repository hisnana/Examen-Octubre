package utils;

import java.util.Random;
import java.util.Scanner;

public class SimUtils {

	//metodo calcularEdad al cual le pasamos un año y le devolvemos la edad apatir de ese año.
	
	public static int calcularEdad (int ano) {
		
		int añoActual = 2025;
		int resultado = añoActual - ano;
		return resultado;
		
	}
	
	public static void pintaMenu (String[] arrayStrings) {
		
		for (String palabra : arrayStrings) {
			System.out.println(palabra);
		}
		System.out.println("Introduce una opción");
		
	}
	public static void pintaMenu (String[] arrayStrings,String texto) {
		
		for (String palabra : arrayStrings) {
			System.out.println(palabra);
		}
		System.out.println(texto);
		
	}
	
	public static int pideDatoNumerico(String texto) {
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		return num;
	}
	
	public static String pideDatoCadena(String texto){
		System.out.println(texto);
		Scanner scan = new Scanner(System.in);
		String dato= scan.nextLine();
		return dato;
		
	}
	
	public static int generarNumRandom(int num) {
		Random random = new Random();
		int numAleatorio= random.nextInt(num);
		
		return numAleatorio;
	}
	
}


