package com.TN.Pescheria.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TN.Pescheria.Model.Categorie;
import com.TN.Pescheria.Model.Trattamenti;
@Repository
public interface TrattamentiRepository extends CrudRepository<Trattamenti,Integer>{
	Optional<Trattamenti> findByTrattamento(String trattamento);
}
