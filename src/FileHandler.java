import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileHandler {
    static int runningTotal = 9999999;
    static String highScore;

    public static void CreateFile() {
        try{
            File myFile = new File("src/highScores.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static String ReadFile() {
        try{
            File myFile = new File("src/highScores.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String line = myReader.nextLine();
                String[] lineArray = line.split(",");
                int score = Integer.parseInt(lineArray[0]);
                String username = lineArray[1];
                if (score < runningTotal){
                    runningTotal = score;
                    String leadingScore = String.format("%d, by %s", score, username);
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
    public static void WriteToFile(int score, String username) {
        try {
            FileWriter myWriter = new FileWriter("src/highScores.txt", true);
            String scoreLine = String.format("%d,%s\n", score, username);
            myWriter.write(scoreLine);
            System.out.println("Score saved!");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}