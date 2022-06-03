/*
Astrazione sullo stato, esempio tecnica Memoization

la crescita del tempo di calcolo è 3/2^(n-1)

se sono interessato alla risposta di fibonacci 100 posso metterla da parte ci vorrebbero 8 anni stimando 1ns per operaz.

presupponendo l'esistenza di uno stato non rifaccio i conti ogni volta, tipo fib di tre lo sa gia e non lo rifà
 */

public class Memoization{

    public static void main(String[] args) {

        System.out.println(manhMem(18,18));
        System.out.println(manhDp(4,5));
        System.out.println(llcs("principi","princi"));
        System.out.println(llcsMem("principi","princi"));
        System.out.println(lcsMem("arto", "atrio"));
        System.out.println(llcsDp("arto", "atrio"));
        System.out.println(lcsDp("arto", "atrio"));
    }

    // Fibonacci

    public static int fib(int n) {
        if (n < 2){
            return 1;
        } else {
            return fib(n-2) + fib(n-1);
        }

    }
// top down
    public static long fibMem(int n){

        long[] mem = new long [n +1];
        // è un array di zeri, in C non sarebbe così perciò lo inizializzo
        for (int i=0; i<=n; i++){
            mem[i] = UNKNOWN;
        }
        return  fibRec(n, mem);

    }

    private static long fibRec(int n, long[] mem) {
        if (mem[n] == UNKNOWN){
            if (n < 2){
            mem[n] = 1; // registra uno in memoria

        } else {
            mem[n] = fibRec(n-2, mem) + fibRec(n-1, mem);
        }}
        return mem[n];

    }

    private final static int UNKNOWN = 0;

    // Manhattan

    public static long manh(int i , int j){
        if((i == 0) || (j == 0)){
            return 1;
        } else {
            return manh(i-1,j) + manh(i, j-1);
        }
    }

    private static long manhRec(int i , int j,long[][] mem){
        if (mem[i][j] == UNKNOWN){

        if((i == 0) || (j == 0)){
            mem [i][j] =  1;
        } else {
            mem[i][j] = manhRec(i-1,j,mem) + manhRec(i, j-1,mem);
        }
    } return mem[i][j];
}

    public static long manhMem(int i,int j){

        long[][] mem = new long [i +1][j+1];
        // è un array di zeri, in C non sarebbe così perciò lo inizializzo
        for (int u=0; u<=i; u++){
            for (int v=0; v<=j; v++){
            mem[u][v] = UNKNOWN;
        }}
        return  manhRec(i, j, mem);

    }
    // non ci occupiamo dell'ordine con cui calcoliamo,
    // dynamic programming, per casa tartaglia divisione in due per efficenza  // bottom up

    public static long manhDp(int i,int j){

        long[][] mem = new long [i +1][j+1];

        for (int u=0; u<=i; u++){
            for (int v=0; v<=j; v++){
                if((u == 0) || (v == 0)){
                    mem [u][v] =  1;
                } else {
                mem[u][v] = mem[u-1][v] + mem[u][v-1];
            }}
        }
        return  mem[i][j];
    }

    // Numero di lettere della sottosequenza comune piu lunga

    public static int llcs( String u, String v){
        int m = u.length();
        int n = v.length();

        if ((m==0)||(n==0)){
            return 0;
        } else if (u.charAt(0) == v.charAt(0)){
            return 1 + llcs( u.substring(1), v.substring(1));

        } else {
            return Math.max( llcs(u.substring(1),v), llcs(u,v.substring(1)));
        }
    }

    //

    public static int llcsRec( String u, String v, int[][] mem){
        int m = u.length();
        int n = v.length();

        if (mem[m][n] == UNKNOWN){

        if ((m==0)||(n==0)){
            mem[m][n] = 0;
        } else if (u.charAt(0) == v.charAt(0)){
            mem[m][n] = 1 + llcsRec( u.substring(1), v.substring(1),mem);

        } else {
            mem[m][n] = Math.max( llcsRec(u.substring(1),v,mem), llcsRec(u,v.substring(1),mem));
        }} return mem[m][n];

    }

    public static long llcsMem(String u, String v){
        int m = u.length();
        int n = v.length();

        int[][] mem = new int [m+1][n+1];
        // è un array di zeri, in C non sarebbe così perciò lo inizializzo
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                mem[m][n] = UNKNOWN;
            }}
        return  llcsRec(u, v, mem);

    }

    // Stringa della sottosequenza comune più lunga

    public static String lcs( String u, String v){
        int m = u.length();
        int n = v.length();

        if ((m==0)||(n==0)){
            return "";
        } else if (u.charAt(0) == v.charAt(0)){
            return u.substring(0,1) + lcs( u.substring(1), v.substring(1));

        } else {
            return better( lcs(u.substring(1),v), lcs(u,v.substring(1)));
        }
    }

    public static String better ( String u, String v){
        int m = u.length();
        int n = v.length();

        if( m>n){
            return u;
        } else if( m<n){
            return v;
        } if (Math.random() <0.5) {
            return u;
        } else {
           return v;
        }
    }

    public static String lcsRec( String u, String v, String[][] mem){
        int m = u.length();
        int n = v.length();

        if (mem[m][n] == null){

            if ((m==0)||(n==0)){
                mem[m][n] = "";
            } else if (u.charAt(0) == v.charAt(0)){
                mem[m][n] = u.substring(0,1) + lcsRec( u.substring(1), v.substring(1),mem);

            } else {
                mem[m][n] = better( lcsRec(u.substring(1),v,mem), lcsRec(u,v.substring(1),mem));
            }} return mem[m][n];

    }

    public static String lcsMem(String u, String v){
        int m = u.length();
        int n = v.length();

        String[][] mem = new String [m+1][n+1];
        // è un array di zeri, in C non sarebbe così perciò lo inizializzo
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                mem[m][n] = null;
            }}
        return  lcsRec(u, v, mem);

    }

    // llcs dynamic programming

    public static int llcsDp(String u, String v){

        int m = u.length();
        int n = v.length();

        int[][] mem = new int [m+1][n+1];
        // è un array di zeri, in C non sarebbe così perciò lo inizializzo
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){

                    if ((i==0)||(j==0)){
                        mem[i][j] = 0;
                    } else if (u.charAt(m-i) == v.charAt(n-j)){
                        mem[i][j] = 1 + mem[i-1][j-1];

                    } else {
                        mem[i][j] = Math.max( mem[i-1][j],
                                              mem[i][j-1]);
                    }}
                // mem[i][j] = UNKNOWN;
            }
        return  mem[m][n];

    }

    public static String lcsDp(String u, String v){

        int m = u.length();
        int n = v.length();

        int[][] mem = new int [m+1][n+1];
        // è un array di zeri, in C non sarebbe così perciò lo inizializzo
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){

                if ((i==0)||(j==0)){
                    mem[i][j] = 0;
                } else if (u.charAt(m-i) == v.charAt(n-j)){
                    mem[i][j] = 1 + mem[i-1][j-1];

                } else {
                    mem[i][j] = Math.max( mem[i-1][j],
                            mem[i][j-1]);
                }}
            // mem[i][j] = UNKNOWN;
        }
        int i = m;
        int j = n;
        String lcs = "";
        while ( mem[i][j] > 0) {
            if (u.charAt(m-i) == v.charAt(n-j)){
                lcs = lcs + u.charAt(m-i);
                i--;
                j--;
            } else if ( mem[i-1][j] > mem[i][j-1]){
                i--;
            } else if(mem[i-1][j] < mem[i][j-1]){
                j--;
            } else if(Math.random() < 0.5){
                i--;
            } else {
                j--;
            }
        }
        return  lcs;

    }




}

