package com.TN.Pescheria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TN.Pescheria.IService.IPrezziService;
import com.TN.Pescheria.Model.Prezzi;
@Controller
@RequestMapping("/Prezzi")
public class PrezziController {
	@Autowired 
	IPrezziService prezziService;
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path="/Aggiungi") 
	public @ResponseBody Prezzi nuovoPrezzo(@RequestBody Prezzi prezzo) {
		return prezziService.inserimentoPrezzo(prezzo);
	}
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path="/Modifica") 
	public @ResponseBody Prezzi modificaPrezzo(@RequestBody Prezzi prezzo) {
		return prezziService.inserimentoPrezzo(prezzo);
	}
	
	@DeleteMapping(path="/Cancella/{id}") 
	public @ResponseBody String cancellaPrezzo(@PathVariable(value="id") int idprezzo) {
		prezziService.eliminaPrezzo(idprezzo);
		return "ELIMINATO CORRETTAMENTE";
	}
	@GetMapping(path="/") 
	public @ResponseBody List<Prezzi> listaPrezzi() {
		return prezziService.mostraPrezzo();
	}
	@GetMapping(path="/{id}") 
	public @ResponseBody Prezzi prezzoPerId(@PathVariable(value="id") int idprezzo) {
		return prezziService.trovaPrezzo(idprezzo).get();
	}
}
