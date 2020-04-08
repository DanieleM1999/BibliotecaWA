package it.dstech.modelli;

public class Libro {

	private long id;
	private String titolo;
	private String autore;
	private int quantitaTotale;
	private int quantitaNoleggio;

	public Libro(long id, String titolo, String autore, int quantitaTotale, int quantitaNoleggio) {
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.quantitaTotale = quantitaTotale;
		this.quantitaNoleggio = quantitaNoleggio;
	}

	public Libro(String titolo, String autore, int quantitaTotale, int quantitaNoleggio) {
		this.titolo = titolo;
		this.autore = autore;
		this.quantitaTotale = quantitaTotale;
		this.quantitaNoleggio = quantitaNoleggio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getQuantitaTotale() {
		return quantitaTotale;
	}

	public void setQuantitaTotale(int quantitaTotale) {
		this.quantitaTotale = quantitaTotale;
	}

	public int getQuantitaNoleggio() {
		return quantitaNoleggio;
	}

	public void setQuantitaNoleggio(int quantitaNoleggio) {
		this.quantitaNoleggio = quantitaNoleggio;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", quantitaTotale=" + quantitaTotale
				+ ", quantitaNoleggio=" + quantitaNoleggio + "]";
	}

}
