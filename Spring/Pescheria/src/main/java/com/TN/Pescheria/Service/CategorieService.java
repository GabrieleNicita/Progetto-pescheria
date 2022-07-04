package com.TN.Pescheria.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TN.Pescheria.IService.ICategorieService;

import com.TN.Pescheria.Model.Categorie;

import com.TN.Pescheria.Repository.CategorieRepository;

@Service
public class CategorieService implements ICategorieService{
	@Autowired
	private CategorieRepository repository;
	@Transactional
	@Override
	public Categorie inserimentoCategoria(Categorie categoria) {
		return repository.save(categoria);
	}
	@Transactional
	@Override
	public Categorie modificaCategoria(Categorie categoria) {
		return repository.save(categoria);
	}
	@Transactional
	@Override
	public void eliminaCategoria(int idcategoria) {
		repository.deleteById(idcategoria);
	}
	@Transactional
	@Override
	public List<Categorie> mostracategoria() {
		return (List<Categorie>) repository.findAll();
	}
	@Transactional
	@Override
	public Optional<Categorie> trovaCategorie(Integer idcategoria) {
		return repository.findById(idcategoria);
	}
}
