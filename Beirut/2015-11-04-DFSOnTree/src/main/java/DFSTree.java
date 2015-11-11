import com.google.common.base.Joiner;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DFSTree {

   private List<DFSTree> nodes= Lists.newArrayList();
   private int label;

   public DFSTree(int label) {
      this.label = label;
   }

   public void edge(DFSTree child) {
      nodes.add(child);
   }

   public List<String> generateCombinations() {
      ArrayList<String> results = Lists.newArrayList();

      Collection<List<DFSTree>> permutations = Collections2.permutations(nodes);

      for (List<DFSTree> permutation : permutations) {
         results.add(label + "," + Joiner.on(',').join(permutation));
      }

      List<String> childrenLabels = Lists.newArrayList();
      for (DFSTree node : nodes) {
         if(!node.nodes.isEmpty()) {
            Collection<List<DFSTree>> childrenPermutation = Collections2.permutations(node.nodes);
            for (List<DFSTree> child : childrenPermutation) {
               childrenLabels.add(Joiner.on(',').join(child));
            }
         }
      }

      if(childrenLabels.isEmpty()) {
         return results;
      }
      List<String> listOfString = Lists.newArrayList();

      List<List<String>> lists = Lists.cartesianProduct(results, childrenLabels);

      Joiner j  =Joiner.on(",");
      for (List<String> list : lists) {
         listOfString.add(j.join(list));
      }

      return listOfString;
}

   @Override
   public String toString() {
      return String.valueOf(label);
   }
}
