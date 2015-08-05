import Yatzy.Roll;
import org.junit.Test;

import static Yatzy.Category.CHANCE;
import static Yatzy.Category.FOURS;
import static Yatzy.Category.THREES;
import static Yatzy.Category.YATZY;
import static org.fest.assertions.api.Assertions.assertThat;

public class YatzyTest {
   @Test
   public void
   the_score_should_be_when_all_dices_are_one() {
      final Roll roll = new Roll(CHANCE, 1, 1, 1, 1, 1);
      assertThat(roll.score()).isEqualTo(5);
   }

   @Test
   public void
   the_score_should_be_the_summation_of_5_inputs() {
      final Roll roll = new Roll(CHANCE, 1, 2, 6, 1, 1);
      assertThat(roll.score()).isEqualTo(11);
   }

   @Test
   public void
   the_score_should_be_the_summation_of_5_different_inputs() {
      final Roll roll = new Roll(CHANCE, 1, 2, 3, 4, 5);
      assertThat(roll.score()).isEqualTo(15);
   }

   @Test
   public void
   it_supports_the_chance_category_case1() {
      assertThat(new Roll(CHANCE, 1, 1, 3, 3, 6).score()).isEqualTo(14);
   }

   @Test
   public void
   it_supports_the_chance_category_case2() {
      assertThat(new Roll(CHANCE, 4, 5, 5, 6, 1).score()).isEqualTo(21);
   }

   @Test
   public void
   the_score_should_be_50_for_yatzy_category_for_matching_input() {
      assertThat(new Roll(YATZY, 1, 1, 1, 1, 1).score()).isEqualTo(50);
   }

   @Test
   public void
   the_score_should_be_0_for_yatzy_category_With_different_Input() {
      assertThat(new Roll(YATZY, 2, 1, 1, 1, 1).score()).isEqualTo(0);
   }

   @Test
   public void
   the_score_should_be_8_for_2_FOURS() {
      assertThat(new Roll(FOURS, 1, 1, 2, 4, 4).score()).isEqualTo(8);
   }

   @Test
   public void
   the_score_should_be_12_for_3_FOURS() {
      assertThat(new Roll(FOURS, 1, 1, 4, 4, 4).score()).isEqualTo(12);
   }

   @Test
   public void
   the_score_should_be_9_for_3_THREES() {
      assertThat(new Roll(THREES, 1, 1, 3, 3, 3).score()).isEqualTo(9);
   }
}
