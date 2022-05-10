/**
 * Aggiungi qui una descrizione della classe TavRotonda
 *
 * new TavRotonda(int n)
 * tav.numeroCavalieri() : int
 * tav.chiHaLaBrocca() : int
 * tav.ritualeCompletato() : boolean
 * tav.serviSidro() : TavRotonda
 * tav.passaBrocca() : TavRotonda
 *
 */
public class TavRotonda1
{
    //
    private final int commensali;
    private final int cavConBrocca;
    private final IntSList altriCavv;



    private TavRotonda1 (int n, int brocca, IntSList lista){

        commensali = n;
        cavConBrocca = brocca;
        altriCavv = lista;
    }

    public TavRotonda1( int n ){

        commensali = n;
        cavConBrocca = 1;
        altriCavv = range(2, n);
    }

    public int quantiCavalieri(){
        return commensali;
    }

    public int chiHaLaBrocca(){
        return cavConBrocca;
    }

    public boolean ritualeCompletato(){
        return ( altriCavv.isNull());
    }

    public TavRotonda1 serviSidro(){
        if (commensali == 1){
            return this;
        } else {

            return new TavRotonda1( commensali - 1, cavConBrocca, altriCavv.cdr() );
        } }


    public TavRotonda1 passaBrocca(){
        if (commensali == 1){
            return this;
        } // commensali maggiori di uno
        IntSList coda = IntSList.NULL_INTLIST.cons(cavConBrocca);
        IntSList nuovaLista = altriCavv.cdr().append(coda);
        return new TavRotonda1( commensali, altriCavv.car(), nuovaLista );
    }

    public TavRotonda1 dopoUscitaCavaliere(){

        TavRotonda1 nuovaTav = serviSidro();
        return nuovaTav.passaBrocca();
    }

    private static IntSList range( int inf, int sup ){
        if ( inf > sup ) {
            return (new IntSList());
        } else {
            return range(inf+1, sup ).cons(inf); //cons a destra, mette davanti
        }
    }


    // ultima graffa
}

