package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {

	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;
	
	private boolean aberturaPreenchido = false;
	private boolean fechamentoPreenchido = false;
	private boolean minimoPreenchido = false;
	private boolean maximoPreenchido = false;
	private boolean volumePreenchido = false;

	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		this.aberturaPreenchido = true;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		this.fechamentoPreenchido = true;
		return this;
	}

	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		this.minimoPreenchido = true;
		return this;
	}

	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		this.maximoPreenchido = true;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		this.volumePreenchido = true;
		return this;
	}

	public CandleBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}

	public Candlestick build() {
		validaCandle();
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}

	private void validaCandle() {
		if (!aberturaPreenchido || !fechamentoPreenchido || !minimoPreenchido || !maximoPreenchido
				|| !volumePreenchido) {
			throw new IllegalStateException("Construcao invalida");
		}
	}

}
