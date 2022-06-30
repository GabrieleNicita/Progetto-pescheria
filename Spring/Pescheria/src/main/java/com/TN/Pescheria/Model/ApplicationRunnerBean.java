package com.TN.Pescheria.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.TN.Pescheria.Repository.CategorieRepository;
import com.TN.Pescheria.Repository.TrattamentiRepository;

@Component
public class ApplicationRunnerBean implements ApplicationRunner{
	@Autowired
	TrattamentiRepository trattamentiRepository;
	@Autowired
	CategorieRepository categorieRepository;
	
   @Override
   public void run(ApplicationArguments arg0) throws Exception {
      Trattamenti primo= new Trattamenti(1,"Fresco");
      trattamentiRepository.save(primo);
      Trattamenti secondo= new Trattamenti(2,"Trasformato");
      trattamentiRepository.save(secondo);
      Categorie prima=new Categorie(1,"Acqua dolce");
      categorieRepository.save(prima);
      Categorie seconda=new Categorie(2,"Di mare");
      categorieRepository.save(seconda);
      Categorie terza=new Categorie(3,"Prodotto ittico");
      categorieRepository.save(terza);
   }
}