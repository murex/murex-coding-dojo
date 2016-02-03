import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class FlowerCostTest {

   @Test
   public void acceptance_test(){
      final FlowersCost flowersCost = new FlowersCostBuilder().people(3).flowers(4).cost(2, 1, 5, 3).build();
      Assertions.assertThat(flowersCost.calculateMinCost()).isEqualTo(12);
   }

   @Test
   public void equal_number_of_flowers_and_people(){
      final FlowersCost flowersCost = new FlowersCostBuilder().people(4).flowers(4).cost(2, 3, 3, 5).build();
      Assertions.assertThat(flowersCost.calculateMinCost()).isEqualTo(13);
   }

   @Test
      public void number_flowers_less_than_number_of_people(){
      final FlowersCost flowersCost = new FlowersCostBuilder().people(4).flowers(3).cost(2, 3, 3).build();
      Assertions.assertThat(flowersCost.calculateMinCost()).isEqualTo(8);
   }
   @Test
   public void no_flower(){
      final FlowersCost flowersCost = new FlowersCostBuilder().people(4).flowers(0).build();
      Assertions.assertThat(flowersCost.calculateMinCost()).isEqualTo(0);
   }

   @Test
   public void number_flowers_greater_than_number_of_people(){
      final FlowersCost flowersCost = new FlowersCostBuilder().people(4).flowers(5).cost(5, 4, 3, 2, 1).build();
      Assertions.assertThat(flowersCost.calculateMinCost()).isEqualTo(16);
   }

   @Test
   public void number_flowers_which_are_picked_in_any_order_greater_than_number_of_people(){
      final FlowersCost flowersCost = new FlowersCostBuilder().people(4).flowers(5).cost(3,1,5,2,4).build();
      Assertions.assertThat(flowersCost.calculateMinCost()).isEqualTo(16);
   }
}
