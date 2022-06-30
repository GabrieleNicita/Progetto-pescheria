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

import com.TN.Pescheria.IService.IAnagraficaPesciService;
import com.TN.Pescheria.Model.AnagraficaPesci;

@Controller
@RequestMapping("/Pesci")
public class AnagraficaPesciController {
	
	@Autowired 
	IAnagraficaPesciService anagraficaPesciService;
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path="/Aggiungi") 
	public @ResponseBody AnagraficaPesci nuovoPesce(@RequestBody AnagraficaPesci pesce) {
		return anagraficaPesciService.inserimentoPesci(pesce);
		
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},path="/Modifica") 
	public @ResponseBody AnagraficaPesci modificaPesce (@RequestBody AnagraficaPesci pesce) {
		return anagraficaPesciService.modificaPesci(pesce);
		}
	@DeleteMapping(path="/Cancella/{id}") 
	public @ResponseBody String cancellaPesce (@PathVariable(value="id") int idpesce) {
		anagraficaPesciService.eliminaPesce(idpesce);
		return "ELIMINATO CORRETTAMENTE";
	}
	
	@GetMapping(path="/") 
	public @ResponseBody List<AnagraficaPesci> listaPesci () {
		return anagraficaPesciService.mostraPesci();
	}
}
