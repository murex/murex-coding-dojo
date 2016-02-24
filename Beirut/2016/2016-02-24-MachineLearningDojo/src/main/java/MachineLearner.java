import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class MachineLearner {

    public Memory memory;

    public MachineLearner() {
        memory = new Memory();
    }

    public void learn(File imageFile, File labelFile) {

        ArrayList<MatchEntity> matchEntities = Parser.getMatchingEntities(imageFile, labelFile);

        //printMatchEntities(matchEntities);
        //save(matchEntities);

        for (MatchEntity matchEntity : matchEntities) {
            int[][] results = new ImageProcessor().process(matchEntity.getImage());
            memory.upgrade(results, matchEntity.getValue());
        }
    }

    private static void save(ArrayList<MatchEntity> matchEntities) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("toDelete.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < matchEntities.size(); i++) {
            writer.write(matchEntities.get(i).toString() + "\n");
        }
        writer.close();
    }

    private static void printMatchEntities(ArrayList<MatchEntity> matchEntities) {
        for (int i = 0; i < matchEntities.size(); i++) {
            matchEntities.get(i).print();
        }
    }


}
