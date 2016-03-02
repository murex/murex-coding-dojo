import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;

public class Launcher {


    @Test
    public void debug() {
        ClassLoader classLoader = getClass().getClassLoader();
        File debugImage = new File(classLoader.getResource("digitdata/debugimages").getFile());
        File debugLabel = new File(classLoader.getResource("digitdata/debuglabels").getFile());
        MachineLearner ml = new MachineLearner();
        ml.learn(debugImage, debugLabel);

        for (int index = 3; index <= 9; index++) {
            for (int y = 0; y < Parameters.NUMBER_OF_ROWS; y++) {
                for (int x = 0; x < Parameters.NUMBER_OF_COLUMNS; x++) {
                    assertThat(ml.memory.getData(index)[y][0].getRatio()).isEqualTo(-1);
                }
            }
        }
        assertThat(ml.memory.getData(0)[0][0].getRatio()).isEqualTo(1) ;
        assertThat(ml.memory.getData(0)[0][3].getRatio()).isEqualTo(0) ;
        assertThat(ml.memory.getData(1)[0][0].getRatio()).isEqualTo(0) ;


        assertThat(ml.memory.getCommonData()[0][0].getRatio()).isEqualTo(0.5) ;
        assertThat(ml.memory.getCommonData()[0][3].getRatio()).isEqualTo(0.5) ;
    }

    @Test
    public void it_learns_from_images()
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File trainingimage = new File(classLoader.getResource("digitdata/trainingimages").getFile());
        File traininglabel = new File(classLoader.getResource("digitdata/traininglabels").getFile());

        File validationImage = new File(classLoader.getResource("digitdata/validationimages").getFile());
        File validationLabel = new File(classLoader.getResource("digitdata/validationlabels").getFile());


        MachineLearner ml = new MachineLearner();
        ml.learn(trainingimage, traininglabel) ;
        ml.learn(validationImage,validationLabel);
    }

    @Test
    public void it_recognizes_an_input() {
        ClassLoader classLoader = getClass().getClassLoader();

        File trainingimage = new File(classLoader.getResource("digitdata/trainingimages").getFile());
        File traininglabel = new File(classLoader.getResource("digitdata/traininglabels").getFile());

        File validationImage = new File(classLoader.getResource("digitdata/validationimages").getFile());
        File validationLabel = new File(classLoader.getResource("digitdata/validationlabels").getFile());

        File testImage = new File(classLoader.getResource("digitdata/testimages").getFile());
        File testLabel = new File(classLoader.getResource("digitdata/testlabels").getFile());

        MachineLearner ml = new MachineLearner();
        ml.learn(trainingimage, traininglabel) ;
        ml.learn(validationImage,validationLabel);

        ArrayList<Integer> recognize = ml.recognize(testImage, testLabel);

        ArrayList<MatchEntity> matchEntities = Parser.getMatchingEntities(testImage, testLabel);
        int index = 0 ;
        int success=0, fail=0;

        for (MatchEntity matchEntity : matchEntities) {
            if(recognize.get(index)==matchEntity.getValue()) {
                success++;
            }
            else
            {
                fail++;
            }
            index++;

        }

        double probability = (success * 1.0 / (success + fail)) * 100;
        System.out.println(probability);
        assertThat(probability).isGreaterThan(75) ;
    }

}
