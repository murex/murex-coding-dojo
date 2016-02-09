package GOL;

public class GameOfLife {
   public static final boolean DEAD = false;
   public static final boolean ALIVE = true;

   public static boolean[][] play(boolean[][] grid) {

      int n = grid.length;
      boolean[][] output = initializedGrid(n);

      for (int rowIndex = 0; rowIndex < n; rowIndex++) {
         for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            final int neighboursCount = liveNeighbours(grid, rowIndex, columnIndex);

            boolean currentState = grid[rowIndex][columnIndex];

            if(currentState == ALIVE){
               if (neighboursCount < 2 || neighboursCount>3) {
                  output[rowIndex][columnIndex] = DEAD;
               } else {
                  output[rowIndex][columnIndex] = ALIVE;
               }
            }

            if (currentState == DEAD) {
               if (neighboursCount == 3) {
                  output[rowIndex][columnIndex] = ALIVE;
               }
            }

         }
      }

      return output;
   }

   public static boolean[][] initializedGrid(int n) {
      return new boolean[n][n];
   }

   private static int liveNeighbours(boolean[][] grid, int rowIndex, int columnIndex) {
      int liveNeighbors = 0;
      int n = grid.length;

      for (int dx = -1; dx <= 1; dx++) {
         int xCell = columnIndex + dx;
         if (xCell < 0 || xCell == n) {
            continue;
         }
         for (int dy = -1; dy <= 1; dy++) {
            if (dx == 0 && dy == 0) {
               continue;
            }
            int yCell = rowIndex + dy;
            if (yCell < 0 || yCell == n) {
               continue;
            }
            if (grid[yCell][xCell]) {
               liveNeighbors++;
            }
         }
      }
      return liveNeighbors;
   }
}
