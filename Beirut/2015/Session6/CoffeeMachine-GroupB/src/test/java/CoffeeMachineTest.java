import coffee.machine.Chocolate;
import coffee.machine.Coffee;
import coffee.machine.DrinkOrder;
import coffee.machine.MachineMaker;
import coffee.machine.Tea;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class CoffeeMachineTest {

   @Test
   public void
   COFFEEMachineReturnCoffee(){
      DrinkOrder myOrder = new DrinkOrder(new Coffee(),0.6);
      Assertions.assertThat(MachineMaker.make(myOrder)).isEqualTo("Drink maker makes 1 coffee with no sugar and therefore no stick");
   }
   @Test
   public void
   COFFEEMachineReturnTea(){
      DrinkOrder myOrder = new DrinkOrder(new Tea());
      Assertions.assertThat(MachineMaker.make(myOrder)).isEqualTo("Drink maker makes 1 tea with no sugar and therefore no stick");
   }
   @Test
   public void
   COFFEEMachineReturnChocolate(){
      DrinkOrder myOrder = new DrinkOrder(new Chocolate());
      Assertions.assertThat(MachineMaker.make(myOrder)).isEqualTo("Drink maker makes 1 chocolate with no sugar and therefore no stick");
   }

   @Test
   public void
   COFFEEMachineReturnChocolateWithSugar(){
      DrinkOrder myOrder = new DrinkOrder(new Chocolate(),1);
      Assertions.assertThat(MachineMaker.make(myOrder)).isEqualTo("Drink maker makes 1 chocolate with 1 sugars with stick");
   }

   @Test
   public void
   COFFEEMachineReturnMessage(){
      String testString = "testing string";
      Assertions.assertThat(MachineMaker.printmsg(testString)).isEqualTo(testString);
   }
   @Test
   public void
   COFFEEMachineReturnCoffeeLessMoney(){
      DrinkOrder myOrder = new DrinkOrder(new Coffee(),0.4);
      Assertions.assertThat(MachineMaker.make(myOrder)).isEqualTo("Insufficient money - required = 0.19999999999999996");
   }
}
