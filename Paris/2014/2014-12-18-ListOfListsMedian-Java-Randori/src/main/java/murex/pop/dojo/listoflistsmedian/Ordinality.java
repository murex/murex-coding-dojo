package murex.pop.dojo.listoflistsmedian;

import java.util.Objects;

public class Ordinality {
   public static final Ordinality EMPTY = new Ordinality(0, 0, 0);
   private final int above;
   private final int below;
   private int equal;

   public Ordinality(int below, int above, int equal) {
      this.above = above;
      this.below = below;
      this.equal = equal;
   }

   boolean isMedian() {
      return Math.abs(above - below) < equal;
   }

   Ordinality update(Ordinality ordinality) {
      return new Ordinality(below + ordinality.below, above + ordinality.above, equal + ordinality.equal);
   }

   @Override
   public int hashCode() {
      return Objects.hash(above, below);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
         return false;
      }
      final Ordinality other = (Ordinality) obj;
      return Objects.equals(this.above, other.above) && Objects.equals(this.below, other.below);
   }

}
