import com.google.common.collect.Lists;

import java.util.List;

public class Sudoku {
   final static List<Integer> digits = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
   final private int[][] grid;

   private Sudoku(int[][] grid) {
      this.grid = grid;
   }

   public static Sudoku sudoku(int[][] grid) {
      return new Sudoku(grid);
   }

   public int[][] solveSmallSquare() {
      List<Integer> missingDigits = findMissingDigits();

      fillMissingDigits(missingDigits);
      return grid;
   }

   private void fillMissingDigits(List<Integer> missingDigits) {
      int counter=0;
      int size = grid.length;
      for(int i=0;i< size;i++)
      {
         for(int j=0;j< size;j++){

            if(grid[i][j]==0) {
               grid[i][j] = missingDigits.get(counter++);
            }
         }
      }
   }

   private List<Integer> findMissingDigits() {
      List<Integer> missingDigits = Lists.newArrayList(digits);

      for(int i=0;i<grid.length;i++) {
         for(int j=0;j<grid.length;j++){
            if(grid[i][j] != 0) {
               int missingDigitIdx = missingDigits.indexOf(grid[i][j]);
               missingDigits.remove(missingDigitIdx);
            }
         }
      }
      return missingDigits;
   }
}
