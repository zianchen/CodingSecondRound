package com.anson.facebook;

import java.util.*;

/**
 * Created by chenzian on 8/22/16.
 */
public class WordLadderBFS {

    private Queue<String> toVisit = new LinkedList();

    public static void main(String[] args) {
        String[] input = {"hot", "dot", "dog", "lot", "log"};
        Set<String> wordList = new HashSet<>(Arrays.asList(input));
        WordLadderBFS wl = new WordLadderBFS();
        System.out.println(wl.ladderLength("hit", "cog", wordList));
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        int dist = 2;
        wordList.add(endWord);
        addNextWords(beginWord, wordList);
        while (!toVisit.isEmpty()) {
            int size = toVisit.size();
            for (int i = 0; i < size; i++) {
                String current = toVisit.poll();
                if (current.equals(endWord)) {
                    return dist;
                }
                wordList.remove(current);
                addNextWords(current, wordList);
            }
            dist++;
        }
        return 0;
    }

    private void addNextWords(String current, Set<String> wordList) {
        char[] str = current.toCharArray();
        for (int j = 0; j < str.length; j++) {
            char letter = str[j];
            for (int k = 0; k < 26; k++) {
                str[j] = (char) ('a' + k);
                String candidate = String.valueOf(str);
                if (wordList.contains(candidate)) {
                    toVisit.add(candidate);
                }
            }
            str[j] = letter;
        }
    }
}
