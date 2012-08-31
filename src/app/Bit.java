package app;

import java.util.HashMap;
import java.util.Map;

public class Bit {

	private static final int VALORMINIMO = 0;
	
	private static final int VALORMAXIMO = 10000;
	
	public Map<Integer, Integer> retornaValorEQuantidadeCedulas(int valor) throws ValorInvalidoException {
		if (isValorValido(valor)){
			Map<Integer, Integer> valoresNotas = 
					new HashMap<Integer, Integer>();
			
			valoresNotas.put(50, 0);
			valoresNotas.put(10, 0);
			valoresNotas.put(5, 0);
			valoresNotas.put(1, 0);
			
			int resto = valor;
			for (Integer valorNota : valoresNotas.keySet()) {
				
				int qtdNotas = (int) resto/valorNota;
				resto = getResto(resto, valorNota);
				
				valoresNotas.put(valorNota, qtdNotas);
				
			}
			
			return valoresNotas;
			
		} else {
			throw new ValorInvalidoException();
		}
	}

	private int getResto(int valor, int nota) {
		int resto;
		resto = valor % nota;
		return resto;
	}

	private boolean isValorValido(int valor) {
		return valor <= VALORMAXIMO && valor >=VALORMINIMO;
	}
}
