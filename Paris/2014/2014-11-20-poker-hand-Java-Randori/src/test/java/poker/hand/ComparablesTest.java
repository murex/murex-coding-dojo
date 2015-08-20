package poker.hand;

import static org.junit.Assert.assertEquals;
import static poker.hand.Comparables.compareLists;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class ComparablesTest {

   @Test
   public void
   an_empty_list_is_smaller_than_others() {
      final int lefty = compareLists(Arrays.<Integer>asList(1), Collections.<Integer>emptyList());
      assertEquals(OutCome.LEFT, OutCome.from(lefty));

      final int righty = compareLists(Collections.<Integer>emptyList(), Arrays.<Integer>asList(1));
      assertEquals(OutCome.RIGHT, OutCome.from(righty));
   }
}
