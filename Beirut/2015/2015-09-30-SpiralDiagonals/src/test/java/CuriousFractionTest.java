import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class CuriousFractionTest {


   @Test
   public void test_46_over_32_is_not_a_curious_fraction() {
      assertCuriousFraction(46, 32, false);
   }

   @Test
   public void test_49_over_98_is_a_curious_fraction() {
      assertCuriousFraction(49, 98, true);
   }

   @Test
   public void it_returns_false_when_numerator_greater_than_denominator() {
      assertCuriousFraction(90, 30, false);
   }

   private void assertCuriousFraction(int num, int denom, boolean expected) {
      Assertions.assertThat(CuriousFraction.check(num, denom)).isEqualTo(expected);
   }
}
