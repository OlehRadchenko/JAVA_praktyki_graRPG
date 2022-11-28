public class Postac {
    private int hp, pancerz, dmg;
    private double szansa_wyzebrac, szansa_wlamania, szansa_kritu;
    private boolean obrona_przed_szczurami = false, obrona_przed_psami = false, obrona_przed_pijakami = false, obrona_przed_temperatura = false;
    private String nazwa;
    static final String reset = "\033[0m";
    static final String czerwony = "\033[0;31m";
    static final String zielony = "\033[0;32m";
    static final String niebieski = "\033[0;34m";

    public Postac() {
        hp=100;
        pancerz=0;
        dmg=10;
        szansa_wyzebrac=0.5;
        szansa_kritu=0.5;
        szansa_wlamania=0.5;
    }

    public Postac(Postac postac){
        setHp(postac.getHp());
        setDmg(postac.getDmg());
        setPancerz(postac.getPancerz());
        setSzansa_kritu(postac.getSzansa_kritu());
        setSzansa_wyzebrac(postac.getSzansa_wyzebrac());
        setSzansa_wlamania(postac.getSzansa_wlamania());
        setObrona_przed_psami(postac.getObrona_przed_psami());
        setObrona_przed_szczurami(postac.getObrona_przed_szczurami());
        setObrona_przed_pijakami(postac.getObrona_przed_pijakami());
        setObrona_przed_temperatura(postac.getObrona_przed_temperatura());
    }
    public void dodajHp(int ile){
        hp+=ile;
    }
    public void dodajPancerz(int ile){
        pancerz+=ile;
    }
    public void dodajDmg(int ile){
        dmg+=ile;
    }
    public void dodajSzansa_wyzebrac(double ile){
        szansa_wyzebrac+=ile;
    }
    public void dodajSzansa_wlamania(double ile){
        szansa_wlamania+=ile;
    }
    public void dodajSzansa_kritu(double ile){
        szansa_kritu+=ile;
    }

    public String toString() {
        return "\n\nStatystyki postaci:\n"+czerwony+"hp=" + hp + reset + zielony + "\npancerz=" + pancerz + reset + niebieski + "\ndmg=" + dmg + reset + "\nSzansa wyżebrać=" + niebieski + szansa_wyzebrac*100 + "%" + reset + "\nSzansa otworzenia zamków=" + niebieski + szansa_wlamania*100 + "%" + reset + "\nSzansa kritu=" + niebieski + szansa_kritu*100 + "%" + reset + "\n";
    }
    public String toString_ekwipunek(){
        return "W kieszeniach nosisz: \n";
    }

    public String toString_main(){
        return toString() + "\n" + toString_ekwipunek();
    }
//    public String toString2() {
//        return "Szczury: "+obrona_przed_szczurami+"\nPsy: "+obrona_przed_psami+"\nPijaki: "+obrona_przed_pijakami+"\nTemperatura: "+obrona_przed_temperatura;
//
//    }

    public int getHp() {
        return hp;
    }

    public int getPancerz() {
        return pancerz;
    }

    public int getDmg() {
        return dmg;
    }

    public double getSzansa_wyzebrac() {
        return szansa_wyzebrac;
    }

    public double getSzansa_wlamania() {
        return szansa_wlamania;
    }

    public double getSzansa_kritu() {
        return szansa_kritu;
    }

    public boolean getObrona_przed_szczurami() {
        return obrona_przed_szczurami;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setPancerz(int pancerz) {
        this.pancerz = pancerz;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setSzansa_wyzebrac(double szansa_ugotowac) {
        this.szansa_wyzebrac = szansa_ugotowac;
    }

    public void setSzansa_wlamania(double szansa_wlamania) {
        this.szansa_wlamania = szansa_wlamania;
    }

    public void setSzansa_kritu(double szansa_kritu) {
        this.szansa_kritu = szansa_kritu;
    }

    public void setObrona_przed_szczurami(boolean obrona_przed_szczurami) {
        this.obrona_przed_szczurami = obrona_przed_szczurami;
    }

    public boolean getObrona_przed_psami() {
        return obrona_przed_psami;
    }

    public void setObrona_przed_psami(boolean obrona_przed_psami) {
        this.obrona_przed_psami = obrona_przed_psami;
    }

    public boolean getObrona_przed_pijakami() {
        return obrona_przed_pijakami;
    }

    public void setObrona_przed_pijakami(boolean obrona_przed_pijakami) {
        this.obrona_przed_pijakami = obrona_przed_pijakami;
    }

    public boolean getObrona_przed_temperatura() {
        return obrona_przed_temperatura;
    }

    public void setObrona_przed_temperatura(boolean obrona_przed_temperatura) {
        this.obrona_przed_temperatura = obrona_przed_temperatura;
    }

    public String getNazwa() {
        return nazwa;
    }
}
