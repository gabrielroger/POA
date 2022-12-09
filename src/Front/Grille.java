package Front;

public class Grille implements Cloneable{

    public static final int LARGEUR_GRILLE = 4;
    public static final int LONGUEUR_GRILLE = 7;
    protected Matrice<Case> matriceDeCases;



    /**
     * Initialise la grille à vide
     */
    public Grille() {
        this.matriceDeCases = new Matrice<Case>(LARGEUR_GRILLE, LONGUEUR_GRILLE);
        for(int i = 1; i<=LARGEUR_GRILLE; i++){
            for(int j = 1 ; j <= LONGUEUR_GRILLE; j++){
                Case currentCase = new Case(null);
                try {
                    this.matriceDeCases.affecteValeur(i, j, currentCase);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Grille copie()  {
        Grille copieDeLaGrille = new Grille();
        for(int i = 1; i <= LARGEUR_GRILLE; i++){
            for(int j = 1; j<= LONGUEUR_GRILLE; j++){
                try {
                    Jeton jeton = this.matriceDeCases.recupereValeur(i, j).getJeton();
                    if(jeton != null){
                        Couleur couleur = jeton.getCouleur();
                        Jeton copieDuJeton = new Jeton(couleur);
                        Case copieDeLaCase = copieDeLaGrille.matriceDeCases.recupereValeur(i, j);
                        copieDeLaCase.setJeton(copieDuJeton);
                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

            }
        }
        return copieDeLaGrille;
    }

    @Override
    public String toString() {
        return this.matriceDeCases.toString();
    }

    private int plusHautJeton(int i){
        int indexPlusHaut = 0;
        for(int j = LONGUEUR_GRILLE; j >= 1 && indexPlusHaut==0; j--){
            if(this.matriceDeCases.recupereValeur(i, j).getJeton() != null){
                indexPlusHaut = j;
            }
        }
        return indexPlusHaut;
    }

    public boolean estColonnePleine(int i){
        return (this.plusHautJeton(i) == LONGUEUR_GRILLE);
    }

    public void insereJeton(int i, Jeton jeton){
        if(estColonnePleine(i)){
            String message = "La colonne dans laquelle on tente d'insérer le Jeton " + jeton + " est pleine.";
            System.out.println(message);
        }
        int j = this.plusHautJeton(i) + 1;
        Case currentCase = this.matriceDeCases.recupereValeur(i, j);
        currentCase.setJeton(jeton);

    }
}