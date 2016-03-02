import java.io.*;
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
            int[][] results = processImage(matchEntity);
            memory.upgrade(results, matchEntity.getValue());
        }
    }

    private int[][] processImage(MatchEntity matchEntity) {
        return new ImageProcessor().process(matchEntity.getImage());
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


    public ArrayList<Integer> recognize(File image, File label) {
        ArrayList<MatchEntity> matchEntities = Parser.getMatchingEntities(image, label);
        ArrayList<Integer> predictions = new ArrayList();
        for (MatchEntity matchEntity : matchEntities) {
            double[] probabilities= getProbabilities(matchEntity);
            predictions.add(getIndexOfHighestProbability(probabilities));
        }
        return predictions;
    }

    private int getIndexOfHighestProbability(double[] probabilities) {
        double max=1;
        int index=-1;
        for(int i=0;i<10;i++)
        {
            if(probabilities[i]>max)
            {
                max=probabilities[i];
                index=i;
            }
        }
        return index;
    }

    private double[] getProbabilities(MatchEntity matchEntity) {
        double[] probability = new double[10];
        int[][] results = processImage(matchEntity);

        for(int i =0; i< 10; i++) {
            probability[i] = bayes(results,i);
        }
        return probability;
    }

    private double bayes(int[][] results, int i) {
        double probability=1;
        for (int x = 0; x < results.length; x++) {
            for (int y = 0; y < results[x].length; y++) {
                if(results[y][x]==Parameters.BLACK)
                {
                    probability*=memory.getData(i)[y][x].getRatio()/memory.getCommonData()[y][x].getRatio();
                }
                else{
                    probability*=memory.getData(i)[y][x].getOppositeRatio()/memory.getCommonData()[y][x].getOppositeRatio();
                }

            }
        }
        return probability;
    }
}
