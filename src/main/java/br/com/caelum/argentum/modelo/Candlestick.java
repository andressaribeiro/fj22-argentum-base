package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author Andressa Albuquerque
 *
 */
public class Candlestick {

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;

	protected Candlestick(double abertura, double fechamento, double minimo, double maximo,
			double volume, Calendar data) {
		if (data == null) {
			throw new IllegalArgumentException("A Data nao pode ser nula!");
		}

		if (abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0) {
			throw new IllegalArgumentException("O valor nao pode ser negativo!");
		}
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;

		if (maximo < minimo) {
			throw new IllegalArgumentException(
					"O valor maximo nao pode ser maior que o valor minimo!");
		}
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	public boolean isAlta() {
		return this.abertura < this.fechamento || this.abertura == this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		sb.append(" Abertura: ").append(abertura);
		sb.append(" Fechamento: ").append(fechamento);
		sb.append(" Minima: ").append(minimo);
		sb.append(" Maxima: ").append(maximo);
		sb.append(" Volume: ").append(volume);
		sb.append(" Data: ").append(formatter.format(data.getTime()));

		return sb.toString();
	}

}
