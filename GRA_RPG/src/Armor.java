class Sweter extends Postac{
    private Postac postac;
    private String nazwa;
    public Sweter(Postac postac){
        super(postac);
        this.postac = postac;
        nazwa = "Sweter";
        setObrona_przed_temperatura(true);
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + niebieski + "Sweter[+0 pancerz + nie dostajesz dmg od niskiej temperatury] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class Helm extends Postac{
    private Postac postac;
    private String nazwa;
    public Helm(Postac postac){
        super(postac);
        this.postac = postac;
        nazwa = "Hełm";
        dodajPancerz(5);
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + niebieski + "Hełm[+5 pancerz] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class Buty extends Postac{
    private Postac postac;
    private String nazwa;
    public Buty(Postac postac){
        super(postac);
        this.postac = postac;
        nazwa = "Buty zimowe";
        dodajPancerz(5);
        setObrona_przed_temperatura(true);
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + niebieski + "Buty zimowe[+5 pancerz + nie dostajesz dmg od niskiej temperatury] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class Kurtka extends Postac{
    private Postac postac;
    private String nazwa;
    public Kurtka(Postac postac){
        super(postac);
        this.postac = postac;
        nazwa = "Kurtka zimowa";
        dodajPancerz(10);
        setObrona_przed_temperatura(true);
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + niebieski + "Kurtka zimowa[+10 pancerz + nie dostajesz dmg od niskiej temperatury] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class Wozek extends Postac{
    private Postac postac;
    private String nazwa;
    public Wozek(Postac postac){
        super(postac);
        this.postac = postac;
        nazwa = "Wózek z biedry";
        dodajPancerz(15);
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + niebieski + "Wózek z biedry[+15 pancerz] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}

class Reklamowka extends Postac{
    private Postac postac;
    private String nazwa;
    public Reklamowka(Postac postac){
        super(postac);
        this.postac = postac;
        nazwa = "Reklamówka z biedry";
        dodajPancerz(5);
    }

    @Override
    public String toString_ekwipunek(){
        return postac.toString_ekwipunek() + niebieski + "Reklamówka z biedry[+5 pancerz] \n" + reset;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }
}
