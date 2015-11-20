package main;

import java.io.Serializable;
import java.util.ArrayList;

import exception.NomNonAttribue;
import exception.SurnomDejaExistant;

/**
 * The class BaseDeDonnes is a list of Personne ; each Personne has a nom and a surnom
 */
public class BaseDeDonnees implements Serializable {
	
	// Valeur nécessaire pour la sérialisation
	private static final long serialVersionUID = -6153943030340429L;
	
	// Contenu de la base de données
	private ArrayList<Personne> listePersonnes = new ArrayList<Personne>();

	/**
	 * Méthode d'ajout d'une personne dans la base de données.
	 * 
	 * @param p : le nom d'une nouvelle personne dans la base de données.
	 */
	public void ajouterPersonne(Personne p) {
		listePersonnes.add(p);
	}

	/**
	 * Méthode d'ajout de surnom dans la base de données.
	 * 
	 * @param surnomAajouter : surnom qu'on ajoute à la personne.
	 * @param nomDestination : nom de la personne à qui on ajoute un surnom.
	 * @return this la base de données avec le surnom ajouté.
	 * @throws Exception si le surnom existe déjà.
	 */
	public BaseDeDonnees ajouterSurnom(String surnomAajouter,
			String nomDestination) throws Exception {
		for (Personne p : listePersonnes) {
			if (p.getSurnoms().contains(surnomAajouter)) {
				throw new SurnomDejaExistant();
			}
			if (nomDestination.equals(p.getNom())) {
				p.addSurnom(surnomAajouter);
				return this;
			}
		}
		throw new NomNonAttribue();
	}

	/**
	 * Getter de la liste de personnes.
	 * 
	 * @return listePersonnes.
	 */
	public ArrayList<Personne> getListePersonnes() {
		return listePersonnes;
	}
	
	/**
	 * Setter de la liste de personnes.
	 * 
	 * @param listePersonnes
	 *            the listePersonnes to set
	 */
	public void setListePersonnes(ArrayList<Personne> listePersonnes) {
		this.listePersonnes = listePersonnes;
	}

	/**
	 * Renvoie un string décrivant la base de données : les noms avec les surnoms correspondants.
	 * 
	 * @return une string avec la base de données.
	 */
	public String toString() {
		String myStr = "";
		for (Personne personne : this.getListePersonnes()) {
			myStr += ("Nom : " + personne.getNom() + " --- Surnom(s) : "
					+ personne.getSurnoms() + "\n");
		}
		return myStr;
	}

}
