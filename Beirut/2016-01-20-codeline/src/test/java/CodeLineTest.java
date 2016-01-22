import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

public class CodeLineTest {

   @Test
   public void it_should_have_correct_count_for_a_code_of_one_line() throws IOException {
      assertThat(CodeLine.lineCount("sample1.java")).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_count_for_a_code_of_one_line_with_one_double_slash_comment() throws IOException {
      assertThat(CodeLine.lineCount("sample2.java")).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_count_for_a_code_of_one_line_with_one_double_slash_after_whitespace_comment() throws IOException {
      assertThat(CodeLine.lineCount("sample3.java")).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_count_for_a_code_of_one_line_with_one_empty_line() throws IOException {
      assertThat(CodeLine.lineCount("sample4.java")).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_count_for_a_code_with_slashes_on_separate_line() throws IOException {
      assertThat(CodeLine.lineCount("sample5.java")).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_result_for_a_double_slash_inside_a_backslash_star() throws IOException {
      assertThat(CodeLine.lineCount("sample6.java")).isEqualTo(1);
   }

   @Test
   public void it_should_have_correct_result_for_a_pathological_comment_ending() throws IOException {
      assertThat(CodeLine.lineCount("sample7.java")).isEqualTo(1);
   }


   @Test
   public void acceptance_test() throws IOException {
      assertThat(CodeLine.lineCount("acceptance.java")).isEqualTo(5);
   }

}
