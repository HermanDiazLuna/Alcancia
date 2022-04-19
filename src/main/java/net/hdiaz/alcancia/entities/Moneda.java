package net.hdiaz.alcancia.entities;

public class Moneda {
	
	private Integer valor;
	private Integer cantidad;
	
	public Moneda(Integer valor, Integer cantidad) {
		super();
		this.valor = valor;
		this.cantidad = cantidad;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
}
