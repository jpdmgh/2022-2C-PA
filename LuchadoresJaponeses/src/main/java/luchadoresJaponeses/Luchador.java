package luchadoresJaponeses;

public class Luchador {
	private int id;
	private int peso;
	private int altura;
	private int cantContrincantesAtractivos;

	public Luchador(int id, int peso, int altura, int cantContrincantesAtractivos) {
		super();
		this.id = id;
		this.peso = peso;
		this.altura = altura;
		this.cantContrincantesAtractivos = cantContrincantesAtractivos;
	}

	public int getCantContrincantesAtractivos() {
		return cantContrincantesAtractivos;
	}

	public void setCantContrincantesAtractivos(int cantContrincantesAtractivos) {
		this.cantContrincantesAtractivos = cantContrincantesAtractivos;
	}
	
	public boolean evaluarContrincanteAtractivo(Luchador posibleContrincante) {
		if (this.id == posibleContrincante.id) {
			return false;
		}
		if (this.peso > posibleContrincante.peso &&  this.altura > posibleContrincante.altura) {
			return true;
		}
		if (this.peso == posibleContrincante.peso && this.altura > posibleContrincante.altura) {
			return true;
		}
		if (this.peso > posibleContrincante.peso && this.altura == posibleContrincante.altura ) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Mi id es:" + this.id 
				+ ", mi peso es:" + this.peso 
				+ ", mi altura es:" + this.altura
				+ " y mi cantidad de contrincantes es: " + this.cantContrincantesAtractivos;
	}

}
