import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class CodeLine {
   public static long lineCount(String fileName) throws IOException {
      Stream<String> lines = FileToStreamOfStrings(fileName);

      List<String> strings = linesWithoutBackslashStarComment(lines);

      return  listWithoutDoubleSlashComments(strings).count();
   }

   private static Stream<String> listWithoutDoubleSlashComments(List<String> lines) {
      return lines.stream().filter((l) -> {
         String trimmedLine = l.trim();
         return !(trimmedLine.startsWith("//") || trimmedLine.isEmpty());
      });
   }

   private static List<String> linesWithoutBackslashStarComment(Stream<String> lines) {
      List<String> linesList  = lines.collect(Collectors.toList()) ;
      List<String> linesWithoutBackslashStar = Lists.newArrayList();
      boolean findmatch = false;
      for(String line : linesList){
         if(line.startsWith("/*")){
            findmatch = true;
         }
         if(line.endsWith("*/")){
            findmatch  = false;
            continue;
         }
         if(!findmatch){
            linesWithoutBackslashStar.add(line);
         }
     }
      return linesWithoutBackslashStar;
   }

   private static Stream<String> FileToStreamOfStrings(String fileName) throws IOException {
      ClassLoader classLoader = CodeLine.class.getClassLoader();
      File file = new File(classLoader.getResource(fileName).getFile());
      return Files.lines(file.toPath());
   }
}
