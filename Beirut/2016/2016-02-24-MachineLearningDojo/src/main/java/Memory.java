import java.util.HashMap;


public class Memory {
    private HashMap<Integer, BlackProbability[][]> cache ;
    private BlackProbability[][] common ;

    public Memory()
    {
        common = initializeCommon();
        initializeCache() ;
    }

    private BlackProbability[][]  initializeCommon()
    {
        BlackProbability[][] blackProbabilities = new BlackProbability[Parameters.Y_CHUNK_SIZE][Parameters.X_CHUNK_SIZE];
        for(int y = 0; y < Parameters.Y_CHUNK_SIZE; y++)
        {
            for(int x = 0; x < Parameters.X_CHUNK_SIZE; x++)
            {
                blackProbabilities[y][x] = new BlackProbability() ;
            }
        }
        return  blackProbabilities ;
    }

    private void initializeCache() {
        cache = new HashMap<>();
        for(int i = 0 ; i <= 9 ; i++)
        {
            cache.put(i, initializeCommon()) ;
        }
    }

    public void upgrade(int[][] results, int value) {
        BlackProbability[][] blackProbabilities = cache.get(value);
        increment(results, common);
        increment(results, blackProbabilities);
    }

    private void increment(int[][] results, BlackProbability[][] blackProbabilities) {
        for (int y = 0; y < results.length; y++) {
            for (int x = 0; x < results.length; x++) {
                blackProbabilities[y][x].incrementDenominator();
                if(results[y][x] == Parameters.BLACK) {
                    blackProbabilities[y][x].incrementNumerator();
                }
            }
        }
    }
}
