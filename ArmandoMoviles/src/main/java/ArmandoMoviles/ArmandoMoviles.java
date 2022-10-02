package ArmandoMoviles;

public class ArmandoMoviles {
/*	Creo una clase ArmandoMoviles para el main
 * 	Creo una clase GestorDeArchivos para leer y escribir
 *  En el GestorDeArchivos.leer declaro un objeto de la clase Colgantes cuyo atributo es una lista de pesos
 *  (podria haber sido un array de int), la clase Colgantes tiene un metodo agregar que recibe un peso y lo 
 *  aniade (no junca la enie) a la lista
 */

	public static void main(String[] args) {
		// generar una sola instancia arch, el leer lee el in y el escribir graba el out
		GestorDeArchivo archivoIn  = new GestorDeArchivo("colgantes.in");
		GestorDeArchivo archivoOut = new GestorDeArchivo("colgantes.out");
		
		Colgantes c2 = new Colgantes();
		c2=archivoIn.leer(null);
		//c2.mostrar();
		//c2.ordenarDesc();
		//c2.mostrar();
		
		Moviles m1 = new Moviles();
		m1=c2.calcularPares();
		archivoOut.escribir(m1);
		
		System.out.println("Fin ok");
	}

}
