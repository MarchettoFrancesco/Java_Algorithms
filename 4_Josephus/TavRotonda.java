
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
public class TavRotonda
{
    private final int commensali;
    private final int cavConBrocca;
    private final IntSList altriCavv;
    private final IntSList altriRovesc;
    


    private TavRotonda (int n, int brocca, IntSList lista, IntSList lista2){

        commensali = n;
        cavConBrocca = brocca;
        altriCavv = lista;
        altriRovesc = lista2;
    }
    
    public TavRotonda( int n ){

        commensali = n;
        cavConBrocca = 1;
        altriCavv = range(2, n);
        altriRovesc = IntSList.NULL_INTLIST;
    }
    
    public int quantiCavalieri(){
        return commensali;
    }
    
    public int chiHaLaBrocca(){
        return cavConBrocca;
    }
    
    public boolean ritualeCompletato(){
        return ( commensali == 1);
    }
    
    public TavRotonda serviSidro(){
        if (commensali == 1){
            return this;
        } else if ( altriCavv.isNull()) {
            IntSList listaRovesc = altriRovesc.reverse();
            return new TavRotonda( commensali - 1, cavConBrocca, listaRovesc.cdr(), IntSList.NULL_INTLIST );
        }

        else {
            return new TavRotonda( commensali - 1, cavConBrocca, altriCavv.cdr(), altriRovesc );
            }
        }
    
    
    public TavRotonda passaBrocca(){
        if (commensali == 1){
            return this;
        } // commensali maggiori di uno
        else if(altriCavv.isNull()){
            IntSList listaRovesc =  altriRovesc.reverse();
            IntSList lista2 = IntSList.NULL_INTLIST.cons(cavConBrocca);

            return new TavRotonda(commensali , listaRovesc.car(), listaRovesc.cdr(), lista2);
        }else {
        return new TavRotonda( commensali, altriCavv.car(), altriCavv.cdr(), altriRovesc.cons(cavConBrocca) );
        }
    }
    
    public TavRotonda dopoUscitaCavaliere(){
        
        TavRotonda nuovaTav = serviSidro();
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


/*
 9 1 (2 3 4 5 6 7 8 9) ()
 8 1 (3 4 5 6 7 8 9) () [servi]
 8 3 ( 4 5 6 7 8 9) (1) [passa]
 7 3 (5 6 7 8 9) (1) [servi]
  7 5 (6 7 8 9) (3 1) [passa]
  6 5 (7 8 9) ( 3  1 ) [servi]
  6 7 ( 8 9) (5 3 1 ) [passa]
  5 7 (9) (5 3 1 ) [servi]
  5 9 () (7 5 3 1) [passa]  rovescio la lista dentro la prima
  5 9 ( 1 3 5 7) () [servi]
  4 9 (3 5 7) ()
  4 3(5 7) (9)
  3 3 (7) (9)
  3 7 () (3 9)
  2 7 (3) ()
  2 3 () 7
  1 3 () ()

 */