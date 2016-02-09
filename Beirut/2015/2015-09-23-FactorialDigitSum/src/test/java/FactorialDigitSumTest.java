import org.junit.Test;

import java.math.BigInteger;

import static org.fest.assertions.api.Assertions.assertThat;

public class FactorialDigitSumTest {
   @Test
   public void
   factorial_of_zero_is_1() {
      factorialAssertion(0, FactorialDigitSum.bigInteger(1));
   }

   @Test
   public void
   factorial_of_1_is_1() {
      factorialAssertion(1, FactorialDigitSum.bigInteger(1));
   }

   @Test
   public void
   factorial_of_2_is_2() {
      factorialAssertion(2, FactorialDigitSum.bigInteger(2));
   }

   @Test
   public void
   factorial_of_10_is_3628800() {
      factorialAssertion(10, FactorialDigitSum.bigInteger(3628800));
   }

   @Test
   public void
   factorial_of_100_is_3628800() {
      factorialAssertion(100, FactorialDigitSum.bigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"));
   }

   @Test
   public void
   sum_of_single_digit_is_itself() {
      sumAssertion(1, 1);
   }

   @Test
   public void
   sum_of_digits_of_21_is_3() {
      sumAssertion(21, 3);
   }

   @Test
   public void
   sum_of_digits_of_28_is_10() {
      sumAssertion(28, 10);
   }

   @Test
   public void
   sum_of_digits_of_factorial_3_is_6() {
      sumOfFactorialAssertion(3, 6);
   }

   @Test
   public void
   sum_of_digits_of_factorial_10_is_27() {
      sumOfFactorialAssertion(10, 27);
   }

   @Test
   public void
   sum_of_digits_of_factorial_100_is_648() {
      sumOfFactorialAssertion(100, 648);
   }

   private BigInteger sumOfIntegerDigits(int i) {
      return FactorialDigitSum.sumOfDigits(FactorialDigitSum.bigInteger(i));
   }

   private void sumOfFactorialAssertion(int input, int expected) {
      assertThat((FactorialDigitSum.sumOfFactorialDigits(input))).isEqualTo(FactorialDigitSum.bigInteger(expected));
   }

   private void factorialAssertion(int input, BigInteger expected) {
      assertThat(FactorialDigitSum.factorialOf(input)).isEqualTo(expected);
   }

   private void sumAssertion(int input, int expected) {
      assertThat(sumOfIntegerDigits(input)).isEqualTo(FactorialDigitSum.bigInteger(expected));
   }
}
