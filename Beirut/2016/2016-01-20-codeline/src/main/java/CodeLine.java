import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class CodeLine {

   public static long lineCount(List<String> lines) throws IOException {
      List<String> strings = linesWithoutBackslashStarComment(lines);
      return  listWithoutDoubleSlashComments(strings).count();
   }

   private static Stream<String> listWithoutDoubleSlashComments(List<String> lines) {
      return lines.stream().filter((l) -> {
         String trimmedLine = l.trim();
         return !(trimmedLine.startsWith("//") || trimmedLine.isEmpty());
      });
   }

   private static List<String> linesWithoutBackslashStarComment(List<String> lines) throws IOException {
      List<String> linesWithoutBackslashStar = Lists.newArrayList();
      boolean findmatch = false;
      for(String line : lines){
         if(line.contains("/*")&& !findmatch){
            findmatch= true;
            if(!line.startsWith("/*")){
               linesWithoutBackslashStar.add(line);
            }
         }
         if(line.contains("*/")){
            int lastIndexOfCommentBlockEnding = line.lastIndexOf("*/");
            String codeLineTail = line.substring(lastIndexOfCommentBlockEnding + 2);
            if(listWithoutDoubleSlashComments(ImmutableList.of(codeLineTail)).count()==0)
            {
               findmatch  = false;
               continue;
            }
         }
         if(!findmatch){
            linesWithoutBackslashStar.add(line);
         }
     }
      return linesWithoutBackslashStar;
   }


}
