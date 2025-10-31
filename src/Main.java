import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("WORK OUT THE AVERAGE OF YOUR TEST SCORES:");
        System.out.println("=========================================");

        String input; // user input
        boolean isValid; // checks if input is valid
        int maxNumber; // max number of scores
        int scoreCount = 0; // tally of scores entered
        int count = 0; // count of scores entered by user
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("How many scores do you want to enter (must be a number) ? ");
            input = sc.nextLine();
            isValid = validateInput(input);
            if(isValid) {
                maxNumber = Integer.parseInt(input);
                break;
            }
        }

        while(true) {
            if(count == maxNumber)break;
            System.out.print("Enter number between 0 and 100 - score " + (count + 1) + ": ");
            input = sc.nextLine();
            isValid = validateInput(input);

            if(isValid) {
                int number = Integer.parseInt(input);
                if(number > -1 && number < 101) {
                    scoreCount += number;
                    count++;
                } else {
                    System.out.println("Number must be between 0 and 100. Try again");
                }
            }
        }
        double averageScore = (double) scoreCount / count;
        String formattedScore = String.format("%.2f", averageScore);
        String message = "\n"
                + "TEST SCORE RESULTS\n"
                + "======================\n"
                + "Score count:     " + count + "\n"
                + "Score total:     " + scoreCount + "\n"
                + "Average score:   " + formattedScore + "\n";
        System.out.println(message);

        sc.close();

    }

    private static boolean validateInput(String input) {

        try{
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
