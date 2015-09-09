package org.murex.dojo;

import static org.murex.dojo.NamesScore.namesScore;

import org.junit.Test;

/**
 * Simple Benchmarking of the default java sort and the naive bubble sort implementation
 * Created by mkobeissi on 09/09/15.
 */
public class PerformanceTest {

   @Test
   public void benchmarking_default_java_sort() {
      runBench(namesScore(), "DefaultSort");
   }

   @Test
   public void benchmarking_naive_bubble_sort() {
      runBench(namesScore(Sorters.bubbleSort()), "BubbleSort");
   }

   private void runBench(NamesScore namesScore, String sortName) {
      long startMillis = System.currentTimeMillis();
      String[] sortedNames = namesScore.sort(Names.NAMES);
      long endMillis = System.currentTimeMillis();
      long elapsedMillis = endMillis - startMillis;
      System.out.println(sortName + ": " + elapsedMillis + " ms.");
      namesScore.calculate(sortedNames);
   }
}
