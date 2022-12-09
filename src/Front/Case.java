package Front;

public class Case {

    private Jeton jeton;

    public Case(Jeton jeton) {
        this.jeton = jeton;
    }

    public Jeton getJeton() {
        return jeton;
    }

    public void setJeton(Jeton jeton) {
        this.jeton = jeton;
    }

    @Override
    public String toString() {
        if(this.jeton != null){
            return this.jeton.toString();
        }else{
            return " ";
        }
    }



}