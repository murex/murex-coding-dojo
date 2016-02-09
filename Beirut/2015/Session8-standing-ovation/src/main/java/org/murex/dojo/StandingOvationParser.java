package org.murex.dojo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkobeissi on 02/09/2015.
 */
public class StandingOvationParser {

   public List<OvationCase> parse(String filePath) throws IOException {
      File file = new File(filePath);
      List<OvationCase> ovations = new ArrayList<>();

      Files.lines(file.toPath()).skip(1).forEach(line -> {
         String[] split = line.split(" ");
         int sMax = Integer.parseInt(split[0]);
         char[] charMembers = split[1].toCharArray();

         List<Integer> members = new ArrayList<>(sMax);
         for (char member : charMembers) {
            members.add(Integer.parseInt(member + ""));
         }

         ovations.add(new OvationCase(sMax, members));
      });

      return ovations;

   }

}
