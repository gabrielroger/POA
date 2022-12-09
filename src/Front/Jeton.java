package Front;

public class Jeton {

    private Couleur couleur;

    public Jeton(Couleur couleur) {
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        if(couleur!=null){
            return this.couleur.toString();
        }else{
            return super.toString();
        }

    }



}