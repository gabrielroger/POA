package Front;

import java.util.Scanner;

public class JoueurInteractifClavier extends Joueur {

    public JoueurInteractifClavier(Couleur couleur) {
        super(couleur);
    }

    /* (non-Javadoc)
     * @see org.ronan.puissance4.modele.joueur.Joueur#placerJeton(org.ronan.puissance4.modele.jeu.Grille)
     */
    @Override
    public int placerJeton(Grille grille,Joueur joueur, Joueur opposant) {
        System.out.print("Où placer le prochain jeton? Donnez un numéro de colonne entre 1 et " + Grille.LARGEUR_GRILLE + " : ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();


        return i-1;
    }

}