import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class ApplicationTest {

   @Test
   public void
   it_should_print_hello(){
      Assertions.assertThat(new Application().hello()).isEqualTo("hello");
      Agent.packagesClasses();
   }
}