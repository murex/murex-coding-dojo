import GOL.GameOfLife;
import org.junit.Ignore;
import org.junit.Test;

import static GOL.GameOfLife.ALIVE;
import static GOL.GameOfLife.DEAD;
import static GOL.GameOfLife.initializedGrid;
import static GOL.GameOfLife.play;
import static org.fest.assertions.api.Assertions.assertThat;

public class GameOfLifeTest {

   @Test
   public void
   a_dead_grid_remains_dead() {
      final boolean[][] input = initializedGrid(3);
      assertGrid(input, input);
   }

   @Test
   public void
   a_live_cell_with_fewer_than_two_live_neighbours_dies() {
      assertGrid(
        new boolean[][]{
          {DEAD, DEAD, DEAD},
          {DEAD, ALIVE, DEAD},
          {DEAD, DEAD, DEAD}},

        initializedGrid((3)));
   }

   @Test
   public void
   a_live_cell_with_two_live_neighbors_lives() {
      assertGrid(
        new boolean[][]{
          {ALIVE, DEAD, DEAD},
          {DEAD, ALIVE, DEAD},
          {DEAD, DEAD, ALIVE}},

        new boolean[][]{
          {DEAD, DEAD, DEAD},
          {DEAD, ALIVE, DEAD},
          {DEAD, DEAD, DEAD}}
      );
   }

   @Test
   public void
   a_live_cell_with_three_live_neighbors_lives() {
      assertGrid(
        new boolean[][]{
          {ALIVE, ALIVE, DEAD, DEAD},
          {ALIVE, ALIVE, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD}},

        new boolean[][]{
          {ALIVE, ALIVE, DEAD, DEAD},
          {ALIVE, ALIVE, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD}}
      );
   }

   @Test
   public void
   a_live_cell_with_more_than_three_live_neighbors_dies() {
      assertGrid(
        new boolean[][]{
          {ALIVE, ALIVE, DEAD, DEAD},
          {ALIVE, ALIVE, DEAD, DEAD},
          {ALIVE, DEAD, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD}},

        new boolean[][]{
          {ALIVE, ALIVE, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD},
          {ALIVE, ALIVE, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD}}
      );
   }

   @Test
   public void
   a_dead_cell_with_three_live_neighbors_lives() {
      assertGrid(
        new boolean[][] {
          {DEAD, ALIVE, DEAD, DEAD},
          {ALIVE, ALIVE, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD}},
        new boolean[][]{
          {ALIVE, ALIVE, DEAD, DEAD},
          {ALIVE, ALIVE, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD},
          {DEAD, DEAD, DEAD, DEAD}}
      );
   }

   @Ignore
   @Test
   public void
   acceptance_test() {
      assertGrid(
        new boolean[][]{
          {DEAD, DEAD, DEAD, DEAD},
          {DEAD, ALIVE, DEAD, DEAD},
          {DEAD, ALIVE, ALIVE, DEAD},
          {DEAD, DEAD, ALIVE, DEAD}},

        new boolean[][]{
          {DEAD, DEAD, DEAD, DEAD},
          {DEAD, ALIVE, ALIVE, DEAD},
          {DEAD, ALIVE, ALIVE, ALIVE},
          {DEAD, ALIVE, ALIVE, DEAD}
        });
   }

   private void assertGrid(boolean[][] input, boolean[][] output) {
      assertThat(play(input)).isEqualTo(output);
   }
}
