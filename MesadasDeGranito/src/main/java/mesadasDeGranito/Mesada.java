package mesadasDeGranito;

import luchadoresJaponeses.Luchador;

public class Mesada implements Comparable<Mesada>{
	int id;
	int largo;
	int ancho;
	int superficie;
	boolean apilada;
	
	public Mesada(int id, int largo, int ancho, int superficie, boolean apilada) {
		super();
		this.id	= id;
		this.largo = largo;
		this.ancho = ancho;
		this.superficie = superficie;
		this.apilada = apilada;
	}
	
	public boolean evaluarApilarEncima(Mesada mesadaAapilar) {
		if (this.id == mesadaAapilar.id) {
			return false;
		}
		if ((this.superficie) < (mesadaAapilar.superficie)) {
			return false;
		}
		if (    (this.largo >= mesadaAapilar.largo && this.ancho >= mesadaAapilar.ancho) 
			 || (this.largo >= mesadaAapilar.ancho && this.ancho >= mesadaAapilar.largo) ) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Mi id es:" + this.id 
				+ ", mi largo es:" + this.largo 
				+ ", mi ancho es:" + this.ancho
				+ ", mi superficie es:" + this.superficie
				+ ", estoy apilada:" + this.apilada;
	}
	//https://www.youtube.com/watch?v=kE_B0E3zh_k
	//https://www.youtube.com/watch?v=EPQJDGI2pFA
	public int compareTo(Mesada m) {
		int estado = 0;
		if (m.getSuperficie() < this.superficie) {
			estado = -1;
		} else if (m.getSuperficie() > this.superficie) {
			estado = +1;
		}
		return estado;
   }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public boolean isApilada() {
		return apilada;
	}

	public void setApilada(boolean apilada) {
		this.apilada = apilada;
	}
}
