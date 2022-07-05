package com.TN.Pescheria.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TN.Pescheria.Model.Categorie;
@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer>{
Optional<Categorie> findByCategoria(String categoria);
}
