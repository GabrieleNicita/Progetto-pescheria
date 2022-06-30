package com.TN.Pescheria.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TN.Pescheria.IService.ICategorieService;

import com.TN.Pescheria.Model.Categorie;

import com.TN.Pescheria.Repository.CategorieRepository;
@Service
public class CategorieService implements ICategorieService{
	@Autowired
	private CategorieRepository repository;

	@Override
	public Categorie inserimentoCategoria(Categorie categoria) {
		return repository.save(categoria);
	}

	@Override
	public Categorie modificaCategoria(Categorie categoria) {
		return repository.save(categoria);
	}

	@Override
	public void eliminaCategoria(int idcategoria) {
		repository.deleteById(idcategoria);
	}

	@Override
	public List<Categorie> mostracategoria() {
		return (List<Categorie>) repository.findAll();
	}

	@Override
	public Optional<Categorie> trovaCategorie(Integer idcategoria) {
		return repository.findById(idcategoria);
	}
}
