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
import com.TN.Pescheria.IService.ITrattamentiService;
import com.TN.Pescheria.Model.Categorie;
import com.TN.Pescheria.Model.Trattamenti;
@Controller
@RequestMapping("/Trattamenti")
public class TrattamentiController {
	@Autowired
	private ITrattamentiService trattamentiService;

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path="/Aggiungi") 
	public @ResponseBody Trattamenti nuovoTrattamento(@RequestBody Trattamenti trattamento) {
		return trattamentiService.inserimentoTrattamento(trattamento);
		
	}
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},path="/Modifica") 
	public @ResponseBody Trattamenti modificaTrattamenti (@RequestBody Trattamenti trattamento) {
		return trattamentiService.modificaTrattamento(trattamento);
		}
	@DeleteMapping(path="/Cancella/{id}") 
	public @ResponseBody String cancellaTrattamenti (@PathVariable(value="id") int idtrattamento) {
		trattamentiService.eliminaTrattamento(idtrattamento);
		return "ELIMINATO CORRETTAMENTE";
	}
	@GetMapping(path="/") 
	public @ResponseBody List<Trattamenti> listaTrattamenti () {
		return trattamentiService.mostraTrattamento();
	}
	@GetMapping(path="/{id}")
	public @ResponseBody Trattamenti trattamentoPerId (@PathVariable(value="id") int idtrattamento) {
		return trattamentiService.trovaTrattamento(idtrattamento).get();
	}
	@GetMapping(path = "/:{trattamento}")
	public @ResponseBody Trattamenti trattamentiPerDesc(@PathVariable(value="trattamento") String trattam) {
		return trattamentiService.trovaTrattamentoByDescriione(trattam).get();	
		}
}
