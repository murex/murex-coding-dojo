import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TreeParser {

   private static List<Integer> parseLine(String line) {
      String[] tokens = line.trim().split(" ");

      return Lists.newArrayList(Iterables.transform(Lists.newArrayList(tokens), new Function<String, Integer>() {
           public Integer apply(String s) {
              return Integer.parseInt(s);
           }
        }
      ));

   }

   public static Tree parseTree(Path path) throws IOException {
      Tree.Builder builder = Tree.Builder.aTreeBuilder();

      Files.lines(path)
        .forEach(line -> builder.withRow(parseLine(line)));

      return builder.build();

   }

}
