package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	@Column(nullable = false)
	private int iva;
	/* impongo la politica fetch eager in questo modo sono disponibili subito 
	 * tutti i corsi relativi di quel docente. Definisco una politica di cascade persist
	 * perchè in questo modo, rendendo persistente un docente, si rendono persistenti anche 
	 * i corsi in cui insegna. */
	@OneToMany(mappedBy = "docente", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Corso> corsi;
	
	public Docente() {
		
	}
	
	
	
	public Docente(String nome, String cognome, LocalDate dataNascita, String luogoNascita, int iva,
			List<Corso> corsi) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.iva = iva;
		this.corsi = corsi;
	}

	public Long getId() {
		return id;
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
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public String getLuogoNascita() {
		return luogoNascita;
	}
	
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	
	public int getIva() {
		return iva;
	}
	
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	public List<Corso> getCorsi() {
		return corsi;
	}



	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}



	@Override
	public int hashCode() {
		return this.getIva();
	}
	@Override
	public boolean equals(Object obj) {
		Docente other = (Docente) obj;
		return this.getIva() == other.getIva();
	}
	
	


}
