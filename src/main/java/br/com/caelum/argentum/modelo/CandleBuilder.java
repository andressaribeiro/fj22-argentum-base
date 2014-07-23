package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {

	private Candlestick candlestick;

	private double abertura;
	private double fechamento;
	private double minimo;
	private double maximo;
	private double volume;
	private Calendar data;

	public CandleBuilder() {
	}

	public CandleBuilderAbertura comAbertura(double abertura) {
		return new CandleBuilderAbertura(abertura);
	}

	public class CandleBuilderAbertura {
		private CandleBuilderAbertura(double a) {
			abertura = a;
		}

		public CandleBuilderFechamento comFechamento(double fechamento) {
			return new CandleBuilderFechamento(fechamento);
		}
	}

	public class CandleBuilderFechamento {
		private CandleBuilderFechamento(double f) {
			fechamento = f;
		}

		public CandleBuilderMinimo comMinimo(double minimo) {
			return new CandleBuilderMinimo(minimo);
		}
	}

	public class CandleBuilderMinimo {
		private CandleBuilderMinimo(double min) {
			minimo = min;
		}

		public CandleBuilderMaximo comMaximo(double maximo) {
			return new CandleBuilderMaximo(maximo);
		}
	}

	public class CandleBuilderMaximo {
		private CandleBuilderMaximo(double max) {
			maximo = max;
		}

		public CandleBuilderVolume comVolume(double volume) {
			return new CandleBuilderVolume(volume);
		}
	}

	public class CandleBuilderVolume {
		private CandleBuilderVolume(double v) {
			volume = v;
		}

		public CandleBuilderData comData(Calendar data) {
			return new CandleBuilderData(data);
		}
	}


	public class CandleBuilderData {
		public CandleBuilderData(Calendar d) {
			data = d;

		}

		public Candlestick build() {
			candlestick = new Candlestick(abertura, fechamento, minimo, maximo,
					volume, data);
			
			return candlestick;
		}

	}

}
