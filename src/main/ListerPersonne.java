package main;

import java.io.Serializable;

/**
 * La classe ListerPersonne.
 * 
 * Cette classe est une requete, donc elle implémente Requete.
 * Elle liste les personnes dans la base de données.
 * 
 */
public class ListerPersonne implements Requete, Serializable {

	// Nécessaire à la sérialisation
	private static final long serialVersionUID = 1178456591485909596L;

	/**
	 * Renvoie la base de données sous forme de string.
	 * 
	 * @return la base de données sous forme de string
	 */
	public String process(BaseDeDonnees bd) {
		return bd.toString();
	}

}
