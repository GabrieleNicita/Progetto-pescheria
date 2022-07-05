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
import com.TN.Pescheria.IService.IPrezziService;
import com.TN.Pescheria.Model.AnagraficaPesci;
import com.TN.Pescheria.Model.Prezzi;

@Controller
@RequestMapping("/Pesci")
public class AnagraficaPesciController {
	
	@Autowired 
	IAnagraficaPesciService anagraficaPesciService;
	@Autowired
	IPrezziService prezziService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path="/Aggiungi") 
	public @ResponseBody AnagraficaPesci nuovoPesce(@RequestBody AnagraficaPesci pesce) {
		pesce.setPrezzi(trovaprezzo(pesce.getPrezzi().getPrezzo()));
		return anagraficaPesciService.inserimentoPesci(pesce);
		
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},path="/Modifica") 
	public @ResponseBody AnagraficaPesci modificaPesce (@RequestBody AnagraficaPesci pesce) {
		return anagraficaPesciService.modificaPesci(pesce);
		}
	@DeleteMapping(path="/Cancella/{idpesce}") 
	public @ResponseBody void cancellaPesce (@PathVariable(value="idpesce")Integer idpesce) {
		anagraficaPesciService.eliminaPesce(idpesce);
		
	}
	
	@GetMapping(path="/") 
	public @ResponseBody List<AnagraficaPesci> listaPesci () {
		return anagraficaPesciService.mostraPesci();
	}
	
	public Prezzi trovaprezzo(Double prezzo){
		if (prezziService.trovaPrezzoinbasealcosto(prezzo).isPresent()){
			return prezziService.trovaPrezzoinbasealcosto(prezzo).get();
		}else{
			Prezzi prz = new Prezzi(prezzo);
			return prezziService.inserimentoPrezzo(prz);
		}
		
	}
	@GetMapping(path="/Modifica/{id}/{prezzo}")
	public @ResponseBody String modificaByPrezzoId(@PathVariable(value="id")Integer idpesce,@PathVariable(value="prezzo") double prezzo ) {
		AnagraficaPesci pesce =new AnagraficaPesci();
		pesce=anagraficaPesciService.trovaById(idpesce).get();
		pesce.setPrezzi(trovaprezzo(prezzo));
		anagraficaPesciService.modificaPesci(pesce);
		return "Pesce Modificato";
	}
}
