package com.TN.Pescheria.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TN.Pescheria.IService.ITrattamentiService;
import com.TN.Pescheria.Model.Prezzi;
import com.TN.Pescheria.Model.Trattamenti;
import com.TN.Pescheria.Repository.AnagraficaPesciRepository;
import com.TN.Pescheria.Repository.TrattamentiRepository;
@Service
public class TrattamentiService implements ITrattamentiService{
	@Autowired
	private TrattamentiRepository repository;

	@Override
	public Trattamenti inserimentoTrattamento(Trattamenti trattamento) {
		return repository.save(trattamento);
	}

	@Override
	public Trattamenti modificaTrattamento(Trattamenti trattamento) {
		return repository.save(trattamento);
	}

	@Override
	public void eliminaTrattamento(int idtrattamento) {
		repository.deleteById(idtrattamento);
		
	}

	@Override
	public List<Trattamenti> mostraTrattamento() {
		return (List<Trattamenti>) repository.findAll();
	}
}
