package poker.hand;

import java.util.List;

public class Comparables {
   static <T extends Comparable<T>> int compareLists(List<T> lefts, List<T> rights) {
      if (lefts.size() != rights.size()) {
         return lefts.size() - rights.size();
      }
      for (int i = 0; i < lefts.size(); i++) {
         final int comparison = lefts.get(i).compareTo(rights.get(i));
         if (comparison != 0) {
            return comparison;
         }
      }
      return 0;
   }
}
