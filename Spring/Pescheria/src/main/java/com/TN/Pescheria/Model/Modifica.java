package com.TN.Pescheria.Model;

public class Modifica {
private AnagraficaPesci pesce;
private Categorie categorie;
private Trattamenti trattamenti;
private Prezzi prezzi;


public Categorie getCategorie() {
	return categorie;
}
public AnagraficaPesci getPesci() {
	return pesce;
}
public Trattamenti getTrattamenti() {
	return trattamenti;
}
public Prezzi getPrezzi() {
	return prezzi;
}
public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}
public void setPesce(AnagraficaPesci pesce) {
	this.pesce = pesce;
}
public void setPrezzi(Prezzi prezzi) {
	this.prezzi = prezzi;
}
public void setTrattamenti(Trattamenti trattamenti) {
	this.trattamenti = trattamenti;
}

}
