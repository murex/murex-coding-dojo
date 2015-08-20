package poker.hand;

import static poker.hand.Card.A;
import static poker.hand.Card.K;
import static poker.hand.Card.c;
import static poker.hand.Card.d;
import static poker.hand.Card.h;
import static poker.hand.Card.s;
import static poker.hand.Hand.hand;
import static poker.hand.OutCome.assertRightWins;

import org.junit.Test;

public class PokerHandTest {

/*
   @Test
   public void
   acceptance_test() {
      assertEquals(LEFT, winner(new Hand(h(2), s(4), c(4), d(2), h(4)), new Hand(s(2), s(8), s(A), s(Q), s(3))));
   }
*/

   @Test
   public void
   one_card_higher_card() {
      assertRightWins(hand(h(10)), hand(s(A)));
   }

   @Test
   public void
   two_cards_of_same_value_but_different_colors_are_equal() {
      OutCome.assertTie(hand(s(10)), hand(h(10)));
   }

   @Test
   public void
   two_hands_of_two_card_without_combination() {
      assertRightWins(hand(s(10), h(8)), hand(c(2), d(A)));
   }

   @Test
   public void
   kickers_are_checked_when_higher_cards_are_equal() {
      assertRightWins(hand(s(10), h(8)), hand(c(9), d(10)));
   }

   @Test
   public void
   a_pair_of_twos_beats_an_ace() {
      assertRightWins(hand(s(A), h(8)), hand(c(2), d(2)));
   }

   @Test
   public void
   a_pair_of_kings_beats_a_pair_of_8() {
      assertRightWins(hand(s(8), h(8)), hand(c(K), d(K)));
   }

   @Test
   public void
   two_pairs_of_ten_and_eight_beat_two_pairs_of_ten_and_seven(){
      assertRightWins(hand(s(10), h(10), c(7), h(7)), hand(c(10), d(10), c(8), h(8)));
   }

   @Test
   public void
   a_pair_of_ten_and_a_four_beats_a_pair_of_ten_and_a_two(){
      assertRightWins(hand(s(10), h(10), c(2)), hand(c(10), d(10), c(4)));
   }

   @Test
   public void
   a_pair_of_four_and_a_8_beats_a_pair_of_four_and_a_2(){
      assertRightWins(hand(s(4), h(4), c(2)), hand(c(4), d(4), c(8)));
   }

   @Test
   public void
   a_triple_beat_two_pairs() {
      assertRightWins(hand(s(6),c(6),c(7),s(7)), hand(c(4),d(4),s(4),c(3)));
   }


}
