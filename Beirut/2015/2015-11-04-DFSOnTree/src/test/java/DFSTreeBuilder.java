import com.google.common.collect.Lists;

import java.util.ArrayList;

public class DFSTreeBuilder {
   private int label;
   private ArrayList<DFSTree> children = Lists.newArrayList();

   public DFSTreeBuilder() {

   }


   public static DFSTreeBuilder aTreeBuilder() {
      return new DFSTreeBuilder();
   }

   public DFSTreeBuilder withChild(DFSTreeBuilder destination) {
      children.add(destination.build());
      return this;
   }

   public DFSTreeBuilder withLabel(int label) {
      this.label = label;
      return this;
   }

   public DFSTree build() {
      DFSTree dfsTree = new DFSTree(label);
      for (DFSTree child : children) {
         dfsTree.edge(child);
      }
      return dfsTree;
   }
}
