package murex.dojo.coffeemachine.requests;

import murex.dojo.coffeemachine.DrinkFactory;
import murex.dojo.coffeemachine.requests.IRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TeaRequestTest {

   @Test
   public void tea_without_sugar() {
      IRequest teaRequest = DrinkFactory.getInstance().newTeaRequestBuilder()
        .build();

      assertEquals(0, teaRequest.getSugarQuantity());
      assertEquals("Tea", teaRequest.getDrinkName());
   }

   @Test
   public void tea_with_sugar() {
      IRequest teaRequest = DrinkFactory.getInstance().newTeaRequestBuilder()
        .withSugar(2)
        .build();

      assertEquals(2, teaRequest.getSugarQuantity());
      assertEquals("Tea", teaRequest.getDrinkName());
   }
}
