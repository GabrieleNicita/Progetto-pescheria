package com.TN.Pescheria.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.TN.Pescheria.IService.ITrattamentiService;
import com.TN.Pescheria.Model.Trattamenti;
import com.TN.Pescheria.Repository.TrattamentiRepository;

@Service
public class TrattamentiService implements ITrattamentiService{
	@Autowired
	private TrattamentiRepository repository;
	@Transactional
	@Override
	public Trattamenti inserimentoTrattamento(Trattamenti trattamento) {
		return repository.save(trattamento);
	}
	@Transactional
	@Override
	public Trattamenti modificaTrattamento(Trattamenti trattamento) {
		return repository.save(trattamento);
	}
	@Transactional
	@Override
	public void eliminaTrattamento(int idtrattamento) {
		repository.deleteById(idtrattamento);
		
	}
	@Transactional
	@Override
	public List<Trattamenti> mostraTrattamento() {
		return (List<Trattamenti>) repository.findAll();
	}
	@Transactional
	@Override
	public Optional<Trattamenti> trovaTrattamento(Integer idtrattamento) {
		return repository.findById(idtrattamento);
	}
	@Override
	public Optional<Trattamenti> trovaTrattamentoByDescriione(String trattamento) {
		return repository.findByTrattamento(trattamento);
	}
}
