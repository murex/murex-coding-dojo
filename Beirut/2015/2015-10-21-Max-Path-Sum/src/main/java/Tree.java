import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

public final class Tree {

   private final List<List<Integer>> rows;

   private Tree(Builder builder) {
      rows = builder.rows;
   }

   public int computeTopDownMaxSum() {
      if (rows.isEmpty()) {
         return 0;
      }
      return computeMaxSumIndexed(0, 0, 0);
   }

   public int computeBottomUpMaxSum() {
      if (rows.isEmpty()) {
         return 0;
      }
      return computeBottomUpMaxSum(rows.size() - 1);
   }

   private int computeBottomUpMaxSum(int rowIndex) {
      if (rowIndex == 0) {
         return rows.get(0).get(0);
      }

      for (int columnIndex = 0; columnIndex < rows.get(rowIndex).size() - 1; columnIndex++) {
         int first = rows.get(rowIndex).get(columnIndex);
         int second = rows.get(rowIndex).get(columnIndex + 1);
         int parentIndex = rowIndex - 1;
         int parentValue = rows.get(parentIndex).get(columnIndex) + Math.max(first, second);
         rows.get(parentIndex).set(columnIndex, parentValue);
      }
      return computeBottomUpMaxSum(rowIndex - 1);
   }

   private int computeMaxSumIndexed(int cumulativeSum, int row, int column) {
      int currentSum = cumulativeSum + rows.get(row).get(column);
      int nextRow = row + 1;

      if (nextRow == rows.size()) {
         return currentSum;
      }

      int leftSum = computeMaxSumIndexed(currentSum, nextRow, column);
      int rightSum = computeMaxSumIndexed(currentSum, nextRow, column + 1);

      return Math.max(leftSum, rightSum);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Tree tree = (Tree) o;
      return Objects.equals(rows, tree.rows);
   }

   @Override
   public int hashCode() {
      return Objects.hash(rows);
   }

   public static final class Builder {

      private final List<List<Integer>> rows;

      private Builder() {
         rows = Lists.newArrayList();
      }

      public static Builder aTreeBuilder() {
         return new Builder();
      }

      public Builder withRow(List<Integer> row) {
         Preconditions.checkArgument(row.size() == (rows.size() + 1));
         rows.add(row);
         return this;
      }

      public Tree build() {
         return new Tree(this);
      }
   }
}
