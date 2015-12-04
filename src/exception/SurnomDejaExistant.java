package exception;

/**
 * Exception envoyée si le surnom existe déjà.
 */
public class SurnomDejaExistant extends Exception {
	// Nécessaire à la sérialisation
	private static final long serialVersionUID = -32473973890863542L;
	
	/**
	 * Constructeur et afficheur de l'exception.
	 */
	public SurnomDejaExistant() {
		super("Ce surnom est deja pris !");
	}

}
