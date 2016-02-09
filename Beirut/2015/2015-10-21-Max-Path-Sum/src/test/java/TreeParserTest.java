import com.google.common.collect.Lists;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

import java.nio.file.Paths;


public class TreeParserTest {
   @Test
   public void
   it_builds_a_tree_from_a_file() throws Exception{
      Assertions.assertThat(
        Tree.Builder.aTreeBuilder()
          .withRow(Lists.newArrayList(3))
          .withRow(Lists.newArrayList(7, 4))
          .withRow(Lists.newArrayList(2, 4, 6))
          .withRow(Lists.newArrayList(8, 5, 9, 3)).build()).isEqualTo(
        TreeParser.parseTree(Paths.get(ClassLoader.getSystemResource("SmallTree.txt").toURI())));
   }

}
