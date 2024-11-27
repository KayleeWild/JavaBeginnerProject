import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileHandler {
    static int runningTotal = 9999999; //Placeholder
    static String highScore;

    public void CreateFile() {
        try{
            File myFile = new File("data/highScores.txt");
            if (!myFile.exists()) {
                myFile.getParentFile().mkdirs(); // Create directories if they don't exist
                myFile.createNewFile(); 
            }  
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public String ReadFile() {
        try{
            File myFile = new File("data/highScores.txt");
            Scanner myReader = new Scanner(myFile);
            if (!myReader.hasNextLine()){
                myReader.close();
                return "999999999,Default (no scores have been added yet)";
            }
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
    public void WriteToFile(int score, String username) {
        try {
            FileWriter myWriter = new FileWriter("data/highScores.txt", true);
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