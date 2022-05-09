import java.util.Arrays;
import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        String nums = "1234567890 ";
        StringBuilder newWord = new StringBuilder();
        for (String items : strings) {
            if (nums.contains(items)) {
                continue;
            } else {
                newWord.append(items);
            }
        }
        return newWord.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }
}