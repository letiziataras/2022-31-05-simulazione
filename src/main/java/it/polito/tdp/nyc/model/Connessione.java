package it.polito.tdp.nyc.model;

public class Connessione implements Comparable<Connessione>{
	
	private String quartiereAdiacente;
	private double peso;
	public String getQuartiereAdiacente() {
		return quartiereAdiacente;
	}
	public void setQuartiereAdiacente(String quartiereAdiacente) {
		this.quartiereAdiacente = quartiereAdiacente;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Connessione(String quartiereAdiacente, double peso) {
		super();
		this.quartiereAdiacente = quartiereAdiacente;
		this.peso = peso;
	}
	
	public int compareTo(Connessione other) {
		// TODO Auto-generated method stub
		if (other.getPeso()>this.peso) {
			return -1;
		}
		return 1;
	}
	
	
}
