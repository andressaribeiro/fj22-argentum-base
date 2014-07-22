package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void candlestickComDataNula() {
		new Candlestick(10, 20, 20, 20, 10000, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void candlestickComValoresNegativos() {
		new Candlestick(-10, -10, -10, -10, -10, Calendar.getInstance());
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {
		Candlestick candle = new Candlestick(10, 10, 10, 10, 10, Calendar.getInstance());
		Assert.assertTrue(candle.isAlta());
	}
}
