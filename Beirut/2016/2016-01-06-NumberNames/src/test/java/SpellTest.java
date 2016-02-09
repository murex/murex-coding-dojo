import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class SpellTest {

   @Test
   public void it_should_spell_correctly_numbers_less_than_20(){
      String[] answers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
        "sixteen", "seventeen", "eighteen", "nineteen"};

      for(int i = 0 ; i <= 19 ; i++) {
         assertThat(Speller.spell(i)).isEqualTo(answers[i]);
      }
   }

   @Test
   public void it_should_spell_tens(){
      String[] answers = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
      int[] input = {20,30,40,50,60,70,80,90};
      for(int i=0;i<input.length;i++){
         assertThat(Speller.spell(input[i])).isEqualTo(answers[i]);
      }
   }

   @Test
   public void it_should_spell_composite_numbers_correctly_less_than_100(){
      assertThat(Speller.spell(21)).isEqualTo("twenty one");
      assertThat(Speller.spell(34)).isEqualTo("thirty four");
      assertThat(Speller.spell(75)).isEqualTo("seventy five");
      assertThat(Speller.spell(99)).isEqualTo("ninety nine");
   }

   @Test
   public void it_should_spell_composite_numbers_correctly_less_than_1000(){
      assertThat(Speller.spell(100)).isEqualTo("one hundred");
      assertThat(Speller.spell(101)).isEqualTo("one hundred and one");
      assertThat(Speller.spell(555)).isEqualTo("five hundred and fifty five");
      assertThat(Speller.spell(999)).isEqualTo("nine hundred and ninety nine");
   }


   @Ignore
   @Test
   public void acceptance_test() {
      assertThat(Speller.spell(2523)).isEqualTo("two thousand five hundred twenty three");
   }
}
