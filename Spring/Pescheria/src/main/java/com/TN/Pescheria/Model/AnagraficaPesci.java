package com.TN.Pescheria.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity

@Table(name = "anagraficapesci")
public class AnagraficaPesci {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_anagrafica")
	@JsonProperty("id")
	private Integer idpesce;

	@Column(length=25)
	private String nome;
	
	@Column(length=200)
	private String descrizione;
	@Column(length = 250)
	private String fotoPesce; 
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="id_prezzi")
	@JsonProperty("prezzo")
	Prezzi prezzi;
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="id_categorie")
	@JsonProperty("categoria")
	Categorie categorie;
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="id_trattamenti")
	@JsonProperty("trattamento")
	Trattamenti trattamenti;
	public AnagraficaPesci() {};
	public AnagraficaPesci(Integer idpesce,String nome,String descrizione) {
		this.idpesce=idpesce;
		this.nome=nome;
		this.descrizione=descrizione;
	};
	public AnagraficaPesci(Integer idpesce,String nome,String descrizione,Prezzi prezzi,Categorie categorie,Trattamenti trattamenti) {
		this.idpesce=idpesce;
		this.nome=nome;
		this.descrizione=descrizione;
		this.prezzi=prezzi;
		this.categorie=categorie;
		this.trattamenti=trattamenti;
	};

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setIdpesce(Integer idpesce) {
		this.idpesce = idpesce;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPrezzi(Prezzi prezzi) {
		this.prezzi = prezzi;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public void setTrattamenti(Trattamenti trattamenti) {
		this.trattamenti = trattamenti;
	}
	public Integer getIdpesce() {
		return idpesce;
	}
	public String getNome() {
		return nome;
	}
	public Prezzi getPrezzi() {
		return prezzi;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public Trattamenti getTrattamenti() {
		return trattamenti;
	}
	public String getFotoPesce() {
		return fotoPesce;
	}
	public void setFotoPesce(String fotoPesce) {
		this.fotoPesce = fotoPesce;
	}
}
