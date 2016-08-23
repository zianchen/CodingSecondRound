package com.anson.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenzian on 8/22/16.
 */
public class WordLadderTwoEndBFS {
    public static void main(String[] args) {
        String[] input = {"hot", "dog"};
        Set<String> wordList = new HashSet<>(Arrays.asList(input));
        WordLadderTwoEndBFS wl2 = new WordLadderTwoEndBFS();
        System.out.println(wl2.ladderLength("hot", "dog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int dist = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> nextStep = new HashSet();
            for (String str : beginSet) {
                char[] charStr = str.toCharArray();
                for (int i = 0; i < charStr.length; i++) {
                    char letter = charStr[i];
                    for (int j = 0; j < 26; j++) {
                        charStr[i] = (char) ('a' + j);
                        String nextStr = String.valueOf(charStr);
                        if (endSet.contains(nextStr)) {
                            return dist + 1;
                        }
                        if (wordList.contains(nextStr)) {
                            nextStep.add(nextStr);
                            wordList.remove(nextStr);
                        }
                    }
                    charStr[i] = letter;
                }
            }
            beginSet = nextStep;
            dist++;
        }
        return 0;
    }
}
