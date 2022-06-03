public class Node implements Comparable<Node>{

    private final char sym;
    private final int wgt;

    private final Node lft;
    private final Node rgt;


    public Node (char c, int w){
        sym = c;
        wgt = w;
        lft = null;
        rgt = null;
    }

    public Node(Node l,Node r){
        sym = (char) 0;
        wgt = l.weight()+r.weight();
        lft = l;
        rgt = r;
    }

    public boolean isLeaf(){
    return (lft == null);
    }

    public char symbol(){
    return sym;
    }
    public int weight(){ // peso/numero occorrenze
    return wgt;
    }

    public Node left(){
    return lft;
    }
    public Node right(){
    return rgt;
    }

    public int compareTo( Node other){
        if(weight() < other.weight()){
            return -1; // priorità rispetto all'argomento perchè più piccolo
        } else if(weight() > other.weight()){
            return +1;
        } else {
            return 0;
        }
    }

}
