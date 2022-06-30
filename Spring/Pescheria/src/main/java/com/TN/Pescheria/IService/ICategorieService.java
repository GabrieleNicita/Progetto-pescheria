package com.TN.Pescheria.IService;

import java.util.List;
import java.util.Optional;

import com.TN.Pescheria.Model.Categorie;

public interface ICategorieService {
	Categorie inserimentoCategoria(Categorie categoria);
	Categorie modificaCategoria(Categorie categoria);
	Optional<Categorie> trovaCategorie(Integer idcategoria);
	void eliminaCategoria(int idcategoria);
	List<Categorie> mostracategoria();
	
}
