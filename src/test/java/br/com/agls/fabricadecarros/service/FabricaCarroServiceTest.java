package br.com.agls.fabricadecarros.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.agls.fabricadecarros.entiity.Carro;
import br.com.agls.fabricadecarros.exceptions.AtributoNuloException;
import br.com.agls.fabricadecarros.service.interfaces.CarroService;

public class FabricaCarroServiceTest {

	@Test
	@DisplayName("Salvar carro")
	public void deveSalvarCarroAoFornecerUmCarroValido() {
		Carro carro = new Carro("Chevrolet", "Onix", "Preto");
		CarroService carroService = new CarroServiceImpl();
		
		Carro carroFabricado = carroService.fabricarCarro(carro);
		
		assertNotNull(carroFabricado.getAnoFabricacao());
		assertNotNull(carroFabricado.getChassi());
	}
	
	@Test
	@DisplayName("Fabricante não informado")
	public void deveLancarAtributoNuloExceptionQuandoOFabricanteNaoForInformado() {
		Carro carro = new Carro(null, "Onix", "Preto");
		CarroService carroService = new CarroServiceImpl();
		
		assertThrows(AtributoNuloException.class, () -> {
			carroService.fabricarCarro(carro);
		});
	}
	
	@Test
	@DisplayName("Modelo não informado")
	public void deveLancarAtributoNullExceptionQuandoOModeloNaoForInformado() {
		Carro carro = new Carro("Hyundai", null, "Cinza");
		CarroService carroService = new CarroServiceImpl();
		
		assertThrows(AtributoNuloException.class, () -> {
			carroService.fabricarCarro(carro);
		});
	}
	
	@Test
	@DisplayName("Cor não informada")
	public void deveUsarCorBrancaQuandoACorNaoForInformada() {
		Carro carro = new Carro("Fiat", "Mobi", null);
		CarroService carroService = new CarroServiceImpl();
		
		carroService.fabricarCarro(carro);
		
		assertEquals("Branco", carro.getCor());
	}
	
	@Test
	@DisplayName("Validar se foi criado")
	public void deveValidarSeOCarroFoiCriado() {
		Carro carro = new Carro("Volkswagem", "Polo", "Branco");
		CarroService carroService = new CarroServiceImpl();
		
		carroService.fabricarCarro(carro);
		
		assertTrue(carro.isEstaFabricado());
	}
}
