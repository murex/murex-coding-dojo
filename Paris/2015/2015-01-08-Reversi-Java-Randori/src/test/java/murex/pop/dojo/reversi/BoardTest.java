package murex.pop.dojo.reversi;

import static murex.pop.dojo.reversi.Board.B;
import static murex.pop.dojo.reversi.Board.W;
import static murex.pop.dojo.reversi.Board._;
import static murex.pop.dojo.reversi.Position.position;
import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class BoardTest {

   //   @Test
   //   public void
   //   acceptance_test() {
   //      Assertions.assertThat(LegalMoves.allForPlayer("B",
   //        "........\n"
   //          + "........\n"
   //          + "........\n"
   //          + "...BW...\n"
   //          + "...WB...\n"
   //          + "........\n"
   //          + "........\n"
   //          + "........"))
   //        .isEqualTo(
   //          "........\n"
   //            + "........\n"
   //            + "....0...\n"
   //            + "...BW0..\n"
   //            + "..0WB...\n"
   //            + "...0....\n"
   //            + "........\n"
   //            + "........");
   //   }

   @Test
   public void
   it_selects_the_only_free_position() {
      assertThat(new Board(
        l(B, W, W, B),
        l(W, B, W, W),
        l(W, W, B, W),
        l(_, W, W, B)).legalMovesFor(B))
        .containsExactly(position(3, 0));
   }

   @Test
   public void
   it_selects_a_different_only_free_position() {
      assertThat(new Board(
        l(B, W, W, B),
        l(W, B, W, W),
        l(_, W, B, W),
        l(W, W, W, B)).legalMovesFor(B))
        .containsExactly(position(2, 0));
   }

   @Test
   public void
   it_selects_two_different_positions() {
      assertThat(new Board(
        l(B, W, W, B),
        l(W, B, W, W),
        l(_, W, B, W),
        l(_, W, W, B)).legalMovesFor(B))
        .containsExactly(position(2, 0), position(3, 0));
   }

   @Test
   public void
   it_has_just_one_illegal_position() {
      assertThat(new Board(
        l(B, B, B, B),
        l(B, B, B, B),
        l(B, _, B, B),
        l(B, B, B, B)).legalMovesFor(B))
        .isEmpty();
   }

   @Test
   public void
   it_has_just_one_illegal_position_2() {
      assertThat(new Board(
        l(B, B, B, B),
        l(B, B, B, B),
        l(B, _, B, B),
        l(B, B, B, B)).legalMovesFor(W))
        .isEmpty();
   }

   public static char[] l(char... line) {
      return line;
   }

}
