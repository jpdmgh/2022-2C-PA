package luchadoresJaponeses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Torneo {
	final static String rutaArchivosIn = "C:\\Users\\JPDM\\eclipse-workspace\\LuchadoresJaponeses\\src\\main\\resources\\";
	final static String rutaArchivosOut = "C:\\Users\\JPDM\\eclipse-workspace\\LuchadoresJaponeses\\src\\main\\resources\\";
	private static Luchador[] luchadores;
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) throws FileNotFoundException {
		luchadores = leerArchivoConScanner("sumo.in");
		calcularContrincantes();
		grabarArchivoOut("sumo.out");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static Luchador[] leerArchivoConScanner(String nombreArchivo) throws FileNotFoundException {
		Scanner entrada = new Scanner(new File(rutaArchivosIn + nombreArchivo));
		//  Especifica la configuración regional que se va a utilizar
		//  entrada.useLocale(Locale.ENGLISH); // entrada.useLocale(new Locale("es_AR"));
		
		// 	Leo la cant de luchadores y creo un vector
		int cantDeLuchadores=(entrada.nextInt());
		Luchador[] luchadores = new Luchador[cantDeLuchadores];
		
		//	Vuelco el archivo a un vector
		int peso, altura, i=0;
		while(entrada.hasNext()) {							
			peso 	= entrada.nextInt();
			altura 	= entrada.nextInt();
			luchadores[i] = new Luchador(i, peso, altura, 0);
			i++;
		}
		entrada.close();
//		for (Luchador luchador : luchadores) {
//			System.out.println(luchador);
//		}
		return luchadores;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void calcularContrincantes () {
		for (int i = 0; i < luchadores.length; i++) {
			int cantContrincantesAtractivos=0;
			for (int j = 0; j < luchadores.length; j++) {
				if (i!=j) {
					if (luchadores[i].evaluarContrincanteAtractivo(luchadores[j])) {
						cantContrincantesAtractivos++;
					}
				}
			}
			luchadores[i].setCantContrincantesAtractivos(cantContrincantesAtractivos);
		}
//		for (Luchador luchador : luchadores) {
//		    System.out.println(luchador);
//	    }
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void grabarArchivoOut(String nombreArchivo) throws FileNotFoundException {
		PrintWriter salida = new PrintWriter(new File (rutaArchivosIn + nombreArchivo)); // escribir archivo
		for (Luchador luchador : luchadores) {
			salida.println(luchador.getCantContrincantesAtractivos());
		}
		salida.close();	
	}
}