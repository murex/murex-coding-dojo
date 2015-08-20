package murex.pop.dojo.reversi;

public class Position {
   private final int line;
   private final int column;

   public Position(int line, int column) {
      this.line = line;
      this.column = column;
   }

   public static Position position(int line, int column) {
      return new Position(line,column);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }

      Position position = (Position) o;

      if (column != position.column) {
         return false;
      }
      if (line != position.line) {
         return false;
      }

      return true;
   }

   @Override
   public int hashCode() {
      int result = line;
      result = 31 * result + column;
      return result;
   }

   public int line() {
      return line;
   }

   public int column() {
      return column;
   }
}
