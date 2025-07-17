import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number1;
        double number2;
        char operator;
        char quit;
        double answer;

        boolean isRunning = true;
        boolean Calculating = true;

        while (isRunning) {
            System.out.println("Please enter the first number");
            number1 = scanner.nextDouble();
            System.out.println("Please enter an operator (*, /, +, -)");
            operator = scanner.next().charAt(0);
            System.out.println("Please enter a second number");
            number2 = scanner.nextDouble();
            while(Calculating){
                switch (operator) {
                    case '*' -> {
                        answer = number1 * number2;
                        System.out.println("= " + answer);
                        Calculating = false;

                    }
                    case '/' -> {
                        answer = number1 / number2;
                        System.out.println("= " + answer);
                        Calculating = false;
                    }
                    case '+' -> {
                        answer = number1 + number2;
                        System.out.println("= " + answer);
                        Calculating = false;

                    }
                    case '-' -> {
                        answer = number1 - number2;
                        System.out.println("= " + answer);
                        Calculating = false;

                    }
                    default -> {
                        System.out.println("Please enter a correct operator");
                        Calculating = false;
                    }
                }


            }
            System.out.println("Would you like to quit? (y/n)");
            quit = scanner.next().charAt(0);
            if(quit == 'y'){
                System.out.println("Thank you");
                isRunning = false;
            }else if(quit == 'n'){
                continue;

            }

        }

    }
}

