package com.TN.Pescheria.Repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.TN.Pescheria.Model.AnagraficaPesci;
@Repository
public interface AnagraficaPesciRepository extends CrudRepository<AnagraficaPesci, Integer>{
	@Modifying
	@Query("delete from AnagraficaPesci ap where ap.idpesce= ?1")
	void delete(Integer id);
	
	
}
