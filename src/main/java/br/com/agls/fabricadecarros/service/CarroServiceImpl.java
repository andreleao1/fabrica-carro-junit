package br.com.agls.fabricadecarros.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import br.com.agls.fabricadecarros.entiity.Carro;
import br.com.agls.fabricadecarros.exceptions.AtributoNuloException;
import br.com.agls.fabricadecarros.service.interfaces.CarroService;

public class CarroServiceImpl implements CarroService {
	
	private static final String MSG_ATRIBUTO_NULO = "O atribto %s está nulo.";

	@Override
	public Carro fabricarCarro(Carro carro) {
		validarFabricante(carro.getFabricante());
		validarModelo(carro.getModelo());
		carro.setCor(validarCor(carro.getCor()));
		carro.setAnoFabricacao(LocalDate.now().getYear());
		carro
		.setChassi(carro.getAnoFabricacao().toString() + LocalDate.now().getMonthValue() + LocalDateTime.now());
		carro.setEstaFabricado(true);
		return carro;
	}
	
	private void validarFabricante(String fabricante) {
		if (Objects.isNull(fabricante)) {
			String mensagem = String.format(MSG_ATRIBUTO_NULO, "Fabricante");
			throw new AtributoNuloException(mensagem);
		}
	}
	
	private void validarModelo(String modelo) {
		if (modelo == null) {
			String mensagem = String.format(MSG_ATRIBUTO_NULO, "Modelo");
			throw new AtributoNuloException(mensagem);
		}
	}
	
	private String validarCor(String cor) {
		if (Objects.isNull(cor)) {
			return "Branco";
		}		
		return cor;
	}

}
