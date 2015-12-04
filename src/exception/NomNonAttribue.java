package exception;

/**
 * Exception envoyée si le nom est déjà attribué.
 */
public class NomNonAttribue extends Exception {
	
	// Nécessaire à la sérialisation
	private static final long serialVersionUID = -816352165336575609L;

	/**
	 * Constructeur et afficheur de l'exception.
	 */
	public NomNonAttribue() {
		super("Ce nom n'est pas attribué.");
	}

}
