package com.TN.Pescheria.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.TN.Pescheria.Model.Trattamenti;
@Repository
public interface TrattamentiRepository extends CrudRepository<Trattamenti,Integer>{

}
