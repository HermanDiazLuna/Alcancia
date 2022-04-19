package net.hdiaz.alcancia.entities;

public class Moneda200 extends Moneda{
	
	private String tipo;
	
	public Moneda200(String tipo, Integer valor, Integer cantidad) {
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
