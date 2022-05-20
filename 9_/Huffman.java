import huffman_toolkit.*;

public class Huffman {

    public static void main(String[] args) {
        // System.out.println(charFreq("IOTest.java"));
        // System.out.println(IOTest.copyFile("/Users/francescomarchetto/Documents/UNIVERSITA/Programmazione/Programma_Java/9_/IOTest.java","copia.txt"));
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
}
