import huffman_toolkit.InputTextFile;
import huffman_toolkit.OutputTextFile;
import java.util.*;
import java.util.PriorityQueue;


// utilizzo di stack al posto della ricorsione, si trova in java util

class Frame{
    public final Node node;
    public final String code;
    public Frame(Node node, String code){
        this.node = node;
        this.code = code;

    }
}

class RecFrame{
    public int state;
    public Node lft, rgt;
    public RecFrame(){
        state = 0;
        lft=null;
        rgt = null;

    }
}
public class HuffmanIterative {

    public static void main(String[] args) {
        //System.out.println(HuffmanTree(charFreq("copia.txt")).weight());
        System.out.println(compress("copia.txt", "hffmn.txt"));
        //decompress("hffmn.txt", "copiad.txt", compress("copia.txt", "hffmn.txt"));
        //System.out.println(IOTest.copyFile("/Users/francescomarchetto/Documents/UNIVERSITA/Programmazione/Programma_Java/9_/IOTest.java","copia.txt"));
    }
    public static final int CHARS = InputTextFile.CHARS;
    public static int[] charFreq(String src){

    int[] freq = new int[CHARS];
    for (int i=0; i<CHARS ; i++){
        freq[i] = 0;
    }
    InputTextFile in = new InputTextFile(src);
    while (in.textAvailable()){
        char c = in.readChar();
        freq[c]= freq[c] + 1;
        }
    in.close();

    return freq;
    }

    // costruzione albero di huffman

    public static Node HuffmanTree(int[] freq){
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        for (int i=0;i<CHARS; i++){
            if (freq[i] > 0){
                Node n = new Node((char) i, freq[i]);
                queue.add(n);
            }
        }
        while (queue.size() > 1){
            Node l = queue.poll();
            Node r = queue.poll();
            Node n = new Node(l, r);
            queue.add(n);
        } return queue.poll();
    }

    public static String[] huffmanCodes(Node root){
        String[] table = new String[ CHARS ];

        Stack<Frame> stack = new Stack<Frame>();
        stack.push(new Frame(root,""));
        while (!stack.empty()){
            Frame f = stack.pop();
            Node n = f.node;
            String code = f.code;

            if (n.isLeaf()) {
                char c = n.symbol();
                table[c] = code;
            }else {
                stack.push(new Frame(n.right(),code+"1"));
                stack.push(new Frame(n.left(), code+"0"));

            }
        }
        return table;
    }

    public static void buildTable(Node n,String code, String[] table){
        if (n.isLeaf()){
            char c = n.symbol();
            table[c] = code ;
        } else {
            buildTable(n.left(), code+"0", table);
            buildTable(n.right(), code+"1", table);
        }
    }

    /*
    @[@[] [@G A] C] sottoalbero sinistro [T] sottoalbero destro

    @@@GACT

    @ [@ [T] [@ R E] ]  [@ [A] [@ [@ [@ [O] [S] ] [I]] [L] ]

    @@T@RE @A@@@OSIL
     */


    public static String flatTree(Node root){
        Stack<Node> stack = new Stack<Node>();
        String flat = "";

        stack.push(root);

        while (!stack.empty()){

            Node n = stack.pop();

            if (n.isLeaf()){
                char c =n.symbol();
                if ((c == '0') || (c == '\\')){
                    flat = flat + "\\" + c;
                } else{
                flat = flat + c;
            }} else {
                flat = flat + "@";
                stack.push(n.left());
                stack.push(n.right());
            }}
        return flat;
    }

    public static Node compress(String src, String dst){
        int[] freq = charFreq(src);

        Node root = HuffmanTree(freq);
        String[] tab = huffmanCodes(root);

        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);

        out.writeTextLine("" + root.weight());
        out.writeTextLine(flatTree(root));
        while (in.textAvailable()){
            char c = in.readChar();
            out.writeCode(tab[c]);
        }
        in.close();
        out.close();
        return root;
    }

    public static Node restoreTree(InputTextFile in){
        Stack<RecFrame> stack = new Stack<RecFrame>();
        stack.push(new RecFrame());

        Node n = null;
        while (!stack.empty()){
            RecFrame rec = stack.peek();

            if (rec.state == 0){
                char c = in.readChar();
                if (c == '0'){

                    rec.state=1;
                    stack.push(new RecFrame());
                } else{
                    if (c == '\\'){
                        c = in.readChar();
                    } n = new Node(c,0);
                    stack.pop();
                }
            } else if (rec.state==1){
                rec.lft = n;
                rec.state = 2;
                stack.push(new RecFrame());
            } else {
                rec.rgt = n;
                n = new Node(rec.lft, rec.rgt);
                stack.pop();
            }
        } return n;
    }

    public static void decompress(String src, String dst){


        InputTextFile in = new InputTextFile(src);
        OutputTextFile out = new OutputTextFile(dst);


        int count = Integer.parseInt(in.readTextLine());

        Node root = restoreTree(in);
        String dummy = in.readTextLine();
        for (int i=0; i<count; i++){
            Node n = root;
            do {
                int b = in.readBit();
                if (b == 0){
                    n = n.left();
                } else{
                  n = n.right();
                }
            }while (!n.isLeaf());

            char c = n.symbol();
            out.writeChar(c);
        }

        in.close();
        out.close();

    }


}
