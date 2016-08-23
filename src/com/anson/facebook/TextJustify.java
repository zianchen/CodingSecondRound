package com.anson.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenzian on 8/21/16.
 */
public class TextJustify {
    public static void main(String[] args) {

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || maxWidth <= 0) {
            return res;
        }
        int index = 0;
        while (index < words.length) {
            int curLen = 0;
            int i = 0;
            for (i = index; i < words.length; i++) {
                if (curLen + 1 + words[i].length() > maxWidth) {
                    // only one word in this line
                    if (i == index) {
                        res.add(words[i]);
                    } else {
                        int split = (maxWidth - curLen);
                    }
                }
            }
            index = i;
        }
        // change last line
        return res;
    }
}
