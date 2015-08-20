package murex.pop.dojo.listoflistsmedian;

import java.util.Collections;
import java.util.List;

public class Median {

   public static int of(List<List<Integer>> ints) {
      int min = min(ints);
      int max = max(ints);

      for (int i = min; i <= max; i++) {
         final Ordinality ordinality = ordinality(i, ints);
         if (ordinality.isMedian()) {
            return i;
         }
      }

      throw new UnsupportedOperationException("Not found");
   }

   public static int max(List<List<Integer>> lists) {
      int max = Integer.MIN_VALUE;

      for (List<Integer> integerList : lists) {
         max = Math.max(max, Collections.max(integerList));
      }
      return max;
   }

   public static int min(List<List<Integer>> lists) {
      int min = Integer.MAX_VALUE;

      for (List<Integer> integerList : lists) {
         min = Math.min(min, Collections.min(integerList));
      }
      return min;
   }

   public static Ordinality ordinality(int pivot, List<List<Integer>> lists) {
      Ordinality result = Ordinality.EMPTY;

      for (List<Integer> list : lists) {
         result = result.update(listOrdinality(pivot, list));
      }
      return result;
   }

   private static Ordinality listOrdinality(int pivot, Iterable<Integer> list) {
      int above = 0;
      int below = 0;
      int equal = 0;
      for (Integer integer : list) {
         if (integer > pivot) {
            above++;
         }
         else if (integer < pivot) {
            below++;
         }
         else {
            equal++;
         }
      }
      return new Ordinality(below, above,equal);
   }
}
