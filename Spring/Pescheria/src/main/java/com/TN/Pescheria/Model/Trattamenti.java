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

@Entity

@Table(name = "Trattamenti")
public class Trattamenti {
	@Id

	@Column(name="id_trattamenti")
	private Integer idtrattamento;
	private String trattamento;
	@OneToMany(mappedBy = "trattamenti",fetch =FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<AnagraficaPesci> anagraficapesci= new HashSet<>();
	public Trattamenti() {}
	public Trattamenti(Integer idtrattamento,String trattamento) {
		this.trattamento=trattamento;
		this.idtrattamento=idtrattamento;
	}
	
	public Set<AnagraficaPesci> getAnagraficapesci() {
		return anagraficapesci;
	}
	public Integer getIdtrattamento() {
		return idtrattamento;
	}
	public String getTrattamento() {
		return trattamento;
	}
	public void setAnagraficapesci(Set<AnagraficaPesci> anagraficapesci) {
		this.anagraficapesci = anagraficapesci;
	}
	public void setIdtrattamento(Integer idtrattamento) {
		this.idtrattamento = idtrattamento;
	}
	public void setTrattamento(String trattamento) {
		this.trattamento = trattamento;
	}
	
}
