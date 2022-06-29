package com.TN.Pescheria.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TN.Pescheria.Model.AnagraficaPesci;
@Repository
public interface AnagraficaPesciRepository extends CrudRepository<AnagraficaPesci, Integer>{

}
