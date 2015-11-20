package main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Classe Client.
 * 
 * Cette classe est la classe du client, qui se connecte au serveur de surnoms
 * TCP. Elle demande au client la requete qu'il veut effectuer, crée l'objet,
 * l'envoie au serveur et attend la réponse du serveur.
 * 
 * L'adresse IP du serveur est à renseigner dans les variables, le port aussi
 * (qui devrait être 2222).
 * 
 */
public class Client {

	// IP Arnaud
	//static final String adresseIP = "10.212.115.140";
	// IP Lisa
	static final String adresseIP = "10.212.115.203";
	static final int port = 2222;
	private Scanner sc;

	/**
	 * 
	 * @param port
	 * @throws Exception
	 */
	public Client() throws Exception {
		// Création de la socket
		Socket socket = new Socket(adresseIP, port);

		// Création de l'objet envoyé au serveur
		ObjectOutputStream out = new ObjectOutputStream(
				socket.getOutputStream());
		
		// Création de l'objet reçu du serveur
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		System.out.println(in.readObject());
		
		// Scanner
		sc = new Scanner(System.in);

		// Boucle pour pouvoir envoyer des requetes à la suite au serveur.
		while (true) {
			String choix = "";
			imprimerChoix();
			// Requete envoyée au client, typée suivant le choix du client
			Requete r;
			try {
				choix = sc.nextLine();
				switch (choix) {
				case "0": // le client souhaite arreter
					r = null;
					break;
				case "1": // le client souhaite lister les personne de la base de données
					r = new ListerPersonne();
					break;
				case "2": // le client souhaite ajouter un surnom à un nom
					String nom = "", surnom = "";
					imprimerChoixChoisirNom();
					nom = sc.nextLine();
					imprimerChoixChoisirSurnom();
					surnom = sc.nextLine();
					r = new AjouterSurnom(nom, surnom);
					break;
				default:
					System.err.println("Entrée non valide.");
					return;
				}
				// Envoi de l'objet au serveur
				out.writeObject(r);
				// Test si le client a souhaité arreter le serveur
				if (r == null) {
					// Affichage du message d'au revoir
					System.out.println(in.readObject());
					// Fermeture des objets, scanner et socket
					sc.close();
					in.close();
					out.close();
					socket.close();
					// Quitter
					return;
				}
				System.out.println("Réponse de votre requête : ");
				Object re = in.readObject();
				// Ecriture de la réponse
				System.out.println(re);
			} catch (Exception e) {
				System.out.println("Erreur !");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Imprime la liste des choix proposés à l'utilisateur.
	 */
	public void imprimerChoix() {
		System.out.println("Que souhaitez vous faire ?");
		System.out.println("0 - Quitter");
		System.out.println("1 - Lister les personnes stockées sur le serveur");
		System.out.println("2 - Ajouter un surnom à un utilisateur");
	}
	
	/**
	 * Demande au client de rentrer un nom.
	 */
	public void imprimerChoixChoisirNom() {
		System.out.print("Indiquez le nom de la personne : ");
	}

	/**
	 * Demande au client de rentrer un surnom.
	 */
	public void imprimerChoixChoisirSurnom() {
		System.out.print("Indiquez le surnom à ajouter à cette personne : ");
	}
}
