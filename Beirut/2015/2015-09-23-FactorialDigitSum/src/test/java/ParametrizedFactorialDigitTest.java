import org.fest.assertions.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametrizedFactorialDigitTest {

   @Parameterized.Parameters
   public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][]{
        {10, 27}, {100, 648}, {3, 6}, {1, 1}, {0, 1}
      });
   }
   @Parameterized.Parameter(value = 0)
   public int input;

   @Parameterized.Parameter(value = 1)
   public int expected;

   @Test
   public void computeSumOfFactorialDigits() {
      Assertions.assertThat(FactorialDigitSum.sumOfFactorialDigits(input)).isEqualTo(FactorialDigitSum.bigInteger(expected));
   }

}
