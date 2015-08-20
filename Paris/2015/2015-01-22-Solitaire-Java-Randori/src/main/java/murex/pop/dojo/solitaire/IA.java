package murex.pop.dojo.solitaire;

import static com.google.common.collect.FluentIterable.from;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

public class IA {

   public static boolean hasSolution(final Boolean[] line) {
      return hasSolution(new Boolean[][] { line });
   }

   public static boolean hasSolution(final Boolean[][] lines) {

      if (isSolved(lines)) {
         return true;
      }

      FluentIterable<Move> moves = getMoves(lines);
      if (moves.isEmpty()) {
         return false;
      }

      return moves.anyMatch(new Predicate<Move>() {

         @Override
         public boolean apply(Move move) {
            return hasSolution(move.applyTo(lines));
         }
      });
   }

   private static FluentIterable<Move> getMoves(Boolean[] line) {
      List<Move> moves = new ArrayList<Move>();

      for (int i = 0; i < line.length - 2; i++) {
         if (canMoveRight(line, i)) {
            moves.add(new Move(i, i + 2));
         }
      }

      for (int i = 2; i < line.length; i++) {
         if (canMoveLeft(line, i)) {
            moves.add(new Move(i, i - 2));
         }
      }
      return from(moves);
   }

   private static boolean canMoveLeft(Boolean[] line, int i) {
      return line[i] && line[i - 1] && !line[i - 2];
   }

   private static boolean canMoveRight(Boolean[] line, int i) {
      return line[i] && line[i + 1] && !line[i + 2];
   }

   private static boolean isSolved(Boolean[][] lines) {
      int nbOfMarbles = 0;
      for (int i = 0; i < lines.length; i++) {
         for (int j = 0; j < lines[i].length; j++) {
            if(lines[i][j]) {
               nbOfMarbles++;
            }
         }
      }
      return nbOfMarbles <= 1;
   }

   private static class Move {
      final int startIndex;
      final int endIndex;

      public Move(int startIndex, int endIndex) {
         this.startIndex = startIndex;
         this.endIndex = endIndex;
      }

      private Boolean[] applyTo(Boolean[][] lines) {
         final Boolean[][] result = lines.clone();

         final int jumpedIndex = (startIndex + endIndex) / 2;

         result[startIndex] = false;
         result[jumpedIndex] = false;
         result[endIndex] = true;

         return result;
      }
   }
}
