package net.hdiaz.alcancia.services;

import java.util.Map;
import net.hdiaz.alcancia.entities.Moneda;

public interface IMonedaService {
	
	public void agregarMoneda(Moneda moneda);
	public Map<String, Object> actualizarAlcancia();
	
}
