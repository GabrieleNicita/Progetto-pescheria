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

@Entity

@Table(name = "Categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_categorie")
	private Integer idcategoria;
	private String categoria;
	@OneToMany(mappedBy = "categorie",fetch =FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<AnagraficaPesci> anagraficapesci= new HashSet<>();
	
	public Set<AnagraficaPesci> getAnagraficapesci() {
		return anagraficapesci;
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
