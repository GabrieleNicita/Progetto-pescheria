package com.TN.Pescheria.IService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.TN.Pescheria.Model.AnagraficaPesci;


public interface IAnagraficaPesciService {
	AnagraficaPesci inserimentoPesci(AnagraficaPesci pesce);
	AnagraficaPesci modificaPesci(AnagraficaPesci pesce);
	void eliminaPesce(int idpesce);
	List<AnagraficaPesci> mostraPesci();

}
