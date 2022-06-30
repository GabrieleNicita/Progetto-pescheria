package com.TN.Pescheria.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity

@Table(name = "Categorie")
public class Categorie {
	@Id
	
	@Column(name="id_categorie")
	@JsonProperty("id")
	private Integer idcategoria;
	private String categoria;
	@OneToMany(mappedBy = "categorie",fetch =FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<AnagraficaPesci> anagraficapesci= new HashSet<>();
	
	public Categorie() {
		
	}
	public Categorie(Integer idcategoria,String categoria) {
		this.idcategoria=idcategoria;
		this.categoria=categoria;
	}
	
	
	public String getCategoria() {
		return categoria;
	}
	public Integer getIdcategoria() {
		return idcategoria;
	}
	public void setAnagraficapesci(Set<AnagraficaPesci> anagraficapesci) {
		this.anagraficapesci = anagraficapesci;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}
}
