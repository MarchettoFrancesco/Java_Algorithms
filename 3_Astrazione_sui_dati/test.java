
/**
 * Aggiungi qui una descrizione della classe com.company.StringSList.test
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class test {
    
    public static IntSList range( int inf, int sup ){
        if ( inf > sup ) {
            return (new IntSList());
        } else {
            return range(inf+1, sup ).cons(inf); //cons a destra, mette davanti
        }
    }
    


public static void main( String[] args ){
    
    IntSList lista = range(11, 20);
    System.out.println(lista.reverse());
    System.out.println( "bye.");
}
}