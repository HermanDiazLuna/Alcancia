package net.hdiaz.alcancia.entities;

public class Moneda100 extends Moneda{
	
	private String tipo;
	
	public Moneda100(String tipo, Integer valor, Integer cantidad) {
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
