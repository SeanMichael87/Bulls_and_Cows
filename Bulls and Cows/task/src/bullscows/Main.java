package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int counter = 1;

        while (!flag) {
            try {
                System.out.println("Please, enter the secret code's length");
                int difficulty = scan.nextInt();
                System.out.println("Input the number of possible symbols in the code:");
                int charLimit = scan.nextInt();

                if (difficulty == 0 || difficulty > 10 || charLimit < difficulty || charLimit > 36) {
                    System.out.printf("Error: can't generate a secret number with a length of %d because" +
                            " there aren't enough unique digits.\n", difficulty);
                } else {

                    secretNumOut(difficulty, charLimit);
                    System.out.println("OK! Let's start the game!");

                    String userNum = scan.nextLine();
                    Game game1 = new Game(difficulty, charLimit, userNum);

                    while (game1.getBulls() < difficulty) {
                        try {
                            System.out.printf("Turn %d:\n", counter);

                            userNum = scan.nextLine();

                            game1.userList(userNum);
                            game1.result();
                            game1.grade();
                            counter++;
                        } catch (Exception e) {
                            System.out.println("Your input was less than the secretCode length try again");
                            game1.reset();
                            continue;
                        }
                    }
                }
                System.out.print("Congratulations! You guessed the secret code.");
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Error");
                break;
            }
        }
    }
    public static void secretNumOut(int difficulty, int charLimit) {
        int numCharacter = charLimit - 10;
        String charList = "abcdefghijklmnopqrstuvwxyz";
        if (numCharacter <= 0) {
            System.out.println("The secret is prepared: " + "*".repeat(difficulty) + " (0-9 ," + charList.charAt(0));
        } else {
            System.out.println("The secret is prepared: " + "*".repeat(difficulty) + " (0-9 ," + charList.charAt(0) + "-" + charList.charAt(numCharacter - 1) + ")");
        }
    }

}

class Game {
    String userInput;
    StringBuilder secretNum = new StringBuilder(); //updated by numGenerator
    List<String> secretNumList = new ArrayList<>();
    List<String> userNumList = new ArrayList<>();
    int bulls = 0;
    int cows = 0;
    int difficulty;

    public Game(int difficulty, int addchar, String userInput) {
        randomNumGenerator(difficulty, addchar);
        this.userInput = userInput;
        this.difficulty = difficulty;
    }
    public void randomNumGenerator(int difficulty, int addChar) {
        int numCharacter = addChar - 10;
        List<String> randomNum = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        List<String> randChar = new ArrayList<>(List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j","k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        List<String> userDiff = randChar.subList(0, Math.abs(numCharacter - 1));
        randomNum.addAll(userDiff);
        Collections.shuffle(randomNum);

        //var automatically detects datatype and subList is method from ArrayList
        for (var num : randomNum.subList(0, difficulty)) {
            secretNum.append(num);
        }
        newList();
    }

    private void newList() {
        String randString = secretNum.toString();
        this.secretNumList = List.of(randString.split(""));
    }

    public void userList(String userInput) {
        this.userNumList = List.of(userInput.split(""));
    }

    public int getBulls() {
        return bulls;
    }

    public void result() {
//        System.out.println(userNumList);
//        System.out.println(secretNumList);
        for (int i = 0; i < secretNumList.size(); i++) {

            if (Objects.equals(secretNumList.get(i), userNumList.get(i))) {
                bulls++;
            } else if (secretNumList.contains(userNumList.get(i))) {
                this.cows++;
            }
        }
    }

    public void reset() {
        this.bulls = 0;
        this.cows = 0;
    }

    public void grade() {
        if (bulls > 0 && cows > 0) {
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n", bulls, cows);
            reset();
        } else if (cows > 0 && bulls == 0) {
            System.out.printf("Grade: %d cow(s).\n", cows);
            reset();
        } else if (bulls > 0 && cows == 0) {
            if (bulls < difficulty) {
                System.out.printf("Grade: %d bulls(s).\n", bulls);
                reset();
            } else {
                System.out.printf("Grade: %d bulls(s).\n", bulls);
            }
        } else {
            System.out.print("None.\n");
        }
    }
}
