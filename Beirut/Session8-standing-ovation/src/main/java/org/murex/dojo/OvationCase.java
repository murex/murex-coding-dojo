package org.murex.dojo;

import java.util.List;

/**
 * Created by mkobeissi on 02/09/2015.
 */
public class OvationCase {
   private List<Integer> members;
   private int sMax;

   public OvationCase(int sMax, List<Integer> members) {
      this.sMax = sMax;
      this.members = members;
   }

   public List<Integer> getMembers() {
      return members;
   }

   public int getSMax() {
      return sMax;
   }
}
