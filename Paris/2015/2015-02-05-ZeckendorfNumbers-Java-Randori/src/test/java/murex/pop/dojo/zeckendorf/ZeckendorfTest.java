package murex.pop.dojo.zeckendorf;

import static murex.pop.dojo.zeckendorf.Zeckendorf.translate;
import static org.fest.assertions.api.Assertions.assertThat;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class ZeckendorfTest {

   @Test
   public void
   it_prints_numbers_up_to_20() {
      Assertions.assertThat(Zeckendorf.translate(20)).isEqualTo("101010");
   }

   @Test
   public void
   it_translates_1() {
      assertThat(translate(1)).isEqualTo("1");
   }

   @Test
   public void
   it_translates_2() {
      assertThat(translate(2)).isEqualTo("10");
   }

   @Test
   public void
   it_translates_3() {
      assertThat(translate(3)).isEqualTo("100");
   }

   @Test
   public void
   it_translated_4(){
      assertThat(translate(4)).isEqualTo("101");
   }
   @Test
   public void
   it_translated_5(){
      assertThat(translate(5)).isEqualTo("1000");
   }

   @Test
   public void
   it_translated_6(){
      assertThat(translate(6)).isEqualTo("1001");
   }
}
