package org.murex.dojo;

import java.util.function.Function;

/**
 * Created by mkobeissi on 09/09/2015.
 */
public class NamesScore {

   public  final int ASCII_OFFSET = 64;
   private final Function<String[],String []> sorter;

   private NamesScore(Function<String[], String[]> sorter) {
      this.sorter = sorter;
   }

   public static NamesScore namesScore() {
      return namesScore(Sorters.defaultSorter());
   }

   public static NamesScore namesScore(Function<String[],String []> sorter) {
      return new NamesScore(sorter);
   }

   public  int calculate(String[] names) {
      int result = 0;
      for (int i = 0; i < names.length; ++i) {
         result += alphabetScore(names[i]) * positionAt(i);
      }
      return result;
   }

   public  String[] sort(String[] names) {
      return sorter.apply(names);
   }

   public  int alphabetScore(String name) {
      int score = 0;
      for(int i=0;i<name.length();i++){
         score+= name.charAt(i) - ASCII_OFFSET;
      }
      return score;
   }

   public  int positionAt(int index) {
      return index + 1;
   }
}
