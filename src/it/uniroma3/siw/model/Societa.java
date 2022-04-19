package it.uniroma3.siw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Societa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ragioneSociale;
	@Column(nullable = false)
	private int numeroTelefono;
	/* Definisco una politica di cascade persist
	 * perchè in questo modo, rendendo persistente una societa, si rende persistente anche 
	 * l'indirizzo associato */
	@OneToOne(cascade = CascadeType.PERSIST)
	private Indirizzo indirizzo;
	
	public Societa() {
		
	}
	public Societa(String ragioneSociale, int numeroTelefono, Indirizzo indirizzo) {
		this.ragioneSociale = ragioneSociale;
		this.numeroTelefono = numeroTelefono;
		this.indirizzo = indirizzo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public int getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}
	@Override
	public int hashCode() {
		return this.getNumeroTelefono();
	}
	@Override
	public boolean equals(Object obj) {
		
		Societa other = (Societa) obj;
		return this.getNumeroTelefono() == other.getNumeroTelefono();
	}
	
	
	
	
	

}
