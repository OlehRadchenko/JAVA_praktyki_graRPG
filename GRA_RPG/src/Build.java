public class Build {
    public static Postac zbuduj_postac(int kto){
        Postac wynik;
        switch (kto){
            case 1:
                wynik = new Kucharz();
                break;
            case 2:
                wynik = new Mechanik();
                break;
            case 3:
                wynik = new Zolnierz();
                break;
            default:
                wynik = null;
        }
        return wynik;
    }

    public static Przeciwnik zbuduj_losowego_przeciwnika(){
        Przeciwnik wynik;
        double losowa = Math.random();
        if(losowa<0.4){ //40%
            wynik = new Szczury();
        }else if(losowa<0.75){ //35%
            wynik = new Temperatura();
        }else if(losowa<0.9){ //15%
            wynik = new Pies();
        }else if(losowa<1){ //10%
            wynik = new Pijak();
        }else{
            wynik = new Przeciwnik();
        }
        return wynik;
    }

    public static Postac zbuduj_losowy_item_bron(Postac postac){
        double losowa = Math.random();
        //Postac cos = postac;
        if(losowa<0.2){ //20%
            postac = new Mlotek(postac);
        }else if(losowa<0.4){ //20%
            postac = new Zapalniczka(postac);
        }else if(losowa<0.6){ //20%
            postac = new Pistolet(postac);
        }else if(losowa<0.8){ //20%
            postac = new Pulapka(postac);
        }else{ //20%
            postac = new Perfum(postac);
        }
        return postac;
    }
    public static Postac zbuduj_losowy_item_armor(Postac postac){
        double losowa = Math.random();
        if(losowa<0.17){ //17%
            postac = new Sweter(postac);
        }else if(losowa<0.33){ //16%
            postac = new Buty(postac);
        }else if(losowa<0.50){ //17%
            postac = new Kurtka(postac);
        }else if(losowa<0.67){ //17%
            postac = new Helm(postac);
        }else if(losowa<0.82){ //15%
            postac = new Wozek(postac);
        }else{ //18%
            postac = new Reklamowka(postac);
        }
        return postac;
    }
}
