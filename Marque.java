package com.example.Finale.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarque;
	private String nomMarque;
	private Double chiffreProduit;	
	private String slogan;	
	private String secteurActivite;
	
	public Marque () {
		super();
		}
	
	public Marque(String nomMarque, Double chiffreProduit,String slogan,String secteurActivite) {
		super();
		this.nomMarque = nomMarque;
		this.chiffreProduit = chiffreProduit;
		this.slogan=slogan;
		this.secteurActivite=secteurActivite;
		
		}
	
	
	public String getNomMarque() {
		return nomMarque;
	}
	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}
	public Double getchiffreProduit() {
		return chiffreProduit;
	}
	public void setchiffreProduit(Double prixProduit) {
		this.chiffreProduit = prixProduit;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	@Override
	public String toString() {
		return "Marque [idMarque=" + idMarque + ", nomMarque=" + nomMarque + ", chiffreProduit=" + chiffreProduit
				+ ", slogan=" + slogan + ", secteurActivite=" + secteurActivite + "]";
	}

	public String getSecteurActivite() {
		return secteurActivite;
	}
	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}
	
}