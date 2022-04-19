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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	@Column(nullable = false)
	private int matricola;
	private String email;
	/* impongo la politica fetch eager in questo modo sono disponibili subito 
	 * tutti i corsi relativi a quell'allievo. Definisco una politica di cascade persist
	 * perchè in questo modo, rendendo persistente un allievo, si rendono persistenti anche 
	 * i corsi a cui è iscritto. */
	@ManyToMany(fetch= FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Corso> corsi;
	/* rendo persistente anche la società per cui lavora */
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Societa societa;
	
	public Allievo() {
		
	}
	
	public Allievo(String nome, String cognome, LocalDate dataNascita, String luogoNascita, int matricola, String email,
			List<Corso> corsi, Societa societa) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.matricola = matricola;
		this.email = email;
		this.corsi = corsi;
		this.societa = societa;
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
	
	public int getMatricola() {
		return matricola;
	}
	
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	@Override
	public int hashCode() {
		return this.getMatricola();
	}

	@Override
	public boolean equals(Object obj) {
		Allievo other = (Allievo) obj;
		return this.getMatricola() == other.getMatricola();
	}
	
	

}
