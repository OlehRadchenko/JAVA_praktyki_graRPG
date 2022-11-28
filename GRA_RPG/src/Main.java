import java.util.Scanner;

public class Main {
    private static Postac postac, armor, bron;
    private static Przeciwnik przeciwnik;
    private static Scanner scanner = new Scanner(System.in);
    private static int rundy=(int) (Math.random()*40)+10;
    private static final String reset = "\033[0m";
    private static final String czarny = "\033[0;30m";
    private static final String czerwony = "\033[0;31m";
    private static final String zielony = "\033[0;32m";
    private static final String zolty = "\033[0;33m";
    private static final String niebieski = "\033[0;34m";
    private static final String fioletowy = "\033[0;35m";
    private static final String jasno_niebieski = "\033[0;36m";

    public static void main(String[] args){
        poczatek();
        System.out.println("\n\n\n\n\n\n\n\nWstałeś i nie rozumiesz co się dzieję, jesteś pod jakimś mostem jak jakiś menel."+zolty+"[Nie pamiętasz nic, nawet swojego imienia]" + reset +
                "\nWidzisz jakiegoś ziomka obok ciebie.\n"+jasno_niebieski+"Pytasz go: \"-Co ja tu robię?\"\n" + reset +
                fioletowy+"Odpowiada na to: \"Nie wiem jak tutaj się znalazłeś ale za niedługo będzie zima i przeżycie tej zimy będzie bardzo ciężkie, " +
                "polecam już teraz robić zapasy jedzenia i znaleźć jakieś miejsce noclegu!!\""+reset);

//        spotkanie_dmg();
//        System.out.println(postac.toString_main());
//        spotkanie_dmg();
//        System.out.println(postac.toString_main());
//        szpital();
//        System.out.println(postac.toString_main());
//        przeciwnik();
//        System.out.println(postac.toString_main());
//        przedmiot();
//        System.out.println(postac.toString_main());
//        losuj_spotkanie();
//        System.out.println(postac.toString_main());
//        szpital();
//        System.out.println(postac.toString_main());
//        przeciwnik();
//        System.out.println(postac.toString_main());
//        przedmiot();
//        System.out.println(postac.toString_main());
//        spotkanie_dmg();
//        System.out.println(postac.toString_main());
//        losuj_spotkanie();
//        System.out.println(postac.toString_main());
//        losuj_spotkanie();
//        System.out.println(postac.toString_main());
//        przeciwnik();
//        System.out.println(postac.toString_main());
//        przeciwnik();
//        System.out.println(postac.toString_main());
//        przeciwnik();
//        System.out.println(postac.toString_main());
//        przeciwnik();
//        System.out.println(postac.toString_main());
//        System.out.println(postac.toString2());
        System.out.println(rundy);
        for (int i=0; i<rundy; i++){
            if(rundy<=5 && rundy>0){
                losuj_runde(0.3,0.6,0.7); //30% na spotkanie, przedmiot i szpital, 10% na przeciwnika
                System.out.println(postac.toString_main());
            }else if(rundy<=20 && rundy>5){
                losuj_runde(0.25,0.5,0.75); //25% na spotkanie, przedmiot, szpital i przeciwnika
                System.out.println(postac.toString_main());
            }else if(rundy<=50 && rundy>20){
                losuj_runde(0.1, 0.3, 0.7); //10% na spotkanie, 20% na przedmiot, 40% na przeciwnika i 30% na szpital
                System.out.println(postac.toString_main());
            }
        }
        wygrana();
    }

    //POCZĄTEK FABUŁY
    public static void poczatek(){
        System.out.println("-----------------------------------\n         WITAJ W GRZE RPG\nstworzoną przez: Oleh Radchenko 3P\n-----------------------------------");
        System.out.println("Jaką postacią chcesz zaczynać grę?\n1.Kucharz\n2.Mechanik\n3.Żołnierz");
        postac = Build.zbuduj_postac(podajDane(1,3));
        System.out.print("\n\nA teraz podaj nazwę twojej postaci: ");
        scanner.nextLine(); //INACZEJ NIE DZIAŁCZY TO IMIE
        String imie = scanner.nextLine();
        System.out.println(postac.toString_main());
        sleep(5);
    }

    //SYSTEM LOSOWANIA ITEMKÓW W SKRZYNCE
    public static void przedmiot(){
        System.out.println("\nZnalazłeś skrzynkę, ale jest ona zamknięta na zamek. Twoje szanse na otwarcie go: "+niebieski+postac.getSzansa_wlamania()*100+"%"+reset+"\nCzy chcesz spróbować otworzyć?" + zielony + "\n1.Tak"+reset+czerwony+"\t2.Nie"+reset);
        switch (podajDane(1,2)){
            case 1:
                if(losuj_szanse(postac.getSzansa_wlamania())){
                    sleep(1);
                    System.out.println(zielony+"SUKCES: Skrzynka otwarta"+reset);
                    sleep(2);
                    armor = Build.zbuduj_losowy_item_armor(postac);
                    bron = Build.zbuduj_losowy_item_bron(postac);

                    String jedzenie;
                    if(losuj_szanse(0.5)) jedzenie="[+10hp]";
                    else jedzenie="[+5hp]";

                    System.out.println("\n\nWidzisz tu 3 przedmioty, ale nie możesz wziąść więcej niż 1.\n1."+niebieski+armor.getNazwa()+reset+"\n2."+czerwony+bron.getNazwa()+reset+"\n3."+zielony+"Jedzenie"+reset+zolty+jedzenie+reset);
                    System.out.print("\nKtóry przedmiot wybierzesz?\nWybór: ");
                    switch (podajDane(1,3)){
                        case 1:
                            postac = armor;
                            break;
                        case 2:
                            postac = bron;
                            break;
                        case 3:
                            if(jedzenie.equals("[+10hp]")){
                                postac.dodajHp(10);
                            }else{
                                postac.dodajHp(5);
                            }
                            break;
                        default:
                            System.out.println("Coś poszło nie tak -_-");
                    }
                   // System.out.println(postac.toString_main());
                }else{
                    sleep(1);
                    System.out.println(czerwony+"FAIL"+reset);
                    sleep(2);
                }
                break;
            case 2:
                System.out.println(zielony+"Omijasz tą skrzynkę"+reset);
                break;
            default:
                System.out.println("Coś poszło nie tak ;c");
        }

    }

    //SZPITAL
    public static void szpital(){
        System.out.println("\nChodziłeś po mieście i spotkałeś miłego lekarza który zobaczył twój stan i zaprosił cię do szpitala\nCzy zaakceptujesz zaproszenie? " + zielony + "\n1.Tak"+reset+czerwony+"\t2.Nie"+reset);
        switch (podajDane(1,2)){
            case 1:
                System.out.println(zielony+"Akceptujesz zaproszenie."+reset+zolty+"[+30hp]"+reset);
                sleep(3);
                postac.dodajHp(30);
                break;
            case 2:
                System.out.println(czerwony+"Nie zaakceptowałeś zaproszenia."+reset+zolty+"[nic się nie stało]"+reset);
                sleep(3);
                break;
            default:
                System.out.println("Coś poszło nie tak ;c");
        }
    }
    //SYSTEM ŻEBRANIA OD MIESZKAŃCÓW - SPOTKANIA
    public static void spotkanie_hp(){
        System.out.println("\n\n\nSpotkałeś Pana który ma jedzenie. [Twoje szanse na wyżebranie "+zolty+"+10hp"+reset+" są równe: "+niebieski+postac.getSzansa_wyzebrac()*100+"%"+reset+"]");
        System.out.println("\n\nCzy chcesz spróbować wyżebrać?" + zielony + "\n1.Tak"+reset+czerwony+"\t2.Nie"+reset);
        switch (podajDane(1,2)){
            case 1:
                if(losuj_szanse(postac.getSzansa_wyzebrac())){
                    System.out.println(zielony+"Udało ci się wyżebrać kawałek burgera."+reset+zolty+"[+10hp]"+reset);
                    sleep(3);
                    postac.dodajHp(10);
                }else{
                    System.out.println(czerwony+"Nie udało się wyżebrać"+reset+zolty+"[nic się nie stało]"+reset);
                    sleep(3);
                }
                break;
            case 2:
                System.out.println("Nie to nie."+zolty+"[nic się nie stało]"+reset);
                sleep(2);
                break;
            default:
                System.out.println("Coś poszło nie tak ;c");
        }
    }
    public static void spotkanie_dmg(){
        System.out.println("\n\n\nSpotkałeś Pana który niesie jakąś broń. [Twoje szanse na wyżebranie"+zolty+" +1 losowa broń "+reset+"są równe: "+niebieski+postac.getSzansa_wyzebrac()*100+"%"+reset+"]");
        System.out.println("\n\nCzy chcesz spróbować wyżebrać?" + zielony + "\n1.Tak"+reset+czerwony+"\t2.Nie"+reset);
        bron = Build.zbuduj_losowy_item_bron(postac);
        switch (podajDane(1,2)){
            case 1:
                if(losuj_szanse(postac.getSzansa_wyzebrac())){
                    System.out.println(zielony+"Udało ci się wyżebrać tą dziwną broń."+reset+zolty+"[+"+bron.getNazwa()+"]"+reset);
                    sleep(3);
                    postac = bron;
                }else{
                    System.out.println(czerwony+"Nie udało się wyżebrać, a do tego ten Pan uderzył ciebie."+reset+zolty+"[-10hp]"+reset);
                    sleep(3);
                    if(postac.getHp()<=10){
                        koniec();
                    }else{
                        postac.dodajHp(-10);
                    }
                }
                break;
            case 2:
                System.out.println("Nie to nie."+zolty+"[nic się nie stało]"+reset);
                sleep(2);
                break;
            default:
                System.out.println("Coś poszło nie tak ;c");
        }
    }
    public static void spotkanie_armor(){
        System.out.println("\n\n\nSpotkałeś Pana który niesie stos różnych ubrań. [Twoje szanse na wyżebranie"+zolty+" +1 losowy armor "+reset+"są równe: "+niebieski+postac.getSzansa_wyzebrac()*100+"%"+reset+"]");
        System.out.println("\n\nCzy chcesz spróbować wyżebrać?" + zielony + "\n1.Tak"+reset+czerwony+"\t2.Nie"+reset);
        armor = Build.zbuduj_losowy_item_armor(postac);
        switch (podajDane(1,2)){
            case 1:
                if(losuj_szanse(postac.getSzansa_wyzebrac())){
                    System.out.println(zielony+"Udało ci się wyżebrać ten dziwny armorek."+reset+zolty+"[+"+armor.getNazwa()+"]"+reset);
                    sleep(3);
                    postac = armor;
                }else{
                    System.out.println(czerwony+"Nie udało się wyżebrać"+reset+zolty+"[nic się nie stało]"+reset);
                    sleep(3);
                }
                break;
            case 2:
                System.out.println("Nie to nie."+zolty+"[nic się nie stało]"+reset);
                sleep(2);
                break;
            default:
                System.out.println("Coś poszło nie tak ;c");
        }
    }

    //SYSTEM DOBIERANIA PRZECIWNIKA
    public static void przeciwnik(){
        przeciwnik = Build.zbuduj_losowego_przeciwnika();
        if(przeciwnik instanceof Temperatura){
            if(postac.getObrona_przed_temperatura()){
                System.out.println(jasno_niebieski+"\nJest zimno, ale masz dobre ubranko i nie dostajesz dmg ;3"+reset);
                sleep(3);
            }else{
                System.out.println(czerwony+"\nJest zimno, ale nie masz dobrego ubranka, więc dostajesz obrażenia"+reset+zolty+"[-"+przeciwnik.getDmg()+"hp]"+reset);
                sleep(3);
                if(postac.getHp()<=przeciwnik.getDmg()){
                    koniec();
                }else{
                    postac.dodajHp(-przeciwnik.getDmg());
                }
            }
        }else if(przeciwnik instanceof Szczury){
            System.out.println("\n\nSpotykasz: "+czerwony+przeciwnik.getNazwa()+reset+"\n\nStatystyki przeciwnika: \n-"+czerwony+"Zdrowie = "+przeciwnik.getHp()+reset+"\n-"+niebieski+"Obrażenia = "+przeciwnik.getDmg()+reset);
            if(postac.getObrona_przed_szczurami()){
                System.out.println(czarny+"Posiadasz bron której szczury nie lubią, więc uciekły z pola bitwy."+reset+zolty+"[nic się nie stało]"+reset);
                sleep(3);
            }else{
                czy_napewno_chcesz_walczyc();
            }
        }else if(przeciwnik instanceof Pies){
            System.out.println("\n\nSpotykasz: "+czerwony+przeciwnik.getNazwa()+reset+"\n\nStatystyki przeciwnika: \n-"+czerwony+"Zdrowie = "+przeciwnik.getHp()+reset+"\n-"+niebieski+"Obrażenia = "+przeciwnik.getDmg()+reset);
            if(postac.getObrona_przed_psami()){
                System.out.println(czarny+"Posiadasz bron której psy nie lubią, więc uciekły z pola bitwy."+reset+zolty+"[nic się nie stało]"+reset);
                sleep(3);
            }else{
                czy_napewno_chcesz_walczyc();
            }
        }else if(przeciwnik instanceof Pijak){
            System.out.println("\n\nSpotykasz: "+czerwony+przeciwnik.getNazwa()+reset+"\n\nStatystyki przeciwnika: \n-"+czerwony+"Zdrowie = "+przeciwnik.getHp()+reset+"\n-"+niebieski+"Obrażenia = "+przeciwnik.getDmg()+reset);
            if(postac.getObrona_przed_pijakami()){
                System.out.println(czarny+"Posiadasz bron której pijaki nie lubią, więc uciekły z pola bitwy."+reset+zolty+"[nic się nie stało]"+reset);
                sleep(3);
            }else{
                czy_napewno_chcesz_walczyc();
            }
        }
    }
    //MOŻLIWOŚĆ UCIEC
    public static void czy_napewno_chcesz_walczyc(){
        System.out.println("\n\n\nChcesz zrezygnować z walki?(otrzymujesz wtedy"+czerwony+" -40hp"+reset+")" + zielony + "\n1.Tak"+reset+czerwony+"\t2.Nie"+reset);
        switch (podajDane(1,2)){
            case 1:
                System.out.println("Uciekasz"+zolty+"[-40hp]"+reset);
                sleep(2);
                if(postac.getHp()<=40){
                    koniec();
                }else {
                    postac.dodajHp(-40);
                }
                break;
            case 2:
                walka_turowa();
                break;
            default:
                System.out.println("Coś poszło nie tak ;c");
        }
    }

    //SYSTEM WALKI TUROWEJ
    public static void walka_turowa(){
        int tury = 1;
        int hp_przed = postac.getHp();
        System.out.println("Twoje statystyki: "+postac.toString_main());
        sleep(5);
        while(postac.getHp()>0 && przeciwnik.getHp()>0){
            System.out.println("\n\n----------- TURA "+tury+" -----------");
            System.out.println("Twój ruch: \n"+czerwony+"Masz: "+postac.getHp()+" hp\n"+przeciwnik.getNazwa()+" ma : "+przeciwnik.getHp()+" hp"+reset+"\nSzansa na krytyczny atak: "+niebieski+postac.getSzansa_kritu()*100+"%"+reset);
            sleep(4);
            if(losuj_szanse(postac.getSzansa_kritu())){
                int kryt = postac.getDmg()+10; //Kryt + 10 dmg
                przeciwnik.setHp(przeciwnik.getHp() - kryt);
                if(przeciwnik.getHp()<=0){
                    System.out.println(niebieski+"\nObijasz go za: "+kryt+" hp"+reset+czerwony+"(atak krytyczny) i zauważasz że twój przeciwnik nie żyje."+reset);
                    sleep(5);
                    System.out.println(zielony+"\n\n\nBrawo! Wygrałeś tą walkę!"+reset);
                    sleep(2);
                }else{
                    System.out.println(niebieski+"\nObijasz go za: "+kryt+" hp"+reset+czerwony+"(atak krytyczny)"+reset+"\nZostaje mu: "+czerwony+przeciwnik.getHp()+" hp\n"+reset);
                    sleep(4);
                    postac.dodajHp(postac.getPancerz());
                    postac.setPancerz(0);
                    postac.dodajHp(-przeciwnik.getDmg());
                    if(postac.getHp()<=0){
                        System.out.println("\nRuch przeciwnika: \nObija ciebie za: "+czerwony+przeciwnik.getDmg()+" hp. Nie przeżyłeś tego...."+reset);
                        sleep(3);
                        koniec();
                    }
                    System.out.println("\nRuch przeciwnika: \nObija ciebie za: "+czerwony+przeciwnik.getDmg()+" hp"+reset+"\nZostaje tobie: "+niebieski+postac.getHp()+" hp + pancerz"+reset);
                    sleep(4);
                    tury++;
                }
            }else{
                przeciwnik.setHp(przeciwnik.getHp() - postac.getDmg());
                if(przeciwnik.getHp()<=0){
                    System.out.println(niebieski+"\nObijasz go za: "+postac.getDmg()+" hp"+reset+czerwony+" i zauważasz że twój przeciwnik nie żyje."+reset);
                    sleep(5);
                    System.out.println(zielony+"\n\n\nBrawo! Wygrałeś tą walkę!"+reset);
                    sleep(2);
                }else{
                    System.out.println(niebieski+"\nObijasz go za: "+postac.getDmg()+" hp"+reset+"\nZostaje mu: "+czerwony+przeciwnik.getHp()+" hp\n"+reset);
                    sleep(4);
                    postac.dodajHp(postac.getPancerz());
                    postac.setPancerz(0);
                    postac.dodajHp(-przeciwnik.getDmg());
                    if(postac.getHp()<=0){
                        System.out.println("\nRuch przeciwnika: \nObija ciebie za: "+czerwony+przeciwnik.getDmg()+" hp. Nie przeżyłeś tego...."+reset);
                        sleep(4);
                        koniec();
                    }
                    System.out.println("\nRuch przeciwnika: \nObija ciebie za: "+czerwony+przeciwnik.getDmg()+" hp"+reset+"\nZostaje tobie: "+niebieski+postac.getHp()+" hp + pancerz"+reset);
                    sleep(4);
                    tury++;
                }
            }
        }
        if(postac.getHp()>hp_przed){
            postac.setPancerz(postac.getHp()-hp_przed);
            postac.setHp(hp_przed);
        }
    }

    //ZAKOŃCZENIA GRY
    public static void wygrana(){
        System.out.println(zielony+"Brawo!!!\nWygrałeś i przeżyłeś zimę"+reset+", "+czerwony+"ale nadal jesteś menelem ;c\n"+reset+czarny+"(KONTYNUACJA W DLC XDDD)"+reset);
    }
    public static void koniec(){
        System.out.println(czerwony+"Przegrałeś, ale możesz zacząć od nowa ;3"+reset);
        System.exit(0);
    }


    //SYSTEMY LOSOWAŃ
    public static boolean losuj_szanse(double procent){
        double losowa = Math.random();
        if(losowa<procent){
            return true;
        }else {
            return false;
        }
    }
    public static void losuj_spotkanie(){
        double losowa = Math.random();
        if(losowa<0.33){
            spotkanie_hp();
        }else if(losowa<0.66){
            spotkanie_dmg();
        }else{
            spotkanie_armor();
        }
    }
    public static void losuj_runde(double procent1, double procent2, double procent3){
        double losowa = Math.random();
        if(losowa<procent1){
            losuj_spotkanie();
        }else if(losowa<procent2){
            przedmiot();
        }else if(losowa<procent3){
            przeciwnik();
        }else{
            szpital();
        }
    }

    //SYSTEM WPROWADZANIA LICZB
    public static int podajDane(int od, int do_){
        int wybor=0;
        try{
            wybor = scanner.nextInt();
        }catch(Exception e){
            System.out.println(czerwony+"Nie ładnie tak, zaczynasz od nowa, ale następnym razem wpisz plz liczbę"+reset);
            System.exit(0);
        }
        if(wybor>do_ || wybor<od){
            System.out.println(czerwony+"Nie ładnie tak, zaczynasz od nowa, ale tym razem wpisz plz liczbę w zakresie który podałem ;<"+reset);
            wybor = podajDane(od, do_);
        }else{
            return wybor;
        }
        return wybor;
    }

    //SYSTEM OCZEKIWANIA
    public static void sleep(int sekund){
        try {
            Thread.sleep(sekund*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}