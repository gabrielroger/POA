package Front;
import Back.Connect4GameManager;

import static Front.Grille.LARGEUR_GRILLE;
import static Front.Grille.LONGUEUR_GRILLE;

public class Partie {

    private Grille grille;

    private Joueur joueurA;

    private Joueur joueurB;

    private Connect4GameManager gameManager;

    private boolean partieFinie = false;


    private static Partie partie = null;

    public static Partie getPartie(){
        return partie;
    }


    private Partie() {
        this.grille = new Grille();
        System.out.println(grille);
        this.joueurA = new JoueurInteractifClavier(new Rouge());
        joueurA.setNom("Alfred");
        this.joueurB = new JoueurInteractifClavier(new Jaune());
        joueurB.setNom("Roboto");
        this.gameManager = new Connect4GameManager(LARGEUR_GRILLE, LONGUEUR_GRILLE);
    }

    public void jouer(){

        // Par défaut le joueur qui démarre est le joueur A
        Joueur joueurCourant = this.joueurA;
        grille.deserializeGrille(gameManager.getSerializedBoard(), joueurA, joueurB);
        System.out.println("Grille de départ : ");
        System.out.println(grille);
        System.out.println("\n");

        // Boucle principale
        while(!partieFinie){
            // Le joueur courant joue un tour
            this.unTour(joueurCourant);
        }

        System.out.println("La partie est terminée");
    }

    private void unTour(Joueur joueur){

        System.out.println("C'est au joueur " + joueur.getNom() + " de jouer!");

        // On cherche l'opposant du joueur
        Joueur opposant = ( (joueur == this.joueurA) ? this.joueurB : this.joueurA);

        boolean coupJouerOk = false;
        // Tant que le joueur n'a pas joué correctement on boucle
        do {
            // On récupère la colonne où jouer le jeton
            int numeroColonneOuJouer = joueur.placerJeton(grille.copie(), joueur, opposant);

            int result = gameManager.runTurn(numeroColonneOuJouer);
            if (result == -1) {
                System.out.println("Ce coup est invalide");
            } else {

                System.out.println("Le joueur " + joueur.getNom() + " joue dans la colonne "+ numeroColonneOuJouer);
                coupJouerOk = true;

                if (result == 1) {
                    System.out.println("Vous avez gagné !");
                    partieFinie = true;
                }
                if (result == 2) {
                    System.out.println("Vous avez perdu.");
                    partieFinie = true;
                }
            }

        }while(!coupJouerOk);

        grille.deserializeGrille(gameManager.getSerializedBoard(), joueurA, joueurB);
        System.out.println("Voici la grille résultante : ");
        System.out.println(grille);
        System.out.println("\n");

    }


    public static void main(String[] args) {
        Partie partie = new Partie();
        Partie.partie = partie;
        partie.jouer();

    }



}