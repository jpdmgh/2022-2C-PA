package ArmandoMoviles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Colgantes{
	List<Integer> pesos = new ArrayList<Integer>();

	public boolean agregar(Integer peso) {
		return pesos.add(peso);
	}
	
	public void mostrar() {
		for (Integer integer : pesos) {
			System.out.print(integer+"\t");
		}
		System.out.println("");
	}
	
	public void ordenarDesc() {
		Collections.sort(this.pesos, Collections.reverseOrder());
	}
	
	public void ordenarAsc() {
		Collections.sort(this.pesos);
	}
	
	public Moviles calcularPares() {
		Map<Integer, Integer> armandoMoviles = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < this.pesos.size(); i++) {
			// si ya existe ese valor
			if (armandoMoviles.containsKey(this.pesos.get(i))) {
				armandoMoviles.put(this.pesos.get(i), armandoMoviles.get(this.pesos.get(i)) + 1);
			} else {
				armandoMoviles.put(this.pesos.get(i), 1);
			}
		}
		// mostrar MAPA
		for (Map.Entry<Integer, Integer> ocurrencia : armandoMoviles.entrySet()) {
				System.out.printf("%d -> %d%n", ocurrencia.getKey(), ocurrencia.getValue());
		}
		//https://www.youtube.com/watch?v=Ee-5VJhzExU
		
		int cantDePares=0;
		int pesoTotal=0;
		for (Integer clavePeso : armandoMoviles.keySet()) {
			if ( (armandoMoviles.get(clavePeso) % 2) == 0 ) {
				cantDePares++;
				pesoTotal += (clavePeso * armandoMoviles.get(clavePeso));
			}		
		}
		
		Moviles m2 = new Moviles();	
		m2.setVarillasNecesarias(cantDePares);
		m2.setPesoTotal(pesoTotal);
		
		return m2;
	}
}
