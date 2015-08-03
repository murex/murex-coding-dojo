import org.fest.assertions.api.StringAssert;
import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Coding Dojo Session
 * Given a positive integer number (eg 42) determine its Roman numeral representation as a String (eg "XLII").
 * http://cyber-dojo.org/setup/show/
 * Date: 22/07/2015
 **/
public class RomanNumeralTest {

   @Test
   public void
   it_converts_a_1_into_I() {
      assertRomanConversion(1).isEqualTo("I");
   }

   @Test
   public void
   it_converts_a_5_to_V() {
      assertRomanConversion(5).isEqualTo("V");
   }

   @Test
   public void
   it_converts_a_10_to_X() {
      assertRomanConversion(10).isEqualTo("X");
   }

   @Test
   public void
   it_converts_a_2_to_II() {
      assertRomanConversion(2).isEqualTo("II");
   }


   @Test
   public void
   it_converts_a_4_to_IV() {
      assertRomanConversion(4).isEqualTo("IV");
   }

   @Test
   public void
   it_converts_a_6_to_VI() {
      assertRomanConversion(6).isEqualTo("VI");
   }

   @Test
   public void
   it_converts_a_9_to_IX() {
      assertRomanConversion(9).isEqualTo("IX");
   }

   @Test
   public void
   it_converts_a_11_to_XI() {
      assertRomanConversion(11).isEqualTo("XI");
   }

   @Test
   public void
   it_converts_a_12_to_XII() {
      assertRomanConversion(12).isEqualTo("XII");
   }

   @Test
   public void
   it_converts_a_14_to_XIV() {
      assertRomanConversion(14).isEqualTo("XIV");
   }

   @Test
   public void
   it_converts_a_20_to_XX() {
      assertRomanConversion(20).isEqualTo("XX");
   }

   @Test
   public void
   it_converts_a_25_to_XXV() {
      assertRomanConversion(25).isEqualTo("XXV");
   }

   @Test
   public void
   it_converts_a_30_to_XXX() {
      assertRomanConversion(30).isEqualTo("XXX");
   }

   @Test
   public void
   it_converts_a_50_to_L() {
      assertRomanConversion(50).isEqualTo("L");
   }

   @Test
   public void
   it_converts_a_40_to_XL() {
      assertRomanConversion(40).isEqualTo("XL");
   }

   @Test
   public void
   it_converts_a_500_to_D() {
      assertRomanConversion(500).isEqualTo("D");
   }

   @Ignore
   @Test
   public void
   it_converts_a_400_to_CD() {
      assertRomanConversion(400).isEqualTo("CD");
   }

   @Ignore
   @Test
   public void
   acceptance_test() {
      assertRomanConversion(1990).isEqualTo("MCMXC");
      assertRomanConversion(2008).isEqualTo("MMVIII");
      assertRomanConversion(99).isEqualTo("XCIX");
      assertRomanConversion(47).isEqualTo("XLVII");
   }

   private StringAssert assertRomanConversion(int arabic) {
      return assertThat(RomanNumeral.convertNumber(arabic));
   }
}
