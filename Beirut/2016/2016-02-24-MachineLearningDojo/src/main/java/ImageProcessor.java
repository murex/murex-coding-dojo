import java.util.*;

public class ImageProcessor {

    private final Map<Coordinate, BlackProbability> coordinatesToProbability;

    public ImageProcessor() {
        this.coordinatesToProbability = new HashMap<>();
    }

    private void pushCoordinate(int x, int y, Character character, int size) {
        Coordinate coordinate = new Coordinate((int) Math.floor(x * Parameters.X_CHUNK_SIZE * 1.0/ size),
                (int) Math.floor(y * Parameters.Y_CHUNK_SIZE * 1.0/ size));
        coordinatesToProbability.putIfAbsent(coordinate, new BlackProbability());
        BlackProbability probability = coordinatesToProbability.get(coordinate);

        probability.incrementDenominator();
        if (character == ' ') {
            probability.incrementNumerator();
        }
    }

    public int[][] process(ArrayList<String> image) {
        int[][] results = new int[Parameters.Y_CHUNK_SIZE][Parameters.X_CHUNK_SIZE] ;

        for(int y = 0 ; y < image.size() ; y++)
        {
            for(int x = 0 ; x < image.get(y).length() ; x++)
            {
                pushCoordinate(x, y, image.get(y).charAt(x), image.get(y).length());
            }
        }
        // fill results /done

        for (Map.Entry<Coordinate, BlackProbability> coordinateBlackProbabilityEntry : coordinatesToProbability.entrySet()) {
            results[coordinateBlackProbabilityEntry.getKey().x][coordinateBlackProbabilityEntry.getKey().y] =
                    coordinateBlackProbabilityEntry.getValue().getRatio() < Parameters.THRESHOLD ?
                  Parameters.WHITE : Parameters.BLACK;
        }
        return results;
    }

    private static class Coordinate {
        private final int x;
        private final int y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
