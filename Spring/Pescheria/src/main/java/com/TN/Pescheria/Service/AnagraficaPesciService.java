package com.TN.Pescheria.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TN.Pescheria.IService.IAnagraficaPesciService;
import com.TN.Pescheria.Model.AnagraficaPesci;
import com.TN.Pescheria.Repository.AnagraficaPesciRepository;
@Service
public class AnagraficaPesciService implements IAnagraficaPesciService{
@Autowired
private AnagraficaPesciRepository repository;

@Override
public AnagraficaPesci inserimentoPesci(AnagraficaPesci pesce) {
	return repository.save(pesce);
}

@Override
public AnagraficaPesci modificaPesci(AnagraficaPesci pesce) {
	return repository.save(pesce);

}

@Override
public void eliminaPesce(int idpesce) {
repository.deleteById(idpesce);
}

@Override
public List<AnagraficaPesci> mostraPesci() {
	return (List<AnagraficaPesci>) repository.findAll();
	
}
}
