import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Coding Dojo Session
 * https://code.google.com/p/marsrovertechchallenge/
 * Date: 29/07/2015
 **/
public class MarsRoverTest {

   @Test
   public void
   the_robot_should_not_move_when_instruction_is_empty() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 E", "")).isEqualTo("1 1 E");
   }

   @Test
   public void
   the_robot_should_move_one_cell_to_the_east() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 E", "M")).isEqualTo("2 1 E");
   }

   @Test
   public void
   the_robot_should_move_one_cell_to_the_west() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 W", "M")).isEqualTo("0 1 W");
   }

   @Test
   public void
   the_robot_should_move_one_cell_to_the_north() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 N", "M")).isEqualTo("1 2 N");
   }

   @Test
   public void
   the_robot_should_move_one_cell_to_the_south() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 S", "M")).isEqualTo("1 0 S");
   }

   @Test
   public void
   the_robot_will_rotate_from_the_north_to_east() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 N", "R")).isEqualTo("1 1 E");
   }

   @Test
   public void
   the_robot_will_rotate_from_the_east_to_south() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 E", "R")).isEqualTo("1 1 S");
   }

   @Test
   public void
   the_robot_will_rotate_from_the_south_to_west() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 S", "R")).isEqualTo("1 1 W");
   }

   @Test
   public void
   the_robot_will_rotate_from_the_north_to_west() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 N", "L")).isEqualTo("1 1 W");
   }

   @Test
   public void
   the_robot_will_rotate_from_the_west_to_south() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 W", "L")).isEqualTo("1 1 S");
   }

   @Test
   public void
   the_robot_will_rotate_from_the_south_to_east() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 S", "L")).isEqualTo("1 1 E");
   }

   @Test
   public void
   the_robot_will_rotate_from_the_east_to_north() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 E", "L")).isEqualTo("1 1 N");
   }

   @Test
   public void
   the_robot_will_rotate_from_the_west_to_north() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 W", "R")).isEqualTo("1 1 N");
   }

   @Test
   public void
   the_robot_will_rotate_north_then_move() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 W", "RM")).isEqualTo("1 2 N");
   }

   @Test
   public void
   the_robot_will_move_then_rotate_north() {
      assertThat(MarsRover.moveRobot(5, 5, "1 1 W", "MR")).isEqualTo("0 1 N");
   }

   @Test
   public void
   acceptance_test_case1() {
      assertThat(MarsRover.moveRobot(5, 5, "1 2 N", "LMLMLMLMM")).isEqualTo("1 3 N");
   }

   @Test
   public void
   acceptance_test_case2() {
      assertThat(MarsRover.moveRobot(5, 5, "3 3 E", "MMRMMRMRRM")).isEqualTo("5 1 E");
   }

}
