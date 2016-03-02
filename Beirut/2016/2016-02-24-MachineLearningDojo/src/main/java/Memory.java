import java.util.HashMap;

public class Memory {
    private HashMap<Integer, BlackProbability[][]> cache ;
    private BlackProbability[][] common ;

    public Memory()
    {
        common = initializeCommon();
        initializeCache() ;
    }

    public BlackProbability[][] getData(int i)
    {
        return  cache.get(i) ;
    }
    public BlackProbability[][] getCommonData( )
    {
        return  common;
    }

    private BlackProbability[][]  initializeCommon()
    {
        BlackProbability[][] blackProbabilities = new BlackProbability[Parameters.NUMBER_OF_ROWS][Parameters.NUMBER_OF_COLUMNS];
        for(int y = 0; y < Parameters.NUMBER_OF_ROWS; y++)
        {
            for(int x = 0; x < Parameters.NUMBER_OF_COLUMNS; x++)
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
