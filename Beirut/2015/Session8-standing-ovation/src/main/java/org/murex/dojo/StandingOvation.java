package org.murex.dojo;

import java.util.List;

/**
 * Check the README.md for more information about the Google Code Jam Standing Ovation game
 * Created by mkobeissi on 02/09/2015.
 */
public class StandingOvation {
   private final List<Integer> members;


   public StandingOvation(int sMax, List<Integer> members) {
      this.members = members;
   }

   public int friendsToInvite() {
      int nbFriends = 0;
      int clapping = members.get(0);
      for (int i = 1; i < members.size(); i++) {
         if (clapping < i) {
            nbFriends++;
            clapping++;
         }
         clapping += members.get(i);
      }
      return nbFriends;
   }
}
