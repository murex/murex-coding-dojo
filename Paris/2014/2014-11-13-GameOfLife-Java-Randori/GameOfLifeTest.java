package gof;
import static gof.GameOfLife.X;
import static gof.GameOfLife._;
import static gof.GameOfLife.blankWorld;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
public class GameOfLifeTest {
   @Test
   public void
   it_blinks_the_blinker() {
      final boolean[][] state = {
        { _, _, _, _, _ },
        { _, _, X, _, _ },
        { _, _, X, _, _ },
        { _, _, X, _, _ },
        { _, _, _, _, _ }
      };
      assertArrayEquals(new boolean[][] {
        { _, _, _, _, _ },
        { _, _, _, _, _ },
        { _, X, X, X, _ },
        { _, _, _, _, _ },
        { _, _, _, _, _ }
      }, GameOfLife.live(state));
   }
 
   @Test
   public void
   a_dead_cell_remains_dead() {
      assertGameOfLife(blankWorld(3), blankWorld(3));
   }
   @Test
   public void
   a_cell_with_no_neighbours_dies() {
      final boolean[][] start = {
        { _, _, _ },
        { _, X, _ },
        { _, _, _ }
      };
      assertGameOfLife(blankWorld(3), start);
   }
   @Test
   public void
   a_cell_with_only_one_neighbour_dies() {
      final boolean[][] start = {
        { _, _, _ },
        { _, X, X },
        { _, _, _ }
      };
      assertGameOfLife(blankWorld(3), start);
   }
   // Any live cell with two or three live neighbours lives on to the next generation.
   @Test
   public void
   a_cell_with_two_neighbour_lives() {
      final boolean[][] start = {
        { _, _, _ },
        { X, X, X },
        { _, _, _ }
      };
      final boolean[][] end = {
        { _, _, _ },
        { _, X, _ },
        { _, _, _ }
      };
      assertGameOfLife(end, start);
   }
   @Test
   public void
   a_cell_with_three_neighbour_lives() {
      final boolean[][] start = {
        { _, _, _ },
        { X, X, X },
        { _, X, _ }
      };
      final boolean[][] end = {
        { _, _, _ },
        { _, X, _ },
        { _, _, _ }
      };
      assertGameOfLife(end, start);
   }
   // Any live cell with more than three live neighbours dies, as if by overcrowding.
   @Test
   public void
   a_cell_with_four_neighbours_dies() {
      final boolean[][] start = {
        { _, _, X },
        { X, X, X },
        { _, X, _ }
      };
      assertGameOfLife(blankWorld(3), start);
   }
   @Test
   public void
   a_dead_cell_with_two_neighbours_stay_dead() {
      final boolean[][] start = {
        { _, _, _ },
        { X, _, X },
        { _, _, _ }
      };
      assertGameOfLife(blankWorld(3), start);
   }
   //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction
   @Test
   public void
   a_dead_cell_with_three_neighbours_should_be_revived() {
      final boolean[][] start = {
        { _, _, _ },
        { X, _, X },
        { _, X, _ }
      };
      final boolean[][] end = {
        { _, _, _ },
        { _, X, _ },
        { _, _, _ }
      };
      assertGameOfLife(end, start);
   }
   @Test
   public void
   an_empty_4x4_world_should_stay_empty() {
      final boolean[][] start = blankWorld(4);
      final boolean[][] end = blankWorld(4);
      assertGameOfLife(end, start);
   }
       /*
   final boolean[][] start = {
     { _, _, _ , _ },
     { _, _, _ , _ },
     { _, _, _ , X } ,
     { _, _, X , X }
   };*/
   @Test
   public void
   a_4x4_world_should_evolve() {
      final boolean[][] start = {
        { _, _, _, _ },
        { _, _, _, _ },
        { _, _, _, X },
        { _, _, X, X }
      };
      final boolean[][] end = {
        { _, _, _, _ },
        { _, _, _, _ },
        { _, _, X, _ },
        { _, _, _, _ }
      };
      assertGameOfLife(end, start);
   }
   private void assertGameOfLife(boolean[][] expectedNextWorld, boolean[][] initialWorld) {
      assertArrayEquals(expectedNextWorld, GameOfLife.live(initialWorld));
   }
}