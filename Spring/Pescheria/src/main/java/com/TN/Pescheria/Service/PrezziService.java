package com.TN.Pescheria.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TN.Pescheria.IService.IPrezziService;
import com.TN.Pescheria.Model.AnagraficaPesci;
import com.TN.Pescheria.Model.Prezzi;
import com.TN.Pescheria.Repository.AnagraficaPesciRepository;
import com.TN.Pescheria.Repository.PrezziRepository;
@Service
public class PrezziService implements IPrezziService{
	@Autowired
	private PrezziRepository repository;
	@Transactional
	@Override
	public Prezzi inserimentoPrezzo(Prezzi prezzo) {
		return repository.save(prezzo);
	}
	@Transactional
	@Override
	public Prezzi modificaPrezzo(Prezzi prezzo) {
		return repository.save(prezzo);
	}
	@Transactional
	@Override
	public void eliminaPrezzo(int idprezzo) {
		repository.deleteById(idprezzo);
	}
	@Transactional
	@Override
	public List<Prezzi> mostraPrezzo() {
		return (List<Prezzi>) repository.findAll();
	}
	@Transactional
	@Override
	public Optional<Prezzi> trovaPrezzo(Integer idprezzo) {
		return repository.findById(idprezzo);
	}
	@Transactional
	@Override
	public Optional<Prezzi> trovaPrezzoinbasealcosto(Double prezzo) {
		return repository.findByprezzo(prezzo);
	}
}
