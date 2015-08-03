import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Coding Dojo Session
 * Write a program to score a game of Ten-Pin Bowling.
 * http://cyber-dojo.org/setup/show/
 * Date: 15/07/2015
 **/
public class BowlingTest {
   @Test
   public void
   a_looser_plays() {
      assertThat(Bowling.play("--|--|--|--|--|--|--|--|--|--||")).isEqualTo(0);
   }

   @Test
   public void
   a_semi_looser_plays() {
      assertThat(Bowling.play("3-|--|--|--|--|--|--|--|--|--||")).isEqualTo(3);
   }

   @Test
   public void
   a_semi_looser_2frames_plays() {
      assertThat(Bowling.play("3-|5-|--|--|--|--|--|--|--|--||")).isEqualTo(8);
   }

   @Test
   public void
   spare_test_plays() {
      assertThat(Bowling.play("3/|--|--|--|--|--|--|--|--|--||")).isEqualTo(10);
   }

   @Test
   public void
   strike_test_plays() {
      assertThat(Bowling.play("X|--|--|--|--|--|--|--|--|--||")).isEqualTo(10);
   }

   @Test
   public void
   spare_test_with_a_hit_after() {
      assertThat(Bowling.play("3/|2-|--|--|--|--|--|--|--|--||")).isEqualTo(14);
   }

   @Test
   public void
   spare_test_with_two_hits_after() {
      assertThat(Bowling.play("3/|25|--|--|--|--|--|--|--|--||")).isEqualTo(19);
   }

   @Test
   public void
   strike_test_with_a_hit_after() {
      assertThat(Bowling.play("X|2-|--|--|--|--|--|--|--|--||")).isEqualTo(14);
   }

   @Test
   public void
   strike_test_with_two_hits_after() {
      assertThat(Bowling.play("X|25|--|--|--|--|--|--|--|--||")).isEqualTo(24);
   }

   @Test
   public void
   strike_test_with_two_hits_and_hit_last_frame() {
      assertThat(Bowling.play("X|25|--|--|--|--|--|--|--|-1||")).isEqualTo(25);
   }

   @Test
   public void
   strike_test_with_spare_after() {
      assertThat(Bowling.play("X|3/|--|--|--|--|--|--|--|--||")).isEqualTo(30);
   }

   @Ignore
   @Test
   public void
   it_should_accept_double_strikes() {
      assertThat(Bowling.play("X|X|--|--|--|--|--|--|--|--||")).isEqualTo(30);
   }

   @Ignore
   @Test
   public void
   acceptance_test() {
      assertThat(Bowling.play("X|X|X|X|X|X|X|X|X|X||XX")).isEqualTo(300);
      assertThat(Bowling.play("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||")).isEqualTo(90);
      assertThat(Bowling.play("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5")).isEqualTo(150);
      assertThat(Bowling.play("X|7/|9-|X|-8|8/|-6|X|X|X||81")).isEqualTo(167);

   }
}