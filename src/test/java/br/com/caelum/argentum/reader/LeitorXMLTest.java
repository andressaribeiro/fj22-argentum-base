package br.com.caelum.argentum.reader;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

/**
 * 
 * @author Andressa Albuquerque
 *
 */
public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
				"				<negociacao>" +
				"					<preco>43.5</preco>" +
				"					<quantidade>1000</quantidade>" +
				"					<data>" +
				"						<time>1322233344455</time>" +
				"					</data>" +
				"				</negociacao>" +
				"			</list>";
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		Negociacao n = negociacoes.get(0);
		
		assertEquals(1, negociacoes.size());
		assertEquals(43.5, n.getPreco(), 0.00001);
		assertEquals(1000, n.getQuantidade(), 0.00001);
	}

	@Test
	public void carregaXmlComZeroNegociacoes() {
		String xmlDeTeste = "<list>" +
				"			</list>";
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		assertEquals(0, negociacoes.size());
	}
	
	@Test
	public void carregaXmlComTresNegociacoes() {
		String xmlDeTeste = "<list>" +
				"				<negociacao>" +
				"					<preco>43.5</preco>" +
				"					<quantidade>1000</quantidade>" +
				"					<data>" +
				"						<time>1322233344455</time>" +
				"					</data>" +
				"				</negociacao>" +
				"				<negociacao>" +
				"					<preco>43.5</preco>" +
				"					<quantidade>1000</quantidade>" +
				"					<data>" +
				"						<time>1322233344455</time>" +
				"					</data>" +
				"				</negociacao>" +
				"				<negociacao>" +
				"					<preco>43.5</preco>" +
				"					<quantidade>1000</quantidade>" +
				"					<data>" +
				"						<time>1322233344455</time>" +
				"					</data>" +
				"				</negociacao>" +
				"			</list>";
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
		assertEquals(3, negociacoes.size());
		
	}
}
