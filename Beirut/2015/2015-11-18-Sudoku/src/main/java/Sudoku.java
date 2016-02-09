import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sudoku {
   final static List<Integer> digits = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
   final private int[][] grid;
   public HashMap<String, ArrayList<Integer>> possibilities;

   private Sudoku(int[][] grid) {
      this.grid = grid;
      possibilities = Maps.newHashMap();

      for (int row = 0; row < grid.length; row++) {
         for (int column = 0; column < grid[0].length; column++) {
            if (grid[row][column] == 0) {
               possibilities.put(row + "," + column, new ArrayList<Integer>(digits));
            }
         }
      }
   }

   public static Sudoku sudoku(int[][] grid) {
      return new Sudoku(grid);
   }

   public int[][] solve() {
      while (!solvedGrid()) {
         for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
               if (grid[row][column] == 0) {
                  computePossibilities(row, column);
               }
            }
         }
      }
      return grid;
   }

   private void computePossibilities(int row, int column) {
      Set<Integer> horizontalValues = horizontalPossibilities(row);
      updateGrid(row, column, horizontalValues);

      Set<Integer> verticalValues = verticalPossibilities(column);
      updateGrid(row, column, verticalValues);

      Set<Integer> squareValues = squarePossibilities(row, column);
      updateGrid(row, column, squareValues);
   }

   private void updateGrid(int row, int column, Set<Integer> horizontalValues) {
      possibilities.get(row + "," + column).removeAll(horizontalValues);
      if(possibilities.get(row + "," + column).size()==1){
         grid[row][column] = possibilities.get(row + "," + column).get(0);
      }
   }

   private Set<Integer> squarePossibilities(int row, int column) {
      Set<Integer> squarePossibilities = new HashSet<Integer>();
      int rowStartIndex = row - (row % 3);
      int columnStartIndex = column - (column % 3);
      for (int rowIndex = rowStartIndex; rowIndex <rowStartIndex+3 ; rowIndex++) {
         for (int columnIndex = columnStartIndex; columnIndex <columnStartIndex+3 ; columnIndex++) {
            squarePossibilities.add(grid[rowIndex][columnIndex]);
         }
      }
      return squarePossibilities;
   }

   private Set<Integer> horizontalPossibilities(int row) {
      Set<Integer> horizontalValues = new HashSet<Integer>();
      for (int i = 0; i < grid.length; i++) {
         horizontalValues.add(grid[row][i]);
      }
      return horizontalValues;
   }

   private Set<Integer> verticalPossibilities(int column) {
      Set<Integer> verticalValues = new HashSet<Integer>();

      for (int i = 0; i < grid.length; i++) {
         verticalValues.add(grid[i][column]);
      }
      return verticalValues;
   }

   private boolean solvedGrid() {
      for (int[] rows : grid) {
         for (int cell : rows) {
            if (cell == 0) {
               return false;
            }
         }
      }
      return true;
   }
}
