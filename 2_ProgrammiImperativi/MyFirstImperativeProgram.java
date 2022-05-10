
/**
 * Aggiungi qui una descrizione della classe MyFirstImperativeProgram
 * 
 * @author (il tuo nome) 
 * @version (un numero di versione o una data)
 */
public class MyFirstImperativeProgram
{
    // massimo comune divisore
    public static int gcd( int x, int y){
        while ( x != y ){
            if ( x < y ){
                y =  y - x;
            } else {
                x = x - y;
            }
            
        } return x;
    }
    // minimo comune multiplo        
    public static int lcm( int x, int y ){
        int m = x;
        
        while (m % y > 0) {
            
            m = m + x;
        }
        return m;
    }
    // numero primo
    public static boolean isPrime ( int n ){ // n > 1
        int d = 2;
        boolean p = true;
        
        while( p && ( d < n)){
            if ( n % d == 0){
                p = false;
            }
            d = d + 1;
        }
        return p;
    }
    // BTR iterativo
    
    public static int btdVal (char btd){
        switch ( btd ){
      case ( '-' ) : { return -1; 
      } 
      case ( '.' ) : { return 0;  
      } 
      case ( '+' ) : { return +1;   
      } 
      default  : { return 0;}
      }
    }
    public static int btrVal ( String btr ){
        
       int n = btr.length();
       int v = 0;
       
       for( int i = 0; i < n; i++ ){
         v = 3 * v + btdVal( btr.charAt(i) ); 
       }
       return v;

    }
    // procedura UFO
    
    public static int ufo( int x ){
        int[] u = new int[ x+1 ];
        
        u[1] = 1;
        for ( int k = 2; k<=x; k = k +1){
        
        if( k % 2 == 0){
            u[k] = 2 * u[k/2] - 1;
        }
        else {
            u[k] = 2 * u[k/2] + 1;
        }
    }return u[x];
    } 
    /**
     *  x = 12
     *  
     *  |   |  1  |  1  |  3  |  1  |  3  |  5  |  7  |  1  |  3  |  5  |  7  |  9  |
     *    0    1     2     3     4     5     6     7     8     9    10     11    12 
     *  
     */
    
    // rivisita
    
    public static int ufot ( int x ){
       
        int[] u = new int[logSize(x)];
        u[0] = x;
        int i = 0;
        
        while( x > 1 ) {
            
            x = x/2;
            i++;
            u[i] = x;             
        }
        
        int y = 1;
        for ( int j = i-1; j >= 0; j--){
            if ( u[j] % 2 == 0){
                y = 2 * y - 1; 
            } else {
                y = 2 * y + 1;
            }
            
        } return y;
    }
    
    
    private static int logSize( int n ){
        
        return (int) (Math.log(n) / Math.log(2))+1 ;
    }
    
    // insertion sort riordinamento array
    
    public static void insSort( double[] v ){
        
        for ( int k = 2; k < v.length; k++ ){
            
            double x = v[k];
            int i = k - 1;
            while (i >= 0 && ( x < v[i] )){
                
                v[i+1] = v[i];
                i--;
            }
            v[i+1]= x;
        }
    }
    
    // double[] v = new double[]{3.4,2.1,5.7,4.0,1.8}
}
