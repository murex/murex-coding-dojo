/**
 *  Copyright Murex S.A.S., 2003-2016. All Rights Reserved.
 * 
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.murex.codingdojo.textjustification;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class SolutionTest {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    @Test
    public void testFullJustify_withASingleWord() {
        Solution solution = new Solution();
        List<String> result = solution.fullJustify(new String[] { "justification." }, 16);
        assertEquals(Arrays.asList("justification.  "), result);
    }

    @Test
    public void testFullJustify_withAFullLineSingleWord() {
        Solution solution = new Solution();
        List<String> result = solution.fullJustify(new String[] { "0123456789ABCDE." }, 16);
        assertEquals(Arrays.asList("0123456789ABCDE."), result);
    }

    @Test
    public void testFullJustify_MoreWords() {
        Solution solution = new Solution();
        List<String> result = solution.fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16);
        assertEquals(Arrays.asList("This    is    an", "example  of text", "justification.  "), result);
    }

    @Test
    public void testFullJustify_SingleLetter() {
        Solution solution = new Solution();
        List<String> result = solution.fullJustify(new String[] { "a", "b", "c" }, 1);
        assertEquals(Arrays.asList("a", "b", "c"), result);
    }

    @Test
    public void testFullJustify_LastLineHaveMoreWords() {
        Solution solution = new Solution();
        List<String> result = solution.fullJustify(new String[] { "What", "must", "be", "shall", "be." }, 12);
        assertEquals(Arrays.asList("What must be", "shall be.   "), result);
    }

    @Test
    public void testFullJustify_WithEmptyWord() {
        Solution solution = new Solution();
        List<String> result = solution.fullJustify(new String[] { "" }, 2);
        assertEquals(Arrays.asList("  "), result);
    }

    @Test
    public void testFullJustify_WithMiddleLineContainingOnlyOneLetter() {
        Solution solution = new Solution();
        List<String> result = solution.fullJustify(new String[] { "hello", ",", "world" }, 5);
        assertEquals(Arrays.asList("hello", ",    ", "world"), result);
    }
}
