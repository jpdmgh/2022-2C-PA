package ArmandoMoviles;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorDeArchivo {
	
	private String nombreArchivo;
	final String rutaArchivos ="src/main/resources/";
	
	public GestorDeArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Colgantes leer(String nombreArchivo) {
		Colgantes c1 = new Colgantes();
		Scanner archIn = null;
		
		try {
			archIn = new Scanner (new File (rutaArchivos+this.nombreArchivo));
			
			int cantColgantes = archIn.nextInt();// Leer la cantidad de pesos.
			
			while (archIn.hasNext()) {
				c1.agregar(archIn.nextInt());
			}	
			archIn.close();
		} catch (Exception e)  {
			e.printStackTrace();
		} finally {

		}
		return c1;
	}
	
	public void escribir(Moviles m3) {
		PrintWriter archOut = null;
		
		try {
			archOut = new PrintWriter(new File(rutaArchivos + "colgantes.out"));
			archOut.println(m3.getPesoTotal()+" "+m3.getVarillasNecesarias());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		archOut.close();
	}
}
