package murex.pop.dojo.reversi;

import static murex.pop.dojo.reversi.Position.position;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

public class Board {

   public static final char _ = '.';
   public static final char B = 'B';
   public static final char W = 'W';

   private final char[][] cells;

   public Board(char[]... cells) {
      this.cells = cells;
   }

   public List<Position> legalMovesFor(char color) {
      final ImmutableList.Builder<Position> result = ImmutableList.builder();

      for (int iLine = 0; iLine < cells.length; ++iLine) {
         for (int iColumn = 0; iColumn < cells[iLine].length; ++iColumn) {
            final Position currentPosition = position(iLine, iColumn);

            if (isValidPosition(color, currentPosition)) {

               result.add(currentPosition);
            }
         }
      }

      return result.build();
   }

   private boolean isValidPosition(char color, Position position) {
      return colorAt(position) == _ && isNotSurroundByItsOwnColor(color, position);
   }

   private char colorAt(Position position) {
      return cells[position.line()][position.column()];
   }

   private boolean isNotSurroundByItsOwnColor(char color, Position position) {
      return neighboursOf(position).transform(toColor()).contains(other(color));
   }

   private FluentIterable<Position> neighboursOf(Position position) {
      int iLine = position.line();
      int iColumn = position.column();

      final ImmutableList.Builder<Position> builder = ImmutableList.builder();
      for (int i = Math.max(iLine - 1, 0); i <= Math.min(iLine + 1, cells.length - 1); i++) {
         for (int j = Math.max(iColumn - 1, 0); j <= Math.min(iColumn + 1, cells[i].length - 1); j++) {

            builder.add(position(i, j));
         }
      }
      return FluentIterable.from(builder.build());
   }

   private Function<? super Position, Character> toColor() {
      return new Function<Position, Character>() {
         @Override
         public Character apply(Position position) {
            return colorAt(position);
         }
      };
   }

   private static char other(char color) {
      switch (color) {
      case B:
         return W;
      case W:
         return B;
      default:
         throw new UnsupportedOperationException();
      }
   }
}
