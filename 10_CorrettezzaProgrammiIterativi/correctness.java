// x * y, raddoppio x e dimezzo y, quando y è dispari sommo a Z il valore di x corrispondente e alla fine xy+z ottengo x+y iniziale

public class correctness {

    public static int sqr( int n){
        int x = 0;
        int y = 0;
        int z = 1;
        while (x<n){
            x = x + 1;
            y = y + z;
            z = z + 2;
        }
        return y;
    }

    /*
    pre condizione: i dati di input sensati: interi non negativi

    post condizione: il valore che restituiamo è n*n

    '=valori seconda iterazione
    x'=x+1 1
    y'=y+z 2
    z'=z+2 5
     */

    public static int lcm(int m,int n){
        int x = m;
        int y = n;

        while (x != y){
            if (x < y){
                x = x + m;
            } else {
                y = y + n;
            }
        } return x;
    }

    /*
    pre m n > 0
    post x = mcm m n

    INVariante inv(m,n) 0 < m, n<= mcm(m,n), m mod m = n mod n = 0 ok

    Invariante si conserva?
    Inv(x,y) & x!=y ==> Inv(x',y')

     assumo 0< x, y <= mcm(m,n)    x mod m = y mod n = 0

     dimostro 0<x', y' <=mcm(m,n) x' mod m = y' mod n = 0

     assumo x < y
     dimostro 0<x+m , y<= mcm(m,n) (x+m) mod m = y mod n = 0

     assumo x >= y &  ==> x>y

     dimostro  0<x y+n <= mmc(m,n) x mod m = y+n mod n = 0

     inv(x,y) & (x = y) ==> post(x,y)

     assumo 0<x, y <= mcm(m,n) x mod m = y mod n = 0 x=y



     */

}
