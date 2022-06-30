package com.TN.Pescheria.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TN.Pescheria.IService.IAnagraficaPesciService;
import com.TN.Pescheria.Model.AnagraficaPesci;
import com.TN.Pescheria.Repository.AnagraficaPesciRepository;
@Service
public class AnagraficaPesciService implements IAnagraficaPesciService{
@Autowired
private AnagraficaPesciRepository repository;
@Transactional
@Override
public AnagraficaPesci inserimentoPesci(AnagraficaPesci pesce) {
	return repository.save(pesce);
}
@Transactional
@Override
public AnagraficaPesci modificaPesci(AnagraficaPesci pesce) {
	return repository.save(pesce);

}
@Transactional
@Override
public void eliminaPesce(int idpesce) {
repository.deleteById(idpesce);
}
@Transactional
@Override
public List<AnagraficaPesci> mostraPesci() {
	return (List<AnagraficaPesci>) repository.findAll();
	
}
}
