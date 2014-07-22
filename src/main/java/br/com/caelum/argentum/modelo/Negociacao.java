package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao {

	private final double preco;
	private final int quantidade;
	private final Calendar data;

	public Negociacao(double preco, int quantidade, Calendar data) {
		if (data == null || quantidade < 0 || preco <= 0) {
			throw new IllegalArgumentException("Valor invalido!");
		}
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}

	public double getVolume() {
		return preco * quantidade;
	}

	public boolean isMesmoDia(Calendar outraData) {
		return this.data.get(Calendar.DAY_OF_MONTH) == outraData
				.get(Calendar.DAY_OF_MONTH)
				&& this.data.get(Calendar.DAY_OF_YEAR) == outraData
						.get(Calendar.DAY_OF_YEAR)
				&& this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
	}

}
