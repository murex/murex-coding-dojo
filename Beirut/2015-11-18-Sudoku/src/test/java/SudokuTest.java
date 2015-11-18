import org.fest.assertions.api.Assertions;
import org.fest.assertions.api.ObjectArrayAssert;
import org.junit.Test;

public class SudokuTest {
   @Test
    public void
    it_fills_the_missing_number_in_a_3X3_grid() {
      assertSmallGrid(Sudoku.sudoku(new int[][]{
        {1, 2, 3},
        {4, 0, 6},
        {7, 8, 9}
      }).solveSmallSquare());
   }

   @Test
   public void
   it_fills_two_missing_numbers_in_a_3X3_grid() {
      assertSmallGrid(Sudoku.sudoku(new int[][]{
        {1, 2, 3},
        {4, 0, 6},
        {7, 8, 0}
      }).solveSmallSquare());
   }

   @Test
   public void
   it_fills_Multiple_missing_numbers_in_a_3X3_empty_grid() {
      assertSmallGrid(Sudoku.sudoku(new int[][]{
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
      }).solveSmallSquare());
   }

   @Test
   public void
   it_fills_zero_missing_numbers_in_a_3X3_grid() {
      assertSmallGrid(Sudoku.sudoku(new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
      }).solveSmallSquare());
   }

   private ObjectArrayAssert<int[]> assertSmallGrid(int[][] input) {
      return Assertions.assertThat(input).isEqualTo(new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
      });
   }
}
