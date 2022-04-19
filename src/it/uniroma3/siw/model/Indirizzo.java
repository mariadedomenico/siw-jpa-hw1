package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	private String via;
	private int numeroCivico;
	private String comune;
	private int cap;
	private String provincia;
	
	public Indirizzo() {
		
	}
	
	public Indirizzo(String via, int numeroCivico, String comune, int cap, String provincia) {
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.comune = comune;
		this.cap = cap;
		this.provincia = provincia;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public int getNumeroCivico() {
		return numeroCivico;
	}
	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Override
	public int hashCode() {
		return this.getCap()+this.getNumeroCivico()+this.getVia().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Indirizzo other = (Indirizzo) obj;
		return this.getCap() == other.getCap() && this.getNumeroCivico() == other.getNumeroCivico() && this.getVia().equals(other.getVia());
	}
	
	

}
