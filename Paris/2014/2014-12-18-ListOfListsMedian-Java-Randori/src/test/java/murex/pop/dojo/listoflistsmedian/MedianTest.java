package murex.pop.dojo.listoflistsmedian;

import java.util.List;

import org.fest.assertions.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class MedianTest {

      @Test
      public void
      acceptance_test() {
         Assertions.assertThat(Median.of(Lists.<List<Integer>>newArrayList(
           Lists.newArrayList(4, 3, 1, 2),
           Lists.newArrayList(3, 4),
           Lists.newArrayList(7000000)))).isEqualTo(3);
      }


   /*
      parcourir toutes les listes, et retourner les éléments les max et les mins

      recherche la valeur x tq nombre de valeurs < x = nombre de valeurs > x

      commencer par une recherche lineaire, apres peut-etre dichotomie

    */

   @Test
   public void
   max_of_a_list() {
      Assert.assertEquals(3, Median.max(Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(0, 3, 2))));
   }

   @Test
   public void
   max_of_a_list2() {
      Assert.assertEquals(4, Median.max(Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(0, 3, 2, 4))));
   }

   @Test
   public void
   max_of_a_list3() {
      Assert.assertEquals(7000000, Median.max(Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(0, 3, 2, 4),
        Lists.newArrayList(7000000))));
   }

   @Test
   public void
   min_of_a_list() {
      Assert.assertEquals(1, Median.min(Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(1, 3, 2))));
   }

   @Test
   public void
   ordinality_of_one_list() {
      Assert.assertEquals(new Ordinality(1, 1, 1), Median.ordinality(2, Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(1, 3, 2))));
   }

   @Test
   public void
   ordinality_of_another_list() {
      Assert.assertEquals(new Ordinality(2, 0, 1), Median.ordinality(3, Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(1, 3, 2))));
   }

   @Test
   public void
   ordinality_of_2_lists() {
      Assert.assertEquals(new Ordinality(5, 1, 0), Median.ordinality(5, Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(1, 3, 2),
        Lists.newArrayList(2, 4, 7))));
   }

   @Test
   public void
   median_of_a_list() {
      Assert.assertEquals(2, Median.of(Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(1, 3, 2))));
   }

   @Test
   public void
   median_of_2_list() {
      Assert.assertEquals(3, Median.of(Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(1, 3, 2, 5), Lists.newArrayList(2, 4, 7))));
   }

   @Test
   public void
   median_of_2_list_unbalanced() {
      Assert.assertEquals(2, Median.of(Lists.<List<Integer>>newArrayList(
        Lists.newArrayList(1, 3, 2, 2, 2, 2, 2, 2, 5, 4))));
   }

}
