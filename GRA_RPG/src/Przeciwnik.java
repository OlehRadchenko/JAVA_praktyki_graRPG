public class Przeciwnik {
    private String nazwa;
    private int hp;
    private int dmg;

    public Przeciwnik() {
        hp=100;
        dmg=5;
    }

    public void dodajHp(int ile){
        hp+=ile;
    }
    public void dodajDmg(int ile){
        dmg+=ile;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getHp() {
        return hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }
}
