package main;

import java.io.Serializable;

import exception.NomNonAttribue;
import exception.SurnomDejaExistant;

/**
 * Classe AjouterSurnom.
 * 
 * Classe implémentant Requete. La méthode process ajouter un surnom à un nom.
 * 
 */
public class AjouterSurnom implements Requete, Serializable {
	// Nécessaire à la sérialisation
	private static final long serialVersionUID = 1L;
	// Surnom à ajouter à la personne
	private String surnomAajouter;
	// Nom de la personne à qui on ajoute un surnom
	private String nomDestination;

	/**
	 * Constructeur.
	 * 
	 * @param nom
	 *            : nom de la personne à qui ajouter un surnom
	 * @param surnom
	 *            : surnom à ajouter
	 */
	public AjouterSurnom(String nom, String surnom) {
		this.nomDestination = nom;
		this.surnomAajouter = surnom;
	}

	/**
	 * Méthode process de l'interface. Ajoute à la base de données un surnom à
	 * un nom.
	 */
	public String process(BaseDeDonnees bd) throws Exception {
		try {
			for (Personne p : bd.getListePersonnes()) {
				if(p.getSurnoms().contains(surnomAajouter)) 
					throw new SurnomDejaExistant();
			}
			return bd.ajouterSurnom(surnomAajouter, nomDestination).toString();
		} catch (NomNonAttribue e) {
			return e.getMessage();
		} catch (SurnomDejaExistant ex) {
			return ex.getMessage();
		}
	}
}
