package main;

/**
 * 
 * Interface Requete.
 * 
 * Cette interface sera implémentée par différents types de requetes (ListerPersonne, AjouterPersonne...)
 * 
 */
public interface Requete {

	/**
	 * La méthode process.
	 * 
	 * Cette méthode effectuera l'action propre à la requete.
	 * 
	 * @param bd : la base de données sur laquelle on travaille.
	 * @return La base de donnée sous forme de string.
	 * @throws Exception si une exception est attrapée.
	 */
	public String process(BaseDeDonnees bd) throws Exception;
}
