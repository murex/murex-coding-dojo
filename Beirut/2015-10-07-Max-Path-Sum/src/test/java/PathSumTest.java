import com.google.common.collect.Lists;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class PathSumTest {

   @Test
   public void
   the_max_sum_of_tree_with_no_node_is_zero() {
      assertTreeComputation(0, Tree.Builder.aTreeBuilder());
   }

   @Test
   public void
   the_max_sum_of_tree_with_one_node_is_the_node_value() {
      assertTreeComputation(7,
        Tree.Builder.aTreeBuilder().withRow(Lists.newArrayList(7)));
   }

   @Test(expected = IllegalArgumentException.class)
   public void
   building_a_tree_with_one_row_and_2_elements_should_throw_an_exception() {
      Tree.Builder.aTreeBuilder().withRow(Lists.newArrayList(2, 3));
   }

   @Test
   public void
   the_total_of_two_rows_should_be_the_correct_result() {
      assertTreeComputation(10,
        Tree.Builder.aTreeBuilder()
          .withRow(Lists.newArrayList(3))
          .withRow(Lists.newArrayList(7, 4)));

   }

   @Test
   public void
   acceptanceTestSmallData() {
      assertTreeComputation(23,
        Tree.Builder.aTreeBuilder()
          .withRow(Lists.newArrayList(3))
          .withRow(Lists.newArrayList(7, 4))
          .withRow(Lists.newArrayList(2, 4, 6))
          .withRow(Lists.newArrayList(8, 5, 9, 3)));

   }

   @Test
   public void
   big_tree_test() throws URISyntaxException, IOException {
      assertEquals(1074,
        TreeParser.parseTree(Paths.get(ClassLoader.getSystemResource("BigTree.txt").toURI())).computeMaxSum());
   }

   @Ignore
   @Test
   public void
   very_big_tree_test() throws URISyntaxException, IOException {
      assertEquals(1074,
        TreeParser.parseTree(Paths.get(ClassLoader.getSystemResource("VeryBigTree.txt").toURI())).computeMaxSum());
   }

   private void assertTreeComputation(int expected, Tree.Builder builder) {
      assertEquals(expected, builder.build().computeMaxSum());
   }
}
