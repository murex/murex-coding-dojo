package org.murex.dojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkobeissi on 02/09/2015.
 */
public class Solutions {
   List<Integer> solutions;

   public Solutions() {
      this.solutions = new ArrayList<>();
   }

   public void add(int friends) {
      solutions.add(friends);
   }

   public String format() {
      String result = "";
      for (int x = 0; x < solutions.size(); x++) {
         int position = x + 1;
         result += "Case #" +  position + ": " + solutions.get(x) + "\n";
      }
      return result;
   }
}
