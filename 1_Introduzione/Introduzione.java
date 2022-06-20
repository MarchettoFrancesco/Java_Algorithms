
/**
 * Aggiungi qui una descrizione della classe Introduzione
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class Introduzione
{

//superficie totale cilindro

    public static double supTotCil( double r, double h ){

      return (2 * Math.PI * r * (r + h));
    }
    //plurale sostantivo maschile
    public static String pluraleSm( String s ){
      return (s.substring(0,(s.length() - 1)))+"i";
    }
    public static String pluraleSf( String s ){
      return (s.substring(0,(s.length() - 1)))+"e";
    }

    //è femminile?
    public static boolean femminile( String s ){

      return (s.charAt(s.length() - 1) == 'a');
      //confronto di oggetti solitamente non si esegue con ==, ok equal
      // return(s.substring(s.length() - 1).equals("a"));
    }
    //plurale femminile e maschile
    public static String plurale( String s){
        if( femminile(s)){
           return pluraleSf(s);
        } else{
           return pluraleSm(s);
        }
        //return( femminile(s) ? pluraleSf(s) : pluraleSm(s) );
    }
    //fibonacci
    public static int fibonacci(int n){
        if ( n < 2 ) {
            return 1;
        } else {
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }
    //lunghezza lato minore formato carta A1-2..
    public static double s(int k ){
        if ( k < 2){
            return ( k == 0 ) ? S0:S1;
        } else {
            return s( k-2 ) / 2;
        }
    }
    //final significa che il valore non sarà cambiato, identifica costante
    public static final double S0 = 100 *  Math.pow( 2, +0.25);
    public static final double S1 = 100 *  Math.pow( 2, -0.25);


    public static String onesComplement( String bin ){
        if ( bin.equals("")){
            return "";
        } else {
            return  bitComplement(bin.substring(0,1))
                    + onesComplement(bin.substring(1));
        }
    }
    public static String bitComplement( String bit ){
        if (bit.equals("0")){
            return "1";
        } else {
            return "0";
        }
        // return ( bit.equals("0") ? "1" : "0");
    }
    // rappresentazione ternaria bilanciata
    public static int btrVal ( String btr ){
        int k = btr.length() - 1;
        String pre = btr.substring( 0,k );
        char lsd = btr.charAt(k);

        if (k == 0){
            return btdVal(lsd);
        }else {
            return 3 * btrVal(pre) + btdVal(lsd);
        }
    }
    private static int btdVal( char btd){
        if (btd == '-') {
            return -1;
        } else if (btd == '.'){
            return 0;
        } else if ( btd == '+'){
            return +1;
        } else {
        return 0;

        /*
         * switch ( btd ){
         *  case ( '-' ) : { return -1;
         * }
         * case ( '.' ) : { return 0;
         * }
         * case ( '+' ) : { return +1;
         * }
         * default  : { return 0;}
         * }
        */
    }
    }
}

