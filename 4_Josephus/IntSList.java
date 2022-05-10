
/**
 * in scheme usiamo null per la lista vuota
 * null? per la domanda se è vuota
 * 
 *  null --> new IntSList : IntSList
 * (null? s) --> s.isNull() : boolean
 * (car s) -->  s.car() : int
 * (cdr s) -->  s.cdr() : IntSList
 * (cons n s) --> s.cons(n) : 
 */
public class IntSList
{
    // variabili d'istanza - aggiungo final cioè non verrà piu modificato11
    
    //costante per lista vuota
    public static final IntSList NULL_INTLIST = new IntSList();
    private final boolean empty;
    private final int first;
    private final IntSList rest;

    /**
     * Costruttore degli oggetti di classe  IntSList
     */
    
    // l'oggetto è immutabile poichè il contenuto delle variabili d'istanza
    // è privato.
    
    //di seguito due costruttori con stesso nome ma PARAMETRI diversi(distinzione)
    
    public IntSList() // lista nulla/vuota
    {
        // inizializza le variabili d'istanza
        empty = true;
        first = 0;
        rest = null;
    }
    public IntSList( int n, IntSList s){
        empty = false;
        first = n;
        rest = s;
    }
    
    public boolean isNull() {
    
        // metti qui il tuo codice
        return empty;
    }
    
    public int car() {
        return first;
    }
    
    public IntSList cdr() {
        return rest;
    }
    
    public IntSList cons ( int n ) {
        return ( new IntSList(n,this)); // this = il destinatario della req.
    }
    
    // operazioni su liste
    
    // length
    public int length (){
        int n = 0;
        if(isNull()){
            return 0;
        } else {
            return 1 + cdr().length();
        }
    }
    // list-ref
    
    public int listRef( int i ){
        if ( i == 0){
            return car();
        } else {
            return cdr().listRef(i-1);
        }
    }
    // equal?
    
    public boolean equals( IntSList s ){
        if ( isNull() || s.isNull() ){
            return ( isNull() && s.isNull() );
        } else if ( car() == s.car() ){
            return cdr().equals(s.cdr());
        } else {
            return false;
        }
    }
    // append
    public IntSList append( IntSList s){
        if ( isNull() ){
            return s;
        } else {
            return cdr().append(s).cons( car() );
        }
    }
    // reverse
    
    public IntSList reverse(){
        return reverseRec( NULL_INTLIST );
    }
    
    private IntSList reverseRec( IntSList r ){
        if( isNull() ){
            return r;
        } else {
            return cdr().reverseRec( r.cons(car()));
        }
    }
    
    public String toString(){
        String desc = "(";
        
        if( !isNull()){
            desc = desc + car();
            IntSList r = cdr();
            while ( !r.isNull()){
                desc = desc + ", " + r.car();
                r = r.cdr();
            }
        }
        return desc + ")";
    }
    
    /* l' uguale confronta l'identità dell'oggetto, si puo usare per numeri..
     * non per oggetti perchè risponde alla domanda sono lo stesso oggetto?
     * come risultato di unica creazione, gli oggetti visti sono creati indi
     * pendentemente hanno lo stesso contenuto ma non sono lo stesso.
     * 
     * IntSList l1 = new IntLSlist();
     * IntSList l2 = new IntLSlist();
     * 
     * l1 == l2 --> false
     * l1.equals( l2 ) --> true
     * 
     * l1 = IntSList.NULL_INTLIST;
     * l2 = IntSList.NULL_INTLIST;
     * 
     * l1 == l2 --> true
     * 
     * l1 = Test.range(1, 5);
     * l2 = Test.range(1, 5);
     * 
     * l1 == l2 --> false
     * l1.equals( l2 ) --> true
     * 
     * 
     */
}