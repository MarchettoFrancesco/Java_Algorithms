/*
Board b

new Board( n )

b.size() : int

b.queensOn() : int

b.underAttack(i, j) : i,j coordinate : valore booleano

b.addQueen(i, j) : Board

b.arrangement() : String

_ _ _ _     x _ _ _     x _ _ _     x _ _ _
_ _ _ _     _ _ _ _     _ _ x _     _ _ _ x
_ _ _ _ --> _ _ _ _ --> _ _ _ _  &  _ _ _ _
_ _ _ _     _ _ _ _     _ _ _ _     _ _ _ _
                           |           |
                        non posso   x _ _ _
                                    _ _ _ x stop
                                    _ x _ _
pensiamo di posizionare una regina in ogni colonna della stessa riga e  procediamo ricorsivamente dalle nuove configurazioni
inseriamo le condizioni


vede diagonali come somma coordinate
stessa riga u = i
stessa colonna v = j
u-v = i-j
u+v = i+j
 */


import java.util.function.*;

public class Board {

    private static final String cols = " ABCDEFGHIJKLMNO";
    private static final String rows = " 123456789ABCDEF";

    public final int size;                              // 1) dimensione scacchiera

    public int queens;                                  // 2) numero regine collocate
    private int[] rowAttacks;
    private int[] colAttacks;
    private int[] dg1Attacks;
    private int[] dg2Attacks;
    private String config;                        // 4) disposizione delle regine:


    public Board(int n){
        size = n;
        queens = 0;
        rowAttacks = new int[n];
        colAttacks = new int[n];
        dg1Attacks = new int[2*n-1];
        dg2Attacks = new int[2*n-1];
        for ( int i = 0; i>n;i++){
            rowAttacks[i] = 0;
            colAttacks[i] = 0;
            dg1Attacks[i] = 0;
            dg2Attacks[0] = 0;
        }
        for ( int i = n; i>2*n-1;i++){

            dg1Attacks[i] = 0;
            dg2Attacks[0] = 0;
        }
        config = "";
    }

    public int size(){
        return size;
    }

    public int queensOn(){
        return queens;
    }

    public boolean underAttack(int i, int j){
        int n = size;
        return ( rowAttacks[i-1] > 0 ||
                 colAttacks[j-1] > 0 ||
                 dg1Attacks[i-j+n-1] > 0 ||
                 dg2Attacks[i+j-2] > 0 );
    }

    public void addQueen(int i, int j){
        int n = size;

        queens = queens + 1;
        rowAttacks[i-1] = rowAttacks[i-1] + 1 ;
        colAttacks[j-1] = colAttacks[j-1] + 1;
        dg1Attacks[i-j+n-1] = dg1Attacks[i-j+n-1] + 1;
        dg2Attacks[i+j-2] = dg2Attacks[i+j-2] + 1;
        config = config + locCode(i,j);
    }
    public String arrangement(){
        return config;
    }
    public String toString(){
        return "Q[" + arrangement() + "]";
    }
    private static String locCode(int i, int j){
        return " " + cols.charAt(j) + rows.charAt(i) + " ";
    }



}