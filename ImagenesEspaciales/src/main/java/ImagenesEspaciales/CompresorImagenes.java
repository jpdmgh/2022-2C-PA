package ImagenesEspaciales;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompresorImagenes {
	final static String rutaArchivos = "C:\\Users\\JPDM\\eclipse-workspace\\ImagenesEspaciales\\src\\main\\resources\\";
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner entrada = new Scanner(new File(rutaArchivos + "imagenes.in"));
		PrintWriter salida = new PrintWriter(new File(rutaArchivos + "imagenes.out"));
		String registroOut;	
		
		while (entrada.hasNext()) {
			String registroIn = entrada.nextLine();

			if (registroIn.contains("(")) {
				registroOut = descomprimir(registroIn);
			} else {
				registroOut = comprimir(registroIn);
			}
			salida.println(registroOut);
		}
		salida.close();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static String descomprimir(String registroIn) {
		char[] arrayCaracteres = new char[250];	
		int j=0;
		
		for (int i = 0; i < registroIn.length(); i++) {
   
			if (registroIn.charAt(i) == '(') {
				int cantRepet = Character.getNumericValue(registroIn.charAt(i+2));
				for (int k = 0; k < cantRepet; k++) {
					arrayCaracteres[j] = registroIn.charAt(i+1);
					j++;
				}
				i=i+3;
			} else {
				arrayCaracteres[j] = registroIn.charAt(i);
				j++;
			}
		}
		String registroOut=String.valueOf(arrayCaracteres);
		return registroOut;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static String comprimir(String registroIn) {
		char[] arrayCaracteres = new char[250];	
		int tamanio =registroIn.length();
		int j=0;
		
		for (int i = 0; i < registroIn.length(); i++) {
			int contador=1;
			int aux=i+1;
			while (aux != tamanio && registroIn.charAt(i) == registroIn.charAt(aux) ) {
				contador++;
				aux++;
			}
			if (contador>4) {
				arrayCaracteres[j] = '(';
				arrayCaracteres[j+1] = registroIn.charAt(i);
				arrayCaracteres[j+2] = Character.forDigit(contador, 10); 
				arrayCaracteres[j+3] = ')';
				j=j+4;
			} else {
				for (int k = 0; k < contador; k++) {
					arrayCaracteres[j] = registroIn.charAt(i);
					j++;
				}
			}	
			i=(aux-1);
		}
		String registroOut=String.valueOf(arrayCaracteres);
		return registroOut;
	}
}
