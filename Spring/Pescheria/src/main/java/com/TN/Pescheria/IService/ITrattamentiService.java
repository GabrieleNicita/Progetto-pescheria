package com.TN.Pescheria.IService;

import java.util.List;
import java.util.Optional;

import com.TN.Pescheria.Model.Trattamenti;

public interface ITrattamentiService {
	Trattamenti inserimentoTrattamento(Trattamenti trattamento);
	Trattamenti modificaTrattamento(Trattamenti trattamento);
	void eliminaTrattamento(int idtrattamento);
	List<Trattamenti> mostraTrattamento();
	Optional<Trattamenti> trovaTrattamento(Integer idtrattamento);
	Optional<Trattamenti> trovaTrattamentoByDescriione(String trattamento);
}
