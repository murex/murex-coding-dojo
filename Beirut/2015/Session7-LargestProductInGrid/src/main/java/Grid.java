import java.util.ArrayList;
import java.util.List;

public class Grid {
   private static final int PRODUCT_LENGTH = 4;
   private final List<List<Integer>> rows;

   public Grid() {
      this.rows = new ArrayList<>();
   }

   public Grid add(List<Integer> row) {
      this.rows.add(row);
      return this;
   }

   public Integer calculate() {
      int max = 0;
      for (List<Integer> row : rows) {
         int product = getMaxProductOfRow(row);
         max = Math.max(max, product);
      }

      for (int j = 0; j < rows.size(); ++j) {
         for (int i = 0; i < rows.get(0).size(); i++) {
            max = Math.max(getMaxProductOfColumn(i, j), max);
         }
      }
      return max;
   }

   private int getMaxProductOfColumn(int x, int y) {
      List<Integer> column = new ArrayList<>();
         for (int i = y; i<PRODUCT_LENGTH+y && i < rows.size(); ++i) {
            column.add(rows.get(i).get(x));
         }
      return calculateProduct(column, 0);
   }

   private int getMaxProductOfRow(List<Integer> row) {
      int max = 0;
      for (int i = 0; i <= row.size() - PRODUCT_LENGTH; i++) {
         int product = calculateProduct(row, i);
         max = Math.max(max, product);
      }
      return max;
   }

   private int calculateProduct(List<Integer> row, int startIndex) {
      int product = 1;
      for (int j = startIndex; j < startIndex + PRODUCT_LENGTH && j < row.size(); j++) {
         product *= row.get(j);
      }
      return product;
   }
}
