package com.TN.Pescheria.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TN.Pescheria.IService.IPrezziService;
import com.TN.Pescheria.Model.AnagraficaPesci;
import com.TN.Pescheria.Model.Prezzi;
import com.TN.Pescheria.Repository.AnagraficaPesciRepository;
import com.TN.Pescheria.Repository.PrezziRepository;
@Service
public class PrezziService implements IPrezziService{
	@Autowired
	private PrezziRepository repository;

	@Override
	public Prezzi inserimentoPrezzo(Prezzi prezzo) {
		return repository.save(prezzo);
	}

	@Override
	public Prezzi modificaPrezzo(Prezzi prezzo) {
		return repository.save(prezzo);
	}

	@Override
	public void eliminaPrezzo(int idprezzo) {
		repository.deleteById(idprezzo);
	}

	@Override
	public List<Prezzi> mostraPrezzo() {
		return (List<Prezzi>) repository.findAll();
	}
}
