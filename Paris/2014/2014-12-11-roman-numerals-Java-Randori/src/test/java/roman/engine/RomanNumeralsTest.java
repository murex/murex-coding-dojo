package roman.engine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static roman.engine.RomanNumerals.toRoman;

public class RomanNumeralsTest {

   @Test
   public void
   digit_1954_should_give_MCMLIV() {
      assertRomanConversion(1954, "MCMLIV");
   }

   @Test
   public void
   digit_1_should_convert_to_I() {
      assertRomanConversion(1, "I");
   }

   @Test
   public void
   digit_2_should_convert_to_II() {
      assertRomanConversion(2, "II");
   }

   @Test
   public void
   digit_5_should_convert_to_V() {
      assertRomanConversion(5, "V");
   }

   @Test
   public void
   digit_10_should_convert_to_X() {
      assertRomanConversion(10, "X");
   }

   @Test
   public void
   digit_6_should_convert_to_VI() {
      assertRomanConversion(6, "VI");
   }

   @Test
   public void
   digit_4_should_convert_to_IV() {
      assertRomanConversion(4, "IV");
   }

   @Test
   public void
   digit_9_should_convert_to_IX() {
      assertRomanConversion(9, "IX");
   }

   @Test
   public void
   digit_20_should_convert_to_XX() {
      assertRomanConversion(20, "XX");
   }

   @Test
   public void
   digit_50_should_convert_to_L() {
      assertRomanConversion(50, "L");
   }

   @Test
   public void
   digit_60_should_convert_to_LX() {
      assertRomanConversion(60, "LX");
   }
   @Test
   public void
   digit_13_should_convert_to_XIII() {
      assertRomanConversion(13, "XIII");
   }
   private void assertRomanConversion(int arabicNumber, String romanNumber) {
      assertEquals(romanNumber, toRoman(arabicNumber));
   }
}