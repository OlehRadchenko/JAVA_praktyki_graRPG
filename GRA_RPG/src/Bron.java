class Mlotek extends Postac{
    private Postac postac;
    private String nazwa;
    public Mlotek(Postac postac){
        super(postac);
        this.postac = postac;
        dodajDmg(10);
        setObrona_przed_pijakami(true);
        nazwa = "Młotek";
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + czerwony + "Młotek[+10dmg + natychmiastowe odstraszenie Pijaków] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class Pulapka extends Postac{
    private Postac postac;
    private String nazwa;
    public Pulapka(Postac postac){
        super(postac);
        this.postac = postac;
        dodajDmg(5);
        setObrona_przed_szczurami(true);
        nazwa = "Pułapka";
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + czerwony + "Pułapka na szczury[+5dmg + natychmiastowe odstraszenie Szczurów] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class Pistolet extends Postac{
    private Postac postac;
    private String nazwa;
    public Pistolet(Postac postac){
        super(postac);
        this.postac = postac;
        setObrona_przed_pijakami(true);
        setObrona_przed_szczurami(true);
        setObrona_przed_psami(true);
        nazwa = "Pistolet";
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + czerwony + "Pistolet strzelający pustakami[+0dmg + natychmiastowe odstraszenie Szczurów, Psów i Pijaków] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class Zapalniczka extends Postac{
    private Postac postac;
    private String nazwa;
    public Zapalniczka(Postac postac){
        super(postac);
        this.postac = postac;
        dodajDmg(5);
        setObrona_przed_psami(true);
        nazwa = "Zapalniczka";
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + czerwony + "Zapalniczka[+5dmg + natychmiastowe odstraszenie Psów] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class Perfum extends Postac{
    private Postac postac;
    private String nazwa;
    public Perfum(Postac postac){
        super(postac);
        this.postac = postac;
        setObrona_przed_pijakami(true);
        nazwa = "Perfum";
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + czerwony + "Perfumy [+0dmg + natychmiastowe odstraszenie Pijaków] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}