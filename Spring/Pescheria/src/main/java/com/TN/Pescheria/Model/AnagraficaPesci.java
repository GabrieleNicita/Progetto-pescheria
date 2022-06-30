package com.TN.Pescheria.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "anagraficapesci")
public class AnagraficaPesci {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_anagrafica")
	private Integer idpesce;
	private String nome;
	
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="id_prezzi")
	Prezzi prezzi;
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="id_categorie")
	Categorie categorie;
	@ManyToOne(fetch =FetchType.EAGER)
	@JoinColumn(name="id_trattamenti")
	Trattamenti trattamenti;
	public AnagraficaPesci() {};
	public AnagraficaPesci(Integer idpesce,String nome) {
		this.idpesce=idpesce;
		this.nome=nome;
	};
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
}
