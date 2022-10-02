package ErroresDeTipeo;

public class ErroresDeTipeo {

	private String texto;
	private String prueba;
	private int cantidadMovimientos = 0;

	public ErroresDeTipeo(String texto, String prueba) {
		super();
		this.texto = texto;
		this.prueba = prueba;
	}

	public String getTexto() {
		return texto;
	}

	public String getPrueba() {
		return prueba;
	}

	public void setCantidadMovimientos(int cantidadMovimientos) {
		this.cantidadMovimientos = cantidadMovimientos;
	}

	public int getCantidadMovimientos() {
		return cantidadMovimientos;
	}

	public void resolver() {
		// StringBuilder s = new StringBuilder(this.prueba);
		String s = this.prueba;
		for (int i = 0; i < this.texto.length() - 1; i++) {
			String letra = "" + this.texto.charAt(i); // obtengo la letra
			int posEncontrada = s.indexOf(letra);
			// int postEncontrada=s.indexOf(letra);

			// int posEncontrada=s.indexOf(this.texto.substring(i,i+1)); //busco la posicion
			// en el string desordenado
			this.setCantidadMovimientos(this.cantidadMovimientos + posEncontrada); // seteo los movimientos
			// s.deleteCharAt(posEncontrada); //elimino el char encontrado
			s = s.replaceFirst(letra, "");

		}

		System.out.println(this.getCantidadMovimientos());

	}

	public static void main(String[] args) {
		//ErroresDeTipeo p = GestorDeArchivos.leerArchivo("./src/main/resources/01_enunciado.in");
		//ErroresDeTipeo p = GestorDeArchivos.leerArchivo("./src/main/resources/02_palabra_ordenada.in");
		//ErroresDeTipeo p = GestorDeArchivos.leerArchivo("./src/main/resources/03_palabra_palindro.in");
		ErroresDeTipeo p = GestorDeArchivos.leerArchivo("./src/main/resources/04_Mayus_minusculas.in");
		p.resolver();
		//GestorDeArchivos.escribirArchivo("./src/main/resources/01_enunciado.out", p.getCantidadMovimientos());
		//GestorDeArchivos.escribirArchivo("./src/main/resources/02_palabra_ordenada.out", p.getCantidadMovimientos());
		//GestorDeArchivos.escribirArchivo("./src/main/resources/03_palabra_palindro.out", p.getCantidadMovimientos()),
		GestorDeArchivos.escribirArchivo("./src/main/resources/04_Mayus_minusculas.out", p.getCantidadMovimientos());

	}

}
