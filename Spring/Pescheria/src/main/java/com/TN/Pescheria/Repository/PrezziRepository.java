package com.TN.Pescheria.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TN.Pescheria.Model.Prezzi;
@Repository
public interface PrezziRepository extends CrudRepository<Prezzi, Integer>{
	
 Optional<Prezzi> findByprezzo(Double prezzo);
}
