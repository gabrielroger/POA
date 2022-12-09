package Front;

public abstract class Joueur {

    private Couleur couleur;

    private String nom;

    public Joueur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nomJoeur to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract int placerJeton(Grille grille, Joueur joueur, Joueur opposant) ;
}