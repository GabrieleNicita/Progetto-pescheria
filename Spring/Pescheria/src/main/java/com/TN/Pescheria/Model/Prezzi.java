package com.TN.Pescheria.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity

@Table(name = "Prezzi")
public class Prezzi {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_prezzi")
	@JsonProperty("id")
	private Integer idprezzo;
	@JsonProperty("prezzoAlKg")
	private double prezzo;
	@OneToMany(mappedBy = "prezzi",fetch =FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<AnagraficaPesci> anagraficapesci= new HashSet<>();
	public Prezzi() {}
	public Prezzi(double prezzo) {
		
		this.prezzo=prezzo;
	}
	public Integer getIdprezzo() {
		return idprezzo;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	public void setIdprezzo(Integer idprezzo) {
		this.idprezzo = idprezzo;
	}
	public void setPrenotazioni(Set<AnagraficaPesci> prenotazioni) {
		this.anagraficapesci = prenotazioni;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}
