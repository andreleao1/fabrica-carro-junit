package br.com.agls.fabricadecarros.entiity;

public class Carro {

	private String fabricante;
	private String modelo;
	private String cor;
	private String chassi;
	private Integer anoFabricacao;
	private boolean estaFabricado;
	
	public Carro(String fabricante, String modelo, String cor) {
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.cor = cor;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public boolean isEstaFabricado() {
		return estaFabricado;
	}

	public void setEstaFabricado(boolean estaFabricado) {
		this.estaFabricado = estaFabricado;
	}	
}
