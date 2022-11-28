public class Jedzenie extends Postac{
    private Postac postac;
    private float jedzenie = 12;
    public Jedzenie(Postac postac){
        postac.dodajHp(10);
        this.postac = postac;
    }

    @Override
    public String toString() {
        return postac.toString() + "Jedzenie: Chleb = "+jedzenie+"\n";
    }
}
