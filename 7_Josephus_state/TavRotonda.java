
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
    //
    private int n; // non piu final perché cambierà, numero commensali
    private int b; // posizione cavaliere con la brocca
    private int[] cavv; // etichette dei cavalieri

   /* private TavRotonda (int n, int brocca, IntSList lista, IntSList lista2){

        commensali = n;
        cavConBrocca = brocca;
        altriCavv = lista;
        altriRovesc = lista2;
    } */
    
    public TavRotonda( int n ){

        this.n = n;
        b = 0;
        cavv = new int[ n+n-1 ];
        for (int i=0; i<n; i++){
            cavv[i] = i+1;
        }
    }
    
    public int quantiCavalieri(){
        return n;
    }
    
    public int chiHaLaBrocca(){
        return cavv[b];
    }
    
    public boolean ritualeCompletato(){
        return ( n == 1);
    }
    
    public void serviSidro(){
        if (n > 1){
            cavv[b+1] = cavv[b];
            b++;
            n--;
        }
        }
    
    
    public void passaBrocca(){
        if(n > 1){
            cavv[b+n] = cavv[b];
            b++;
        }
    }
    
    public void dopoUscitaCavaliere(){
        
        serviSidro();
        passaBrocca();
    }



    // ultima graffa
}


/*
 1 2 3 4 5 6 ...
 x 1 3 4 5 6
 x x 3 4 5 6 1
 x x x 3 5 6 1
 x x x x 5 6 1 3

 */