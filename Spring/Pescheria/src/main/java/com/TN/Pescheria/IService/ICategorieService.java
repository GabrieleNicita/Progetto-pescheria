package com.TN.Pescheria.IService;

import java.util.List;


import com.TN.Pescheria.Model.Categorie;

public interface ICategorieService {
	Categorie inserimentoCategoria(Categorie categoria);
	Categorie modificaCategoria(Categorie categoria);
	void eliminaCategoria(int idcategoria);
	List<Categorie> mostracategoria();
}
