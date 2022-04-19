package net.hdiaz.alcancia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.hdiaz.alcancia.entities.Moneda;
import net.hdiaz.alcancia.services.IMonedaService;

@RestController
@RequestMapping("/api")
public class MonedaController {
	
	@Autowired
	private IMonedaService iMonedaService;
	
	@PostMapping("/agregar-moneda")
	public ResponseEntity<?> agregar(@RequestBody Moneda moneda){
		iMonedaService.agregarMoneda(moneda);
		return ResponseEntity.status(HttpStatus.CREATED).body("ok");
	}
	
	@GetMapping("/mostrar-alcancia")
	public ResponseEntity<?> contenidoAlcancia(){
		return ResponseEntity.ok(iMonedaService.actualizarAlcancia());
	}
	
}
