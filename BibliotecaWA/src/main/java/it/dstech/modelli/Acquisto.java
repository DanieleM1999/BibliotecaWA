package it.dstech.modelli;

public class Acquisto {

	private long id;
	private String username;
	private String titolo;
	private String autore;
	private int quantita;

	public Acquisto(long id, String username, String titolo, String autore, int quantita) {
		this.id = id;
		this.username = username;
		this.titolo = titolo;
		this.autore = autore;
		this.quantita = quantita;
	}

	public Acquisto(String username, String titolo, String autore, int quantita) {
		this.username = username;
		this.titolo = titolo;
		this.autore = autore;
		this.quantita = quantita;
	}
	
	

	public Acquisto(long id, String username, String titolo, String autore) {
		this.id = id;
		this.username = username;
		this.titolo = titolo;
		this.autore = autore;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Acquisto [id=" + id + ", username=" + username + ", titolo=" + titolo + ", autore=" + autore
				+ ", quantita=" + quantita + "]";
	}

}
