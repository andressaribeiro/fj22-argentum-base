package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author Andressa Albuquerque
 *
 */
public final class Negociacao implements Comparable<Negociacao> {

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

	@Override
	public int compareTo(Negociacao n) {
		if (n.getData().after(data)) {
			return -1;
		}
		
		if (n.getData().before(data)) {
			return 1;
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		sb.append(" Preço: ").append(preco);
		sb.append(" Quantidade: ").append(preco);
		sb.append(" Data: ").append(formatter.format(data));
		
		return sb.toString();
	}

}
