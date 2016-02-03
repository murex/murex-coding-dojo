import java.util.Arrays;

public class FlowersCost {
   private int people;
   private int flowers;
   private int[] costs;

   public FlowersCost(int people, int flowers, int[] costs) {

      this.people = people;
      this.flowers = flowers;
      this.costs = flowers == 0 ? new int[0] : costs;
   }

   public int calculateMinCost() {
      int minCost = 0;
      int[] numberOfFlowers = new int[people];

      final int[] sortedReverse = sortInReverse();

      for (int i = 0; i < sortedReverse.length; i++) {
         int temp = i % people;
         minCost += (numberOfFlowers[temp] + 1) * sortedReverse[i];
         numberOfFlowers[temp]++;
      }

      return minCost;

   }

   private int[] sortInReverse() {
      return Arrays.stream(costs).
        boxed().
        sorted((a, b) -> b - a).
        mapToInt(i -> i).
        toArray();
   }
}
