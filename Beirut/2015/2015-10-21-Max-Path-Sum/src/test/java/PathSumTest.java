import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class PathSumTest {

   @Test
   public void
   the_max_sum_of_tree_with_no_node_is_zero_top_down() {
      assertTreeTopDownComputation(0, Tree.Builder.aTreeBuilder());
   }

   @Test
   public void
   the_max_sum_of_tree_with_no_node_is_zero_bottom_up() {
      assertTreeBottomUpComputation(0, Tree.Builder.aTreeBuilder());
   }

   @Test
   public void
   the_max_sum_of_tree_with_one_node_is_the_node_value_top_down() {
      assertTreeTopDownComputation(7,
        Tree.Builder.aTreeBuilder().withRow(Lists.newArrayList(7)));
   }

   @Test
   public void
   the_max_sum_of_tree_with_one_node_is_the_node_value_bottom_up() {
        Tree.Builder.aTreeBuilder().withRow(Lists.newArrayList(7));
   }



   @Test(expected = IllegalArgumentException.class)
   public void
   building_a_tree_with_one_row_and_2_elements_should_throw_an_exception() {
      Tree.Builder.aTreeBuilder().withRow(Lists.newArrayList(2, 3));
   }

   @Test
   public void
   the_total_of_two_rows_should_be_the_correct_result_top_bottom() {
      assertTreeTopDownComputation(10,
        Tree.Builder.aTreeBuilder()
          .withRow(Lists.newArrayList(3))
          .withRow(Lists.newArrayList(7, 4)));

   }

   @Test
   public void
   the_total_of_two_rows_should_be_the_correct_result_bottom_up() {
      assertTreeBottomUpComputation(10,
        Tree.Builder.aTreeBuilder()
          .withRow(Lists.newArrayList(3))
          .withRow(Lists.newArrayList(7, 4)));

   }

   @Test
   public void
   big_tree_test() throws URISyntaxException, IOException {
      long startTime = System.nanoTime();
      assertEquals(1074,
        TreeParser.parseTree(Paths.get(ClassLoader.getSystemResource("BigTree.txt").toURI())).computeTopDownMaxSum());
      long midTime = System.nanoTime();
      assertEquals(1074,
        TreeParser.parseTree(Paths.get(ClassLoader.getSystemResource("BigTree.txt").toURI())).computeBottomUpMaxSum());
      long endTime = System.nanoTime();

      System.out.println("Top Down:" + (midTime-startTime));
      System.out.println("Bottom up:" + (endTime-midTime));
   }

   @Test
   public void
   acceptanceTestSmallData_Top_Down() {
      assertTreeTopDownComputation(23,
        Tree.Builder.aTreeBuilder()
          .withRow(Lists.newArrayList(3))
          .withRow(Lists.newArrayList(7, 4))
          .withRow(Lists.newArrayList(2, 4, 6))
          .withRow(Lists.newArrayList(8, 5, 9, 3)));

   }

   @Test
   public void
   acceptanceTestSmallData_Bottom_Up() {
      assertTreeBottomUpComputation(23,
        Tree.Builder.aTreeBuilder()
          .withRow(Lists.newArrayList(3))
          .withRow(Lists.newArrayList(7, 4))
          .withRow(Lists.newArrayList(2, 4, 6))
          .withRow(Lists.newArrayList(8, 5, 9, 3)));

   }

   @Test
   public void
   very_big_tree_test() throws URISyntaxException, IOException {
      long startTime = System.nanoTime();
      assertEquals(7273,
        TreeParser.parseTree(Paths.get(ClassLoader.getSystemResource("VeryBigTree.txt").toURI())).computeBottomUpMaxSum());
      System.out.println("Time: " + (System.nanoTime() - startTime));
   }

   private void assertTreeTopDownComputation(int expected, Tree.Builder builder) {
      assertEquals(expected, builder.build().computeTopDownMaxSum());
   }

   private void assertTreeBottomUpComputation(int expected, Tree.Builder builder) {
      assertEquals(expected, builder.build().computeBottomUpMaxSum());
   }
}
