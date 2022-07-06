package com.TN.Pescheria.Controller;


import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.TN.Pescheria.IService.IAnagraficaPesciService;
import com.TN.Pescheria.IService.ICategorieService;
import com.TN.Pescheria.IService.IPrezziService;
import com.TN.Pescheria.IService.ITrattamentiService;
import com.TN.Pescheria.Model.AnagraficaPesci;
import com.TN.Pescheria.Model.Modifica;
import com.TN.Pescheria.Model.Prezzi;

@Controller
@RequestMapping("/Pesci")
public class AnagraficaPesciController {
	
	@Autowired 
	IAnagraficaPesciService anagraficaPesciService;
	@Autowired
	IPrezziService prezziService;
	@Autowired
	ICategorieService categorieService;
	@Autowired
	ITrattamentiService trattamentiService;
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path="/Aggiungi") 
	public @ResponseBody AnagraficaPesci nuovoPesce(@RequestParam("image")MultipartFile multipartFile,@RequestBody AnagraficaPesci pesce) throws IOException{
		pesce.setPrezzi(trovaprezzo(pesce.getPrezzi().getPrezzo()));
		return anagraficaPesciService.inserimentoPesci(pesce);
		
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},path="/Modifica") 
	public @ResponseBody AnagraficaPesci modificaPesce (@RequestBody Modifica m) {
		trovaprezzo(m.getPrezzi().getPrezzo());
		AnagraficaPesci pesci=new AnagraficaPesci(m.getPesci().getIdpesce(),m.getPesci().getNome(),m.getPesci().getDescrizione(),prezziService.trovaPrezzoinbasealcosto(m.getPrezzi().getPrezzo()).get(),categorieService.trovaCategoriadanome(m.getCategorie().getCategoria()).get(),trattamentiService.trovaTrattamentoByDescriione(m.getTrattamenti().getTrattamento()).get());
		
		return anagraficaPesciService.inserimentoPesci(pesci);
		
		}
	@DeleteMapping(path="/Cancella/{idpesce}") 
	public @ResponseBody void cancellaPesce (@PathVariable(value="idpesce")Integer idpesce) {
		anagraficaPesciService.eliminaPesce(idpesce);
		
	}
	
	@GetMapping(path="/") 
	public @ResponseBody List<AnagraficaPesci> listaPesci () {
		return anagraficaPesciService.mostraPesci();
	}
	@GetMapping(path="/Modifica/{id}/{prezzo}")
	public @ResponseBody String modificaByPrezzoId(@PathVariable(value="id")Integer idpesce,@PathVariable(value="prezzo") double prezzo ) {
		AnagraficaPesci pesce =new AnagraficaPesci();
		pesce=anagraficaPesciService.trovaById(idpesce).get();
		pesce.setPrezzi(trovaprezzo(prezzo));
		anagraficaPesciService.modificaPesci(pesce);
		return "Pesce Modificato";
	}
	public Prezzi trovaprezzo(Double prezzo){
		if (prezziService.trovaPrezzoinbasealcosto(prezzo).isPresent()){
			return prezziService.trovaPrezzoinbasealcosto(prezzo).get();
		}else{
			Prezzi prz = new Prezzi(prezzo);
			return prezziService.inserimentoPrezzo(prz);
		}
	}
}
