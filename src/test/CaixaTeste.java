package test;

import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app.Bit;
import app.ValorInvalidoException;

public class CaixaTeste {

	private static final int VALOR_VALIDO = 1;
	
	Bit bit = null;
	
	@Before
	public void setup() {
		bit = new Bit();
	}
	
	@After
	public void tearDown() {
		bit = null;		
	}

	@Test(expected = ValorInvalidoException.class)
	public void valorMenorQueZero() throws ValorInvalidoException {
		bit.retornaValorEQuantidadeCedulas(-1);
	}

	@Test(expected = ValorInvalidoException.class)
	public void passouDoValorMaximo() throws ValorInvalidoException {
		bit.retornaValorEQuantidadeCedulas(10001);
	}

	@Test
	public void passandoUmValorValido() throws ValorInvalidoException {
		bit.retornaValorEQuantidadeCedulas(1);
	}

	@Test
	public void validandoRetornoNotNull() throws ValorInvalidoException {
		Map<Integer, Integer> retorno = bit.retornaValorEQuantidadeCedulas(VALOR_VALIDO);
		Assert.assertNotNull(retorno);
	}

	@Test
	public void validandoRetornoLengthEquals4() throws ValorInvalidoException {
		Map<Integer, Integer> retorno = bit.retornaValorEQuantidadeCedulas(VALOR_VALIDO);
		Assert.assertEquals(4, retorno.size());
	}

	@Test
	public void validaSeValorRetornoEhPositivo() throws ValorInvalidoException {
		Map<Integer, Integer> retorno = bit.retornaValorEQuantidadeCedulas(VALOR_VALIDO);
		for (int numeroNotas : retorno.values()) {
			boolean ehPositivo = numeroNotas >= 0;
			Assert.assertTrue(ehPositivo);
		}
	}

	@Test
	public void validaValoresProSaque1Bit() throws ValorInvalidoException {
		
		Map<Integer, Integer> retorno = bit.retornaValorEQuantidadeCedulas(VALOR_VALIDO);
		int valorCalculado = QuantidadeDeNotas(retorno);
		Assert.assertEquals(1, valorCalculado);
	}

	@Test
	public void validaValoresProSaque7Bits() throws ValorInvalidoException {
		
		Map<Integer, Integer> retorno = bit.retornaValorEQuantidadeCedulas(7);
		int valorCalculado = QuantidadeDeNotas(retorno);
		Assert.assertEquals(7, valorCalculado);
	}
	@Test
	public void validaValoresProSaque28Bits() throws ValorInvalidoException {
		
		Map<Integer, Integer> retorno = bit.retornaValorEQuantidadeCedulas(28);
		int valorCalculado = QuantidadeDeNotas(retorno);
		Assert.assertEquals(28, valorCalculado);
	}
	@Test
	public void validaValoresProSaque15Bits() throws ValorInvalidoException {
		
		Map<Integer, Integer> retorno = bit.retornaValorEQuantidadeCedulas(15);
		int valorCalculado = QuantidadeDeNotas(retorno);
		Assert.assertEquals(15, valorCalculado);
	}
	
	@Test
	public void validaValoresProSaque58Bits() throws ValorInvalidoException {
		
		Map<Integer, Integer> retorno = bit.retornaValorEQuantidadeCedulas(58);
		int valorCalculado = QuantidadeDeNotas(retorno);
		Assert.assertEquals(58, valorCalculado);
	}
	
	@Test
	public void validaValoresProSaque100Bits() throws ValorInvalidoException {
		
		Map<Integer, Integer> retorno = bit.retornaValorEQuantidadeCedulas(100);
		int valorCalculado = QuantidadeDeNotas(retorno);
		Assert.assertEquals(100, valorCalculado);
	}
	
	private Integer QuantidadeDeNotas(Map<Integer, Integer> v) {
		int total = 0;
		for(int i : v.keySet())
		{
			total += v.get(i);
		}
		return total;
	}
	
}
