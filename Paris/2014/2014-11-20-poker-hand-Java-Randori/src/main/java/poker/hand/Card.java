package poker.hand;

public final class Card implements Comparable<Card> {
   public static final int A = 14;
   public static final int K = 13;
   public static final int Q = 12;
   public static final int J = 11;

   private final int rank;
   private final Suit suit;

   private Card(int rank, Suit suit) {
      this.rank = rank;
      this.suit = suit;
   }

   public static Card h(int face) {
      return new Card(face, Suit.HEARTS);
   }

   public static Card s(int face) {
      return new Card(face, Suit.SPADES);
   }

   public static Card c(int face) {
      return new Card(face, Suit.CLUBS);
   }

   public static Card d(int face) {
      return new Card(face, Suit.DIAMONDS);
   }

   public int compareTo(Card card2) {
      return Integer.compare(rank(), card2.rank());
   }

   public int rank() {
      return rank;
   }
}
