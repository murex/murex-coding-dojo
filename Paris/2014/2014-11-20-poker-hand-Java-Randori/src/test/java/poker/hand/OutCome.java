package poker.hand;

import static org.junit.Assert.assertEquals;

public enum OutCome {
   RIGHT, TIE, LEFT;

   static OutCome from(int comparison) {
      if (comparison == 0) {
         return TIE;

      } else if (comparison > 0) {
         return LEFT;

      } else {
         return RIGHT;
      }
   }

   static <T extends Comparable<T>> void assertRightWins(T loser, T winner) {
      assertEquals(RIGHT, from(loser.compareTo(winner)));
      assertEquals(LEFT, from(winner.compareTo(loser)));
   }

   static <T extends Comparable<T>> void assertTie(T left, T right) {
      assertEquals(TIE, from(left.compareTo(right)));
      assertEquals(TIE, from(right.compareTo(left)));
   }
}
