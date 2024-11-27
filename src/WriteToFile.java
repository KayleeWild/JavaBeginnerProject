import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(int score, String initials) {
        try {
            FileWriter myWriter = new FileWriter("./highScores.txt");
            String scoreLine = String.format("%d,%s", score, initials);
            myWriter.write(scoreLine);
            System.out.println("Score written.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
