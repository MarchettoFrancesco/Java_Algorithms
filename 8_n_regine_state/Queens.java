public class Queens {

    public static void main(String[] args) {
        System.out.println(numberOfSolutions(6));
        System.out.println(listOfSolutions(6).toString());

    }

    public static int numberOfSolutions(int n) {
        return numberOfCompletions(new Board(n) );
    }

    private static int numberOfCompletions(Board board) {

        int n = board.size();
        int q = board.queensOn();

        if (q == n) {

            return 1;
        } else {

            int count = 0;
            int i = q + 1;

            for (int j = 1; j <= n; j++) {
                if (!board.underAttack(i, j)) {
                    board.addQueen(i, j);
                    count = count + numberOfCompletions(board);
                    board.removeQueen(i,j);
                }
            }
            return count;
        }
    }


    public static SList<String> listOfSolutions(int n){
        return listOfCompletions( new Board(n));
    }

    private static SList<String> listOfCompletions(Board board){

        int n = board.size();
        int q = board.queensOn();

        if ( q == n){

            return (new SList<String>()).cons(board.toString());
        } else {
            SList<String> list = new SList<String>();
            int i = q + 1;

            for(int j = 1;  j <= n; j++){
                if( !board.underAttack(i, j) ){
                    board.addQueen(i, j);
                    list = list.append(listOfCompletions(board));
                    board.removeQueen(i,j);
                }
            } return list;
        }
    }
}

