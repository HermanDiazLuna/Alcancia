package net.hdiaz.alcancia.entities;

public class Moneda1000 extends Moneda{
	
	private String tipo;
	
	public Moneda1000(String tipo, Integer valor, Integer cantidad) {
		super(valor, cantidad);
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
