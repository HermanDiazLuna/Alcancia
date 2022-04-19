package net.hdiaz.alcancia.services;

import static java.util.Objects.isNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import net.hdiaz.alcancia.entities.Alcancia;
import net.hdiaz.alcancia.entities.Moneda;
import net.hdiaz.alcancia.entities.Moneda100;
import net.hdiaz.alcancia.entities.Moneda1000;
import net.hdiaz.alcancia.entities.Moneda200;
import net.hdiaz.alcancia.entities.Moneda50;
import net.hdiaz.alcancia.entities.Moneda500;
import net.hdiaz.alcancia.exceptions.AlcanciaExceptions;
import net.hdiaz.alcancia.repositories.AlcanciaRepository;
import net.hdiaz.alcancia.utils.TipoMoneda;

@Service
public class MonedaServiceImpl implements IMonedaService {

	AlcanciaRepository alcanciaRepository = new AlcanciaRepository();

	@Override
	public void agregarMoneda(Moneda moneda) {

		Alcancia alcancia = alcanciaRepository.getAlcancia();

		if (!isNull(moneda) && validarMonedas(moneda)) {
			alcancia.setMoneda(moneda);
		}else {
			throw new AlcanciaExceptions("ERROR, solo se reciben monedas de: 50, 100, 200, 500, 1000");
		}
		
	}

	@Override
	public Map<String, Object> actualizarAlcancia() {
		
		Map<String, Object> resultado = new HashMap<String, Object>();
		List<Moneda> listaMonedas = new ArrayList<Moneda>();
		
		List<Moneda> monedas = alcanciaRepository.getAlcancia().getMonedas();
		
		int cantidadMonedasTotal = monedas.size();
		int valorMonedasTotal = monedas.stream().collect(Collectors.summingInt(moneda -> moneda.getValor()));
		
		Moneda50 moneda50 = new Moneda50(TipoMoneda.MONEDA50, monedas.stream().filter(moneda -> moneda.getValor() == 50).collect(Collectors.summingInt(Moneda::getValor)), 
				(int) monedas.stream().filter(moneda -> moneda.getValor() == 50).count());
		listaMonedas.add(moneda50);	
		
		Moneda100 moneda100 = new Moneda100(TipoMoneda.MONEDA100, monedas.stream().filter(moneda -> moneda.getValor() == 100).collect(Collectors.summingInt(Moneda::getValor)),
				(int) monedas.stream().filter(moneda -> moneda.getValor() == 100).count());
		listaMonedas.add(moneda100);
		
		Moneda200 moneda200 = new Moneda200(TipoMoneda.MONEDA200, monedas.stream().filter(moneda -> moneda.getValor() == 200).collect(Collectors.summingInt(Moneda::getValor)), 
				(int) monedas.stream().filter(moneda -> moneda.getValor() == 200).count());
		listaMonedas.add(moneda200);
		
		Moneda500 moneda500 = new Moneda500(TipoMoneda.MONEDA500, monedas.stream().filter(moneda -> moneda.getValor() == 500).collect(Collectors.summingInt(Moneda::getValor)), 
				(int) monedas.stream().filter(moneda -> moneda.getValor() == 500).count());
		listaMonedas.add(moneda500);
		
		Moneda1000 moneda1000 = new Moneda1000(TipoMoneda.MONEDA1000, monedas.stream().filter(moneda -> moneda.getValor() == 1000).collect(Collectors.summingInt(Moneda::getValor)), 
				(int) monedas.stream().filter(moneda -> moneda.getValor() == 1000).count());
		listaMonedas.add(moneda1000);
		
		resultado.put("monedas", listaMonedas);
		resultado.put("cantidad total de monedas", cantidadMonedasTotal);
		resultado.put("valor total de las monedas", valorMonedasTotal);
		return resultado;
	}
 
	private boolean validarMonedas(Moneda moneda) {
		if (moneda.getValor()== 50 || moneda.getValor()== 100 || moneda.getValor()==200 || 
			moneda.getValor()==500 || moneda.getValor()== 1000) {
			return true;
		}
		return false;
	}

}
