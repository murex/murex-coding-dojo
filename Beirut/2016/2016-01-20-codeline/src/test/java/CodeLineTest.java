import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class CodeLineTest {

   @Test
   public void it_should_have_correct_count_for_a_code_of_one_line() throws IOException {
      assertThat(CodeLine.lineCount(codeLines().add("public class Sample1 {}").build())).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_count_for_a_code_of_one_line_with_one_double_slash_comment() throws IOException {
      assertThat(CodeLine.lineCount(codeLines().add("//comment")
                                               .add("public class Sample2 {}").build())).isEqualTo(1);


   }

   @Test
   public void it_should_have_correct_count_for_a_code_of_one_line_with_one_double_slash_after_whitespace_comment() throws IOException {
      assertThat(CodeLine.lineCount(codeLines()
        .add("   //comment").add("public class Sample3 {}").build())).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_count_for_a_code_of_one_line_with_one_empty_line() throws IOException {
      assertThat(CodeLine.lineCount(codeLines().add("")
                                             .add("public class Sample4 {}")
       .build())).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_count_for_a_code_with_slashes_on_separate_line() throws IOException {
      assertThat(CodeLine.lineCount(codeLines().add("/*").add("   wissam").add(" */")
        .add("public class sample5() {}").build())).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_result_for_a_double_slash_inside_a_backslash_star() throws IOException {
      assertThat(CodeLine.lineCount(codeLines().add("/*").add("   wissam").add(" //*/").add("public class sample6() {}")
        .build())).isEqualTo(1);
   }


   @Test
   public void it_should_have_correct_result_for_a_pathological_comment_ending() throws IOException {
      assertThat(CodeLine.lineCount(codeLines().add("/*****")
        .add(" * This is a test program with 5 lines of code")
        .add(" *  \\/* no nesting allowed!")
        .add(" //*****//***///Slightly pathological comment ending...")
        .add("")
        .add("public static void main() {}")
        .build())).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_result_for_a_test_ending_with_comment() throws IOException {
      assertThat(CodeLine.lineCount(codeLines()
        .add("public static void main() {}/*")
        .add(" Comment")
        .add("*/")
        .build())).isEqualTo(1);
   }

   @Test
   public void acceptance_test() throws IOException {
      assertThat(CodeLine.lineCount(codeLines().add("/*****")
        .add(" * This is a test program with 5 lines of code")
        .add(" *  \\/* no nesting allowed!")
        .add(" //*****//***///Slightly pathological comment ending...")
        .add("")
        .add("class sample {")
        .add(" public static final void main(String [] args) { // gotta love Java")
        .add(" // Say hello")
        .add("System./*wait*/out./*for*/println/*it*/('Hello/*');")
        .build())).isEqualTo(3);





         }



   private ImmutableList.Builder<String> codeLines() {
      return ImmutableList.<String>builder();
   }

}
