package gof;
public class GameOfLife {
   public static final boolean _ = false;
   public static boolean[][] blankWorld(int size) {
      return new boolean[size][size];
   }
   public static final boolean X = true;
   public static boolean[][] live(boolean[][] world) {
      final boolean[][] result = blankWorld(world.length);
      for (int i = 1; i < world.length - 1; i++) {
         for (int j = 1; j < world.length - 1; j++) {
            result[i][j] = cellState(world[i][j], numberOfNeighbours(world, i, j));
         }
      }
      return result;
   }
   private static boolean cellState(boolean previousState, int neighbours) {
      switch (neighbours) {
      case 3:
         return true;
      case 2:
         return previousState;
      default:
         return false;
      }
   }
   private static int numberOfNeighbours(boolean[][] world, int x, int y) {
      int neighbours = 0;
      for (int i = x - 1; i <= x + 1; i++) {
         for (int j = y - 1; j <= y + 1; j++) {
            neighbours += livingAt(world, i, j);
         }
      }
      return neighbours - livingAt(world, x, y);
   }
   private static int livingAt(boolean[][] world, int i, int j) {
      return world[i][j] ? 1 : 0;
   }
}