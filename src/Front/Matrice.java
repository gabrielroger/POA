package Front;

import java.util.HashMap;

public class Matrice<A> {

    private HashMap<Coordonnee, A> cellules;


    private int largeur;

    private int longueur;

    public Matrice(int largeur, int longueur) {

        // Stockages des paramètres largeur / longueur
        this.largeur = largeur;
        this.longueur = longueur;

        // Début de la création des cellules
        this.cellules = new HashMap<Coordonnee, A>(this.largeur > this.longueur ? this.largeur : this.longueur);

        try {
            // On créer tous les index et on les places dans les bonnes hashmaps
            for (int i = 1; i <= this.largeur; i++) {
                for (int j = 1; j <= this.longueur; j++) {
                    // Création des valeurs dans les maps
                    this.affecteValeur(i, j, null);

                }
            }
        } catch (Exception e) {
            String message = "Une erreur est apparu lors de l'initialisation de la matrice. Voici le message de cette erreur : " + e.getMessage();
            System.out.println(message);
        }
    }


    public void affecteValeur(int i, int j, A valeur) throws Exception {

        if (i >= this.largeur || i < 0 || j >= this.longueur || j < 0) {
            String message = "Les index de colonne et de ligne fournie ( i = " + i + ", j = " + j + " ) lors de la tentative d'affectation de la valeur " + valeur + " sont définies en dehors des limites de largeur et de longueur de la matrice.";
        }

        // Affectation dans la ligne colonne
        Coordonnee coordonnee = new Coordonnee(i, j);
        this.cellules.put(coordonnee, valeur);
    }

    public A recupereValeur(int i, int j) throws NullPointerException {
        if (i >= this.largeur || i < 0 || j >= this.longueur || j < 0) {
            String message = "Les index de colonne et de ligne fournie ( i = " + i + ", j = " + j + " ) lors de la tentative de récupérer la valeur associée sont définies en dehors des limites de largeur et de longueur de la matrice.";
            throw new NullPointerException(message);
        }
        return this.cellules.get(new Coordonnee(i, j));
    }


    private static final String NULL = "null";
    /**
     * Calcule la taille maximale d'une case textuelle d'une matrice
     */
    private int tailleMaxElement(){
        int result = 0;
        try {
            for(int i = 0; i < this.largeur; i++){
                for(int j = 0; j < this.longueur; j++){
                    int tailleElement = 0;
                    A element = this.recupereValeur(i, j);
                    if(element == null){
                        tailleElement = NULL.toString().length();
                    }else{
                        tailleElement = element.toString().length();
                    }
                    result  = Math.max(result, tailleElement);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Formate la cellule à taille convenable
     * @param contenuCellule
     * @param tailleMaxElement
     * @return
     */
    private String formatCellule(String contenuCellule, int tailleMaxElement){
        StringBuffer stringBuffer = new StringBuffer();

        // On calcule le nombre d'espace à ajouter à gauche et à droite
        int nombreDespaceAAjouter = tailleMaxElement - contenuCellule.length();
        int nombreDespaceAAjouterAGauche = nombreDespaceAAjouter / 2;
        int nombreDespaceAAjouterADroite = nombreDespaceAAjouterAGauche;

        // Si le nombre d'espace à ajouter est impaire alors on ajoute un espace de plus à droite
        if(nombreDespaceAAjouterAGauche * 2  != nombreDespaceAAjouter){
            nombreDespaceAAjouterADroite++;
        }

        // On commence le formatage

        stringBuffer.append("|");
        // Ajout des espaces à gauche
        for(int i=0; i<nombreDespaceAAjouterAGauche; i++ ){
            stringBuffer.append(" ");
        }

        stringBuffer.append(contenuCellule);

        // Ajout des espaces à droite
        for(int i=0; i<nombreDespaceAAjouterADroite; i++ ){
            stringBuffer.append(" ");
        }
        stringBuffer.append("|");

        return stringBuffer.toString();
    }


    private String formatageMatrice(){
        StringBuffer buffer = new StringBuffer();

        int tailleMaxElement = this.tailleMaxElement();
        try {

            for(int j = this.longueur-1 ; j >=0 ; j--){
                buffer.append("\n[ ");
                for(int i = 0; i < this.largeur; i++ ){
                    buffer.append(" ");
                    A element = this.recupereValeur(i, j);
                    String textualElement = NULL;
                    if(element != null){
                        textualElement = this.recupereValeur(i, j).toString();
                    }
                    buffer.append(this.formatCellule(textualElement, tailleMaxElement));


                    buffer.append(" ");

                }
                buffer.append(" ]");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

    @Override
    public String toString() {
        return this.formatageMatrice();
    }

}