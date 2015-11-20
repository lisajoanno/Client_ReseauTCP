package main;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Personne.
 * 
 * Une personne est caractérisée par un nom et une liste de surnoms.
 */
public class Personne implements Serializable {
	// Nécessaire à la sérialisation
	private static final long serialVersionUID = 1208899971439424986L;
	// Le nom de la personne
	private String nom;
	// Les surnoms de la personne
	private ArrayList<String> surnoms = new ArrayList<String>();;

	/**
	 * Constructeur vide.
	 */
	public Personne() {
		this.setNom("");
		this.setSurnoms(null);
	}

	/**
	 * Constructeur
	 * 
	 * @param n : nom de la personne
	 * @param s : liste de surnoms
	 */
	public Personne(String n, ArrayList<String> s) {
		this.setNom(n);
		this.setSurnoms(s);
	}

	/**
	 * Ajout d'un surnom à la personne.
	 * 
	 * @param nouveauSurnom le surnom à ajouter.
	 */
	public void addSurnom(String nouveauSurnom) {
		surnoms.add(nouveauSurnom);
	}

	/**
	 * Getter des surnoms.
	 * 
	 * @return the surnoms : la liste de surnoms
	 */
	public ArrayList<String> getSurnoms() {
		return surnoms;
	}

	/**
	 * Setter des surnoms
	 * 
	 * @param surnoms
	 *            the surnoms to set
	 */
	public void setSurnoms(ArrayList<String> surnoms) {
		this.surnoms = surnoms;
	}

	/**
	 * Getter du nom
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter du nom
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
