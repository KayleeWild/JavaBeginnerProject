import java.io.File;
import java.util.Scanner;

public class ReadFile {
    static int runningTotal = 9999;
    static String highScore;
    public static String main(String[] args) {
        try{
            File myFile = new File("./highScores.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] lineArray = line.split(",");
                int score = Integer.parseInt(lineArray[0]);
                String initials = lineArray[1];
                if (score < runningTotal){
                    runningTotal = score;
                    String leadingScore = String.format("%d, by %s", score, initials);
                    highScore = leadingScore;
                }
            }
            myReader.close();
            return highScore;
        } catch (Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
