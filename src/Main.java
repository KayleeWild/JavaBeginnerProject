import java.util.Scanner;

public class Main {
    static int UPPER = 20;
    static int LOWER = 1;
    static Scanner myObj = new Scanner(System.in);
    static FileHandler fh = new FileHandler();

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            int rando = LOWER + (int) (Math.random() * (UPPER - LOWER + 1));
            int guess = -1;
            int counter = 0;

            String instructions = String.format("Welcome to the number guesser!\nPlease enter a number between %d and %d", LOWER, UPPER);
            System.out.println(instructions);
            while (guess != rando) {
                guess = Integer.parseInt(myObj.nextLine());
                if (guess > UPPER || guess < 0) {
                    String tooSmall = String.format("Your number is too small. Please enter a number %d or higher.", LOWER);
                    String tooBig = String.format("Your number is too big. Please enter a number %d or less.", UPPER);
                    if (guess > UPPER) {
                        System.out.println(tooBig);
                    } else if (guess < LOWER) {
                        System.out.println(tooSmall);
                    }
                } else if (guess != rando) {
                    if (guess < rando) {
                        System.out.println("Too small. Guess something bigger.");
                    } else {
                        System.out.println("Too big. Guess something smaller.");
                    }
                }
                counter++;
            }
            System.out.println("Yay! You guessed the number " + guess + "!");
            String scoreMessage = String.format("Your score is %d! (You win if you get the lowest.)", counter);
            System.out.println(scoreMessage);
            fh.CreateFile();
            String highScoreLine = fh.ReadFile();
            String[] highScoreArray = highScoreLine.split(",");
            int highScore = Integer.parseInt(highScoreArray[0]);
            if (counter < highScore) {
                System.out.println("You have the new high score.");
            } else if (counter > highScore) {
                int difference = counter - highScore;
                String differenceMessage = String.format("The current high score is %s. That's %d less than you!", highScoreLine, difference);
                System.out.println(differenceMessage);
            }
            System.out.println("""
                                                    _ " _
                     _ " _                         (_\\|/_)
                    (_\\|/_)  _ " _         _ " _    (/|\\)
                     (/|\\)  (_\\|/_) " _   (_\\|/_)
                             (/|\\)_\\|/_)   (/|\\)
                                  (/|\\)
                    """);
            System.out.println("Would you like to save your score? (y/n) ");
            String answer = myObj.nextLine();
            if (answer.toLowerCase().equals("y")) {
                System.out.println("Please enter your user name: ");
                String userName = myObj.nextLine();
                fh.WriteToFile(counter, userName);
            }
            System.out.println("Would you like to play again? (y/n) ");
            String loopAnswer = myObj.nextLine();
            if (loopAnswer.toLowerCase().equals("n")) {
                quit = true;
            }
        }
    }
}