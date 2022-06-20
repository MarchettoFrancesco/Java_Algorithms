import huffman_toolkit.*;
import java.util.*;

import java.util.PriorityQueue;

public class Huffman {

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
        buildTable( root, "", table);
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

    public static String flatTree(Node n){
        if (n.isLeaf()){
        char c = n.symbol();
        if ((c == '@') || (c == '\\')){
            return  "\\" + c ;
        } else {
            return "" + c;
        }

        } else {
            return "@" + flatTree(n.left()) + flatTree(n.right());
        }
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
        char c = in.readChar();
        if (c == '@'){
            Node l = restoreTree(in);
            Node r = restoreTree(in);

            return new Node(l,r);
        } else {
            if( c == '\\'){
                c = in.readChar();
            }
            return new Node(c,0);
        }
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
