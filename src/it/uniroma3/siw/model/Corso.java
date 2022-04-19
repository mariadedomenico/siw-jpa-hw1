package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	private String nome;
	private LocalDate dataInizio;
	private int durata;
	/* Definisco una politica di cascade persist
	 * perchè in questo modo, rendendo persistente un corso, si rendono persistenti anche 
	 * i suoi allievi. Così come per il docente */
	@ManyToMany(mappedBy = "corsi", cascade = CascadeType.PERSIST)
	private List<Allievo> allievi;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Docente docente;
	
	public Long getId() {
		return id;
	}
	
	public Corso() {
		
	}
	
	public Corso(String nome, LocalDate dataInizio, int durata, List<Allievo> allievi, Docente docente) {
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.durata = durata;
		this.allievi = allievi;
		this.docente = docente;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	public int getDurata() {
		return durata;
	}
	
	public void setDurata(int durata) {
		this.durata = durata;
	}

	public List<Allievo> getAllievi() {
		return allievi;
	}

	public void setAllievi(List<Allievo> allievi) {
		this.allievi = allievi;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Corso other = (Corso) obj;
		return this.getId().equals(other.getId());
	}
	
	

}
