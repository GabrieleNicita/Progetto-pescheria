package com.TN.Pescheria.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.TN.Pescheria.IService.IAnagraficaPesciService;
import com.TN.Pescheria.IService.ICategorieService;
import com.TN.Pescheria.Model.AnagraficaPesci;
import com.TN.Pescheria.Model.Categorie;
@RequestMapping("/Categorie")
public class CategorieController {
	@Autowired 
	ICategorieService categorieService;
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},path="/Aggiungi") 
	public @ResponseBody Categorie nuovoCategoria(@RequestBody Categorie categoria) {
		return categorieService.inserimentoCategoria(categoria);
		
	}
	
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},path="/Modifica") 
	public @ResponseBody Categorie modificaCategoria (@RequestBody Categorie categoria) {
		return categorieService.modificaCategoria(categoria);
		}
	@DeleteMapping(path="/Cancella/{id}") 
	public @ResponseBody String cancellaCategoria (@PathVariable(value="id") int idcategoria) {
		categorieService.eliminaCategoria(idcategoria);
		return "ELIMINATO CORRETTAMENTE";
	}
	
	@GetMapping(path="/") 
	public @ResponseBody List<Categorie> listaCategorie () {
		return categorieService.mostracategoria();
	}
}
