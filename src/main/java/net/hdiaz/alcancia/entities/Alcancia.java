package net.hdiaz.alcancia.entities;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.isNull;

public class Alcancia {
	
	private List<Moneda> monedas;

	public List<Moneda> getMonedas() {
		if(isNull(monedas)){
            monedas=new ArrayList<Moneda>();
        }
        return monedas;
	}

	public void setMoneda(Moneda moneda) {
		getMonedas().add(moneda);
	}
	
}
