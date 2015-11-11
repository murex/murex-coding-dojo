import com.google.common.collect.Lists;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;


public class DFSTreeTest {

   @Test
   public void
   a_node_with_one_child_generates_one_plan(){
      DFSTree tree = DFSTreeBuilder.aTreeBuilder().withLabel(0).withChild(DFSTreeBuilder.aTreeBuilder().withLabel(1)).build();

      assertThat(tree.generateCombinations()).isEqualTo(Lists.newArrayList("0,1")) ;
   }

   @Test
   public void
   a_node_with_two_children_generates_two_plans(){
      DFSTree tree = DFSTreeBuilder.aTreeBuilder().withLabel(0).withChild(DFSTreeBuilder.aTreeBuilder().withLabel(1)).
                                                               withChild(DFSTreeBuilder.aTreeBuilder().withLabel(2)).build();
      assertThat(tree.generateCombinations()).isEqualTo(Lists.newArrayList("0,1,2","0,2,1"));
   }

   @Test
   public void
   a_node_with_two_levels_generates_two_plans(){
      DFSTree tree = DFSTreeBuilder.aTreeBuilder().withLabel(0)
        .withChild(DFSTreeBuilder.aTreeBuilder().withLabel(1)
          .withChild(DFSTreeBuilder.aTreeBuilder().withLabel(2))
          .withChild(DFSTreeBuilder.aTreeBuilder().withLabel(3))).build();
      assertThat(tree.generateCombinations()).isEqualTo(Lists.newArrayList("0,1,2,3","0,1,3,2"));
   }

/*   @Test
   public void
   three_nodes_should_return_two_trees_with_three_nodes(){
      DFSTree dfsTree = new DFSTree(3);
      dfsTree.edge(1,2);
      dfsTree.edge(1,3);
      assertThat(dfsTree.generateTree()).isEqualTo(new DFSNode(1));
   }

   @Ignore
   @Test
   public void
   acceptance_test() {
      DFSTree dfsTree = new DFSTree(5);
      dfsTree.edge(1, 3);
   }*/
}
