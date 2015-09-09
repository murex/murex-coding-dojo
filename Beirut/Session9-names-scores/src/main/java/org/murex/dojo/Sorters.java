package org.murex.dojo;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Provider for various String Array sorters
 * Created by mkobeissi on 09/09/15.
 */
public class Sorters {

   static Function<String[], String[]> bubbleSort(){
      return names -> {
         int j;
         boolean flag = true;   // set flag to true to begin first pass
         String temp;   //holding variable

         while (flag) {
            flag = false;    //set flag to false awaiting a possible swap
            for (j = 0; j < names.length - 1; j++) {
               if (names[j].compareTo(names[j + 1])>0)   // change to > for ascending sort
               {
                  temp = names[j];                //swap elements
                  names[j] = names[j + 1];
                  names[j + 1] = temp;
                  flag = true;              //shows a swap occurred
               }
            }
         }
         return names;
      };
   }

   static Function<String[], String[]> defaultSorter() {
      return names -> {
         String [] copiedNames = Arrays.copyOf(names, names.length);
         Arrays.sort(copiedNames);
         return copiedNames;
      };
   }
}
