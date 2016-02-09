import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class SpiralDiagonalTest {

   @Test
   public void sum_of_edges_of_one_sized_array_should_be_1() {
      assertSumOfEdges(1, 1);
   }

   @Test
   public void sum_of_edges_of_three_sized_array_should_be_24() {
      assertSumOfEdges(3, 24);
   }

   @Test
   public void sum_of_edges_of_five_sized_array_should_be_76() {
      assertSumOfEdges(5, 76);
   }

   @Test
   public void sum_of_edges_of_one_sized_state_should_be_1() {
      assertSpiralSum(1, 1);
   }

   @Test
   public void sum_of_edges_of_three_sized_state_should_be_25() {
      assertSpiralSum(3, 25);
   }

   @Test
   public void sum_of_edges_of_5_sized_state_should_be_101() {
      assertSpiralSum(5, 101);
   }

   @Test
   public void acceptance_test() {
      assertSpiralSum(1001, 669171001);
   }

   private void assertSpiralSum(int size, int expected) {
      Assertions.assertThat(SpiralDiagonal.spiralSum(size)).isEqualTo(expected);
   }

   private void assertSumOfEdges(int size, int expected) {
      Assertions.assertThat(SpiralDiagonal.sumOfEdge(size)).isEqualTo(expected);
   }
}
