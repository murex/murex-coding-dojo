/**
 *  Copyright Murex S.A.S., 2003-2016. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package com.murex.codingdojo.textjustification;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> output = new ArrayList<>();
        int exclusiveStop = 0;
        int start = 0;
        while (exclusiveStop < words.length) {
            exclusiveStop = exclusiveStop(words, start, maxWidth);
            output.add(justifyLine(words, maxWidth, start, exclusiveStop));
            start = exclusiveStop;
        }
        return output;
    }

    private String justifyLine(String[] words, int maxWidth, int start, int exclusiveStop) {
        if (exclusiveStop == words.length) {
            return justifyLastLine(words, start, maxWidth);
        } else {
            return justifyNoneLastLine(words, start, exclusiveStop, maxWidth);
        }
    }

    private String justifyNoneLastLine(String[] words, int start, int exclusiveStop, int maxWidth) {
        StringBuilder sb = new StringBuilder(maxWidth);
        int interWordPaddingBlock = exclusiveStop - 1 - start;
        int lengthOfWords = wordsLength(words, start, exclusiveStop);
        int spacesToAdd = maxWidth - lengthOfWords;
        if (interWordPaddingBlock == 0) {
            sb.append(words[start]);
            sb.append(repeatSpaces(spacesToAdd));
            return sb.toString();
        }
        int spacePerBlock = spacesToAdd / interWordPaddingBlock;
        int remainingSpaces = spacesToAdd % interWordPaddingBlock;
        for (int i = start; i < (exclusiveStop - 1); ++i) {
            sb.append(words[i]);
            sb.append(repeatSpaces(spacePerBlock));
            if ((i - start) < remainingSpaces) {
                sb.append(" ");
            }
        }
        sb.append(words[exclusiveStop - 1]);
        return sb.toString();
    }

    private String justifyLastLine(String[] words, int start, int maxWidth) {
        StringBuilder sb = new StringBuilder(maxWidth);
        for (int i = start; i < (words.length - 1); ++i) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[words.length - 1]);
        sb.append(repeatSpaces(maxWidth - sb.length()));
        return sb.toString();
    }

    private String repeatSpaces(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private int wordsLength(String[] words, int start, int exclusiveStop) {
        int length = 0;
        for (int i = start; i < exclusiveStop; i++) {
            length += words[i].length();
        }
        return length;
    }

    private int exclusiveStop(String[] words, int start, int width) {
        int currentWidth = words[start].length();
        int stop = start + 1;
        while ((stop < words.length) && ((currentWidth + words[stop].length() + 1) <= width)) {
            currentWidth += words[stop].length() + 1;
            stop++;
        }
        return stop;
    }
}
