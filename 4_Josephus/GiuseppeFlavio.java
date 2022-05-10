
/**
 * Aggiungi qui una descrizione della classe GiuseppeFlavio
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class GiuseppeFlavio
{
    public static void main(String[] args) {
        System.out.println(testGFlavio(5));

    }
    public static int ultimoCavaliere(int n) {
        TavRotonda1 tav = new TavRotonda1( n );
        while ( tav.quantiCavalieri() > 1 ) {  // ! tav.ritualeCompletato()

            tav = tav.serviSidro();
            tav = tav.passaBrocca();

            // tav = tav.dopoUscitaCavaliere();
        } return tav.chiHaLaBrocca();
    }
    public static int testGFlavio (int n) {
        TavRotonda1 tav = new TavRotonda1( 1);
        for (int k =1 ; k<=n; k++){
            tav = new TavRotonda1( k);
        }

        while ( tav.quantiCavalieri() > 1 ) {  // ! tav.ritualeCompletato()

            tav = tav.serviSidro();
            tav = tav.passaBrocca();

            // tav = tav.dopoUscitaCavaliere();
        } return tav.chiHaLaBrocca();
    }
    public static int testGFlavio1 (int n) {
        TavRotonda tav = new TavRotonda( 1);
        for (int k =1 ; k<=n; k++){
            tav = new TavRotonda( k);
        }

        while ( tav.quantiCavalieri() > 1 ) {  // ! tav.ritualeCompletato()

            tav = tav.serviSidro();
            tav = tav.passaBrocca();

            // tav = tav.dopoUscitaCavaliere();
        } return tav.chiHaLaBrocca();
    }
}