package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

/**
 * 
 * @author Andressa Albuquerque
 *
 */
public class CandlestickBuilderTest {

	@Test
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
		new CandleBuilder().comAbertura(1).comFechamento(1).comMinimo(1)
				.comMaximo(1).comVolume(1).comData(Calendar.getInstance()).build();
	}

}
