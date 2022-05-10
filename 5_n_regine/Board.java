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
    public final int queens;                            // 2) numero regine collocate
    private final BiPredicate<Integer,Integer> attack;
    private final String config;                        // 4) disposizione delle regine:


    public Board(int n){
        size = n;
        queens = 0;
        attack = (x, y) -> false;
        config = "";
    }
    private Board ( Board b, int i, int j ){
    size = b.size();
    queens = b.queensOn() + 1;
    attack = (x, y) -> ( (x == i) || (y == j) || (x-y == i-j) || (x+y == i+j) || b.underAttack(x, y) );
    config = b.arrangement() + locCode(i, j);
}
public int size(){
    return size;
}

public int queensOn(){
    return queens;
}

public boolean underAttack(int i, int j){
    return attack.test(i, j);
}

public Board addQueen(int i, int j){
    return new Board(this, i, j);
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