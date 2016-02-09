package org.murex.dojo;

import static org.fest.assertions.Assertions.assertThat;
import static org.murex.dojo.Names.NAMES;
import static org.murex.dojo.NamesScore.namesScore;

import org.junit.Test;

/**
 * Unit test the NamesScore algorithm
 * Created by mkobeissi on 09/09/2015.
 */
public class NamesScoreTest {

   @Test
   public void summing_all_the_names_scores_should_give_me_871198282() {
      NamesScore namesScore = namesScore();
      String[] sortedNames = namesScore.sort(NAMES);
      assertThat(namesScore.calculate(sortedNames)).isEqualTo(871198282);
   }

   @Test
   public void summing_all_the_names_scores_with_bubble_sort_should_give_me_871198282() {
      NamesScore namesScore = namesScore(Sorters.bubbleSort());
      String[] sortedNames = namesScore.sort(NAMES);
      assertThat(namesScore.calculate(sortedNames)).isEqualTo(871198282);
   }

   @Test
   public void it_should_sort_an_array_of_names(){
      String [] two_names = {"COLIN", "ANTOINE"};
      String[]  sorted = namesScore().sort(two_names);
      assertThat(sorted[0].equals("ANTOINE"));
      assertThat(sorted[1].equals("COLIN"));
   }

   @Test
   public void the_score_of_name_colin_should_be_53(){
      assertThat(namesScore().alphabetScore("COLIN")).isEqualTo(53);
   }

   @Test
   public void position_at_index_one_should_be_two(){
      assertThat(namesScore().positionAt(1)).isEqualTo(2);
   }

   @Test
   public void array_with_only_colin_should_return_a_total_score_of_53() {
      assertThat(namesScore().calculate(new String[] {"COLIN"})).isEqualTo(53);
   }


   @Test
   public void the_colin_twins_should_return_a_total_score_of_161() {
      String [] name = {"COLIN", "COLINA"};
      assertThat(namesScore().calculate(name)).isEqualTo(161);
   }
}

