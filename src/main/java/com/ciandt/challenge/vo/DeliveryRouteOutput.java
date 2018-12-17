package com.ciandt.challenge.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"rota",
	"custo"
})
public class DeliveryRouteOutput {
	
	private String rota;
	private BigDecimal custo;
	
	public String getRota() {
		return rota;
	}
	public void setRota(String rota) {
		this.rota = rota;
	}
	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
}
