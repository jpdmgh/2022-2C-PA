package mesadasDeGranito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class MesadaDeGranito {
	final static String rutaArchivosIn = "C:\\Users\\JPDM\\eclipse-workspace\\MesadasDeGranito\\src\\main\\resources\\";
	final static String rutaArchivosOut = "C:\\Users\\JPDM\\eclipse-workspace\\mesadasJaponeses\\src\\main\\resources\\";
	// private static Mesada[] mesadas;
	private static List<Mesada> mesadas = new ArrayList<Mesada>();

	public static void main(String[] args) throws FileNotFoundException {
		mesadas = leerArchivoConScanner("mesadas.in");
		int cantPilas=calcularPilas();
		grabarArchivoOut("mesada.out", cantPilas);
		System.out.println("Fin ok");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static List<Mesada> leerArchivoConScanner(String nombreArchivo) throws FileNotFoundException {
		Scanner entrada = new Scanner(new File(rutaArchivosIn + nombreArchivo));
//  Especifica la configuración regional que se va a utilizar
//  entrada.useLocale(Locale.ENGLISH); // entrada.useLocale(new Locale("es_AR"));

// 	Leo la cant de mesadas y creo un vector
		int cantDeMesadas = (entrada.nextInt());
		List<Mesada> mesadas = new ArrayList<Mesada>(cantDeMesadas);

		// Vuelco el archivo a un vector
		int largo, ancho, i = 0;
		while (entrada.hasNext()) {
			largo = entrada.nextInt();
			ancho = entrada.nextInt();
			mesadas.add(new Mesada(i, largo, ancho, (largo * ancho), false));
			i++;
		}
		entrada.close();
		// Devuelvo las mesadas ordenadas por superficie
		Collections.sort(mesadas);

		return mesadas;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static int calcularPilas() {
		mesadas.get(0).apilada = true;
		int cantPilas = 1;
		for (int i = 0; i < mesadas.size(); i++) {
			for (int j = 0; j < mesadas.size(); j++) {
				if (i != j && !mesadas.get(j).apilada) {
					if (mesadas.get(i).evaluarApilarEncima((Mesada) mesadas.get(j))) {
						mesadas.get(j).apilada = true;
					} else {
						cantPilas++;
						mesadas.get(j).apilada = true;
					}
				}
			}
		}
//		for (Mesada mesada : mesadas) {
//			System.out.println(mesada);
//		}
		return cantPilas;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void grabarArchivoOut(String nombreArchivo, int cantPilas) throws FileNotFoundException {
		PrintWriter salida = new PrintWriter(new File(rutaArchivosIn + nombreArchivo)); // escribir archivo
		salida.println(cantPilas);
		salida.close();
	}

}
