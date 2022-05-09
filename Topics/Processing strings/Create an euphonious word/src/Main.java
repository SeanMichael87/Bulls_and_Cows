import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String[] word = scan.nextLine().split("");
        String word = scan.nextLine();
        String[] wordList = word.split("");
        String vowel = "aeiouy";
        String conso = "bcdfghjklmnpqrstvwxz";
        int insert = 0;
        int threeV = 0;
        int threeC = 0;

        for (String character: wordList) {
             threeV = vowel.contains(character) ? threeV + 1 : 0;
             threeC = conso.contains(character) ? threeC + 1 : 0;
            if (threeC > 2 || threeV > 2) {
                insert++;

            }
        }
        System.out.println(insert);
    }
}