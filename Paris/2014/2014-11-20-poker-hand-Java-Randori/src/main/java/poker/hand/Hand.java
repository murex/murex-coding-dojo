package poker.hand;

import static poker.hand.Comparables.compareLists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class Hand implements Comparable<Hand> {
   private final List<Card> cards;

   public static Hand hand(Card... cards) {
      return new Hand(cards);
   }

   public Hand(Card[] cards) {
      final List<Card> list = Arrays.asList(cards);
      Collections.sort(list);
      Collections.reverse(list);
      this.cards = list;
   }

   @Override
   public int compareTo(Hand right) {
      int result = checkTriples(right);


      if (result != 0) {
         return result;
      }

      result = checkPairs(right);
      if (result != 0) {
         return result;
      }

      return compareLists(cards, right.cards);
   }

   private int checkPairs(Hand right) {
      final List<Integer> rightPair = right.pairs();
      final List<Integer> leftPair = pairs();

      return compareLists(leftPair, rightPair);
   }

   private int checkTriples(Hand right) {
      final List<Integer> rightTriples = right.triples();
      final List<Integer> leftTriples = triples();

      return compareLists(leftTriples, rightTriples);
   }

   private List<Integer> triples() {
      List<Integer> triples = Lists.newArrayList();
      for (int i = 2; i < cards.size(); i++) {
         if (cards.get(i - 2).compareTo(cards.get(i - 1)) == 0 && cards.get(i - 1).compareTo(cards.get(i)) == 0) {
            triples.add(cards.get(i).rank());
         }
      }
      return triples;
   }

   private List<Integer> pairs() {
      List<Integer> pairs = Lists.newArrayList();
      for (int i = 1; i < cards.size(); i++) {
         if (cards.get(i - 1).compareTo(cards.get(i)) == 0) {
            pairs.add(cards.get(i).rank());
         }
      }
      return pairs;
   }

}
