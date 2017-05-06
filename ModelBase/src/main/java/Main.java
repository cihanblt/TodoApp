/**
 * Created by cihan on 26.03.2017.
 */
public class Main {

//    public static void main(String[] args) {
//        System.out.println(reversWord("cihan"));
//    }

    public static String reversWord(String w){
        char c[] = new char[w.length()];
        for (int i = w.length()-1 ; i>=0;i-- ){
            c[w.length()-1-i] = w.charAt(i);
        }
        return new String(c);
    }
}
