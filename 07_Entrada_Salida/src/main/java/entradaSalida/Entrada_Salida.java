package entradaSalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Entrada_Salida {
	
	private int numMax=Integer.MIN_VALUE;
	private int numMin=Integer.MAX_VALUE;
	private int cantTotal;
	private int sumTotal;
	private int num;
	private float numAvg=0;
	
	public Entrada_Salida() {
	}
	
	public void generarArchPto1() throws FileNotFoundException {
		// Punto 1.Grabar archivo ------------------------------------------------------
		File outPto1 = new File ("fileNumeros.txt");			// escribir archivo	
		PrintWriter fileNumeros = new PrintWriter(outPto1);		// escribir archivo
		int cantIterar = (int) Math.floor(Math.random()*(20000-10000+1)+10000);
		for (int i = 0; i < cantIterar; i++) {
			// para conseguir un número entero entre M y N con M menor que N y ambos incluídos, 
			// debemos usar esta fórmula
			// int valorEntero = Math.floor(Math.random()*(N-M+1)+M);
			int valorEntero = (int) Math.floor(Math.random()*(12000-0+1)+0);
			fileNumeros.println(valorEntero);				   // escribir archivo
		}
		fileNumeros.close();								   // escribir archivo
	}
	
	public void generarArchPto3() throws FileNotFoundException {
		// Punto2.Leer archivo y calcular -----------------------------------------------
//		File in = new File ("fileNumeros.txt");				// leer archivo
//		Scanner entrada = new Scanner(in);					// leer archivo
		
		Scanner entrada = new Scanner(new File ("fileNumeros.txt"));
		
		while (entrada.hasNext()) {							// leer archivo
			num = entrada.nextInt();						// leer archivo
			if (num > numMax) {
				numMax = num;
			}
			if (num <numMin) {
				numMin = num;
			}
			sumTotal += num;
			cantTotal++;
		}
		entrada.close();									    // leer archivo
		
		numAvg=(float)sumTotal/(float)cantTotal;
		
//		File outPto3 = new File ("fileReporte.txt");			// escribir archivo	
//		PrintWriter fileReporte = new PrintWriter(outPto3);		// escribir archivo
		
		PrintWriter fileReporte = new PrintWriter(new File ("fileReporte.txt"));		// escribir archivo
		
		String txtdelimitador="+----------+-------+";
		String txtmaximo=  "| Maximo   "+String.format("| %5d |", numMax); // Pregunta: tendria que haber 
		String txtminimo=  "| Minimo   "+String.format("| %5d |", numMin); // usado this.numM..... ??
		String txtpromedio="| Promedio "+String.format("|%5.2f|", numAvg); // o asi esta ok ??
		
		
		fileReporte.println(txtdelimitador); //Primer delimitador
		fileReporte.println(txtmaximo);
		fileReporte.println(txtdelimitador); //Segundo delimitador
		fileReporte.println(txtminimo);
		fileReporte.println(txtdelimitador); //Tercer delimitador
		fileReporte.println(txtpromedio);
		fileReporte.println(txtdelimitador); //Cuarto delimitador
		
		fileReporte.close();	
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Entrada_Salida Ej07 = new Entrada_Salida();
		Ej07.generarArchPto1();
		Ej07.generarArchPto3();
	}

}
