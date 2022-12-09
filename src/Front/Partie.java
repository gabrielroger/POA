package Front;

public class Partie {

    private Grille grille;

    private Joueur joueurA;

    private Joueur joueurB;


    private static Partie partie = null;

    public static Partie getPartie(){
        return partie;
    }


    private Partie() {
        this.grille = new Grille();
        System.out.println(grille);
        this.joueurA = new JoueurInteractifClavier(new Rouge());
        joueurA.setNom("Alfred");
    }

    public void jouer(){

        boolean partieFinie = false;

        // Par défaut le joueur qui démarre est le joueur A
        Joueur joueurCourant = this.joueurA;

        // Boucle principale
        while(!partieFinie){



            // Le joueur courant joue un tour
            this.unTour(joueurCourant);
        }

        System.out.println("La partie est terminée : ");
        System.out.println(grille);
    }

    private void unTour(Joueur joueur){

        System.out.println("C'est au joueur " + joueur.getNom() + " de jouer!");

        // On cherche l'opposant du joueur
        Joueur opposant = ( (joueur == this.joueurA) ? this.joueurB : this.joueurA);

        boolean coupJouerOk = true;
        // Tant que le joueur n'a pas joué correctement on boucle
        do{
            // Réinit du boolean
            coupJouerOk = true;


            // On récupère la colonne où jouer le jeton
            int numeroColonneOuJouer = joueur.placerJeton(grille.copie(), joueur, opposant);

            System.out.println("Le joueur " + joueur.getNom() + " joue dans la colonne "+ numeroColonneOuJouer);

            // Création du jeton
            Jeton jeton = new Jeton(joueur.getCouleur());

            // Placage du jeton
            try {
                this.grille.insereJeton(numeroColonneOuJouer, jeton);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }while(!coupJouerOk);

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