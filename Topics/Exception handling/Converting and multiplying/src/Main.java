import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            while (true) {
                String num = null;
                try {
                    num = scan.nextLine();
                    if (Integer.parseInt(num) == 0) {
                        break;
                    }
                    System.out.println(Integer.parseInt(num) * 10);
                } catch (RuntimeException e) {
                    System.out.println("Invalid user input: " + num);
                }
            }
    }
}