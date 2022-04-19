package net.hdiaz.alcancia.repositories;

import net.hdiaz.alcancia.entities.Alcancia;

public class AlcanciaRepository {
	
	private static Alcancia alcancia = new Alcancia();

	public Alcancia getAlcancia() {
		return alcancia;
	}

	public void vaciarAlcancia() {
		alcancia.getMonedas().clear();
	}
	
	
}
