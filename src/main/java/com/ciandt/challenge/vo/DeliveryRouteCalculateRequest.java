package com.ciandt.challenge.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"origem",
	"destino",
	"autonomia",
	"valor_do_litro"
})
public class DeliveryRouteCalculateRequest {
	@JsonProperty("origem")
	private String origem;
	
	@JsonProperty("destino")
	private String destino;
	
	@JsonProperty("autonomia")
	private BigDecimal autonomia;
	
	@JsonProperty("valor_do_litro")
	private BigDecimal valorDoLitro;
	
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public BigDecimal getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(BigDecimal autonomia) {
		this.autonomia = autonomia;
	}
	public BigDecimal getValorDoLitro() {
		return valorDoLitro;
	}
	public void setValorDoLitro(BigDecimal valorDoLitro) {
		this.valorDoLitro = valorDoLitro;
	}
}