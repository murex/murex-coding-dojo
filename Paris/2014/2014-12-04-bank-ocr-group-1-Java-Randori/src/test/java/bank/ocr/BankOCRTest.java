package bank.ocr;

import static bank.ocr.BankOCR.parse;
import static org.fest.assertions.api.Assertions.assertThat;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class BankOCRTest {

   @Test
   public void
   acceptance_test() {
       Assertions.assertThat(BankOCR.parse(
             "    _  _     _  _  _  _  _ \n"
           + "  | _| _||_||_ |_   ||_||_|\n"
           + "  ||_  _|  | _||_|  ||_| _|\n"
           + "                           "))
         .isEqualTo(123456789);
   }

   @Test
   public void
   it_parses_1() {
      assertThat(parse(
            "   \n"
          + "  |\n"
          + "  |\n"
          + "   "))
        .isEqualTo(1);
   }

   @Test
   public void
   it_parses_2() {
      assertThat(parse(
            " _ \n"
          + " _|\n"
          + "|_ \n"
          + "   "))
        .isEqualTo(2);
   }

   @Test
   public void
   it_parses_3(){
      assertThat(parse(
            " _ \n"
          + " _|\n"
          + " _|\n"
          + "   "))
        .isEqualTo(3);
   }

   @Test
   public void
   it_parses_4(){
      assertThat(parse(
            "   \n"
          + "|_|\n"
          + "  |\n"
          + "   "))
        .isEqualTo(4);
   }

   @Test
   public void
   it_parses_42(){
      assertThat(parse(
            "    _ \n"
          + "|_| _|\n"
          + "  ||_ \n"
          + "      "))
        .isEqualTo(42);
   }
}
