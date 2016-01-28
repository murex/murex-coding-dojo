import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class CipherTest {

   @Test
   public void shift_one_character_by_3(){
      assertThat(CeasarCipher.compute("a", 3)).isEqualTo("d");
   }

   @Test
   public void shift_multiple_characters_by_3(){
      assertThat(CeasarCipher.compute("abc", 3)).isEqualTo("def");
   }

   @Test
   public void shift_edge_characters_by_3(){
      assertThat(CeasarCipher.compute("z", 3)).isEqualTo("c");
   }

   @Test
   public void it_should_skip_non_letters(){
      assertThat(CeasarCipher.compute("-", 3)).isEqualTo("-");
   }

   @Test
   public void capital_letters(){
      assertThat(CeasarCipher.compute("A", 3)).isEqualTo("D");
   }


      @Test
   public void acceptance_test(){
      assertThat(CeasarCipher.compute("azAZ-f", 3)).isEqualTo("dcDC-i");
   }

}
