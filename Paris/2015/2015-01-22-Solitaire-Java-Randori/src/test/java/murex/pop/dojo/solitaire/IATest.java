package murex.pop.dojo.solitaire;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class IATest {

/*   @Test
   public void acceptance_test() {
      Assertions.assertThat(IA.resolve(
        new boolean[] { true, true, true, true, true},
        new boolean[] { true, true, true, true, true},
        new boolean[] { true, true, false, true, true},
        new boolean[] { true, true, true, true, true},
        new boolean[] { true, true, true, true, true})).isTrue();
   }
   */

   @Test
   public void
   it_returns_true_if_grid_is_solved() {
      final Boolean[] line = { false, false, true };
      Assertions.assertThat(IA.hasSolution(line)).isTrue();
   }

   @Test
   public void
   it_should_jump_over_a_ball_on_the_right() {
      final Boolean[] line = { true, true, false };
      Assertions.assertThat(IA.hasSolution(line)).isTrue();
   }

   @Test
   public void
   it_should_jump_over_a_ball_on_the_left() {
      final Boolean[] line = { false, true, true };
      Assertions.assertThat(IA.hasSolution(line)).isTrue();
   }

   @Test
   public void
   return_false_if_there_is_no_hole() {
      final Boolean[] line = { true, true, true };
      Assertions.assertThat(IA.hasSolution(line)).isFalse();
   }

   @Test
   public void
   return_false_if_there_is_no_possible_moves() {
      final Boolean[] line = { true, false, true };
      Assertions.assertThat(IA.hasSolution(line)).isFalse();
   }

   @Test
   public void
   it_solves_in_many_turns() {
      final Boolean[] line = { true, true, false, true, false };
      Assertions.assertThat(IA.hasSolution(line)).isTrue();
   }

   @Test
   public void
   it_has_no_solution_after_a_round() {
      final Boolean[] line = { true, true, false, false, true };
      Assertions.assertThat(IA.hasSolution(line)).isFalse();
   }

   @Test
   public void
   first_solution_is_not_correct_with_sevral_moves() {
      final Boolean[] line = { false, true, false, true, false, true, true, false };
      Assertions.assertThat(IA.hasSolution(line)).isTrue();
   }

   @Test
   public void
   it_should_handle_vertical_move() {
      final Boolean[][] board = { { true }, { true }, { false } };
      Assertions.assertThat(IA.hasSolution(board)).isTrue();
   }
}
