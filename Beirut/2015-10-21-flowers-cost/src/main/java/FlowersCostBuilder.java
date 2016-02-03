public class FlowersCostBuilder {
   private int people;
   private int flowers;
   private int[] costs;

   public FlowersCostBuilder people(int nbOfPeople) {
      this.people = nbOfPeople;
      return this;
   }

   public FlowersCostBuilder flowers(int flowers) {
      this.flowers = flowers;
      return this;
   }

   public FlowersCostBuilder cost(int... costs) {
      this.costs = costs;
      return this;
   }

   public FlowersCost build() {
      return new FlowersCost(people, flowers, costs);
   }
}
