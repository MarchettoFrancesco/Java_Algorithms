
/**
 * Aggiungi qui una descrizione della classe GiuseppeFlavio
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class GiuseppeFlavio
{
    public static void main(String[] args) {
        System.out.println(testGFlavio1(12));

    }

    public static int testGFlavio1 (int n) {
        TavRotonda tav = new TavRotonda( 1);
        for (int k =1 ; k<=n; k++){
            tav = new TavRotonda( k);
        }

        while ( tav.quantiCavalieri() > 1 ) {  // ! tav.ritualeCompletato()

            tav.serviSidro();
            tav.passaBrocca();

            // tav = tav.dopoUscitaCavaliere();
        } return tav.chiHaLaBrocca();
    }
}