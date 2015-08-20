package bank.ocr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class BankOCR {
   private final static Map<List<String>, Integer> dictionary = new HashMap<List<String>, Integer>(10){{
      put(digit(
        "   ",
        "  |",
        "  |",
        "   "), 1);
      put(digit(
        " _ ",
        " _|",
        "|_ ",
        "   "), 2);
      put(digit(
        " _ ",
        " _|",
        " _|",
        "   "), 3);
      put(digit(
        "   ",
        "|_|",
        "  |",
        "   "), 4);
      put(digit(
        " _ ",
        "|_ ",
        " _|",
        "   "), 5);
      put(digit(
        " _ ",
        "|_ ",
        "|_|",
        "   "), 6);
      put(digit(
        " _ ",
        "  |",
        "  |",
        "   "), 7);
      put(digit(
        " _ ",
        "|_|",
        "|_|",
        "   "), 8);
      put(digit(
        " _ ",
        "|_|",
        " _|",
        "   "), 9);
   }} ;

   public static final int DIGIT_WIDTH = 3;

   private static List<String> digit(String... digitLines) {
      return Lists.newArrayList(digitLines);
   }

   public static int parse(String lcdText) {
      return parseDigits(split(lcdText));
   }

   private static Integer parseDigits(List<List<String>> lcdText) {
      int res = 0;
      for (List<String> strings : lcdText) {
         res = res * 10 + parseDigit(strings);
      }
      return res;
   }

   private static Integer parseDigit(List<String> lcdText) {
      return dictionary.get(lcdText);
   }

   private static List<List<String>> split(String lcdText) {
      List<List<String>> res = new ArrayList<>();

      final String[] lines = lcdText.split("\n");
      final FluentIterable<String> block = FluentIterable.from(Lists.newArrayList(lines));
      final String aLine = block.first().get();

      final int digitCount = aLine.length() / DIGIT_WIDTH;
      for (int j = 0; j < digitCount; j++) {
         res.add(extractDigit(j, block));
      }
      return res;
   }

   private static ImmutableList<String> extractDigit(int digitIndex, FluentIterable<String> lines) {
      final int digitPos = digitIndex * DIGIT_WIDTH;
      return lines.transform(new Function<String, String>() {
           @Override
           public String apply(String line) {
              return line.substring(digitPos, digitPos + DIGIT_WIDTH);
           }
        }).toList();
   }
}
