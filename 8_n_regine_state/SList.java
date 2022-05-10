public class SList<T> {

    // public static final BoardSList NULL_BoardSList = new BoardSList ();
    private final boolean empty;
    private final T first;
    private final SList<T> rest;

    /**
     * Costruttore degli oggetti di classe  IntSList
     */

    // l'oggetto è immutabile poichè il contenuto delle variabili d'istanza
    // è privato.

    //di seguito due costruttori con stesso nome ma PARAMETRI diversi(distinzione)

    public SList() // lista nulla/vuota
    {
        // inizializza le variabili d'istanza
        empty = true;
        first = null;
        rest = null;
    }
    public SList( T itm, SList<T> s){
        empty = false;
        first = itm;
        rest = s;
    }

    public boolean isNull() {

        // metti qui il tuo codice
        return empty;
    }

    public T car() {
        return first;
    }

    public SList<T> cdr() { return rest; }

    public SList<T> cons( T itm ){
        return new SList<T>(itm, this);
    }

    public int length (){
        int n = 0;
        if(isNull()){
            return n;
        } else {
            return 1 + cdr().length();
        }
    }

    public T listRef( int k ){
        if (k == 0){
            return car();
        } else {
            return cdr().listRef(k-1);
        }
    }

    public boolean equals( SList<T> s ){
        if ( this.isNull() || s.isNull() ){
            return ( this.isNull() && s.isNull() );}
        else if(this.car() == s.car()) {
            return this.cdr().equals(s.cdr());
        } else {
            return false;
        }
    }

    public SList<T> append( SList<T> s ){
        if (isNull()){
            return s;
        } else {
            return cdr().append(s).cons( car() );
        }
    }

    public SList<T> reverse(){
        return reverseTR( new SList<T>() );
    }

    private SList<T> reverseTR( SList<T> r ){
        if( isNull() ){
            return r;
        } else {
            return cdr().reverseTR( r.cons(car()));
        }
    }

    public String toString(){

        if( isNull()) {
            return "()";
        } else{
            String rep = "(" + car();
            SList<T> r = cdr();
            while ( !r.isNull()){
                rep = rep + ", " + r.car();
                r = r.cdr();
            }return rep + ")";
        }

    }




}
