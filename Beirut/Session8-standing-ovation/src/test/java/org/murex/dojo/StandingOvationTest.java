package org.murex.dojo;

import static org.fest.assertions.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Unit and acceptance testing for the StandingOvation game
 * Created by mkobeissi on 02/09/2015.
 */
public class StandingOvationTest {

   @Test
   public void simple_test() throws IOException {
      List<OvationCase> ovationCases = new ArrayList<>();
      ovationCases.add(new OvationCase(0, Collections.singletonList(1)));
      ovationCases.add(new OvationCase(2, Arrays.asList(0, 0, 1)));
      Solutions solutions = getSolutions(ovationCases);

      String expected = Expected.getSimple();
      assertThat(solutions.format()).isEqualTo(expected);
   }

   @Test
   public void smal_acceptance_testl() throws IOException {
      List<OvationCase> ovationCases = getOvationCases("A-small-practice.in");
      Solutions solutions = getSolutions(ovationCases);

      String expected = Expected.getSmall();
      assertThat(solutions.format()).isEqualTo(expected);
   }

   @Test
   public void large_acceptance_test() throws IOException {
      List<OvationCase> ovationCases = getOvationCases("A-large-practice.in");
      Solutions solutions = getSolutions(ovationCases);

      String expected = Expected.getLarge();
      assertThat(solutions.format()).isEqualTo(expected);
   }

   private Solutions getSolutions(List<OvationCase> ovationCases) {
      Solutions solutions = new Solutions();
      for (OvationCase ovationCase : ovationCases) {
         int friends = new StandingOvation(ovationCase.getSMax(), ovationCase.getMembers()).friendsToInvite();
         solutions.add(friends);
      }
      return solutions;
   }

   private List<OvationCase> getOvationCases(String name) throws IOException {
      String filePath = getClass().getResource(name).getPath();
      StandingOvationParser parser = new StandingOvationParser();
      return parser.parse(filePath);
   }

   @Test
   public void parserTestOutputNotNull() throws IOException {
      List<OvationCase> ovationCases = getOvationCases("A-small-practice.in");
      assertThat(ovationCases).isNotNull();
   }
}
