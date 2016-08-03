package com.anson.twosigma;

import java.util.Collections;

/**
 * Created by chenzian on 6/19/16.
 */
class TriNode {
    int val;
    TriNode[] next = new TriNode[26];
    public TriNode (int v) {
        this.val = v;
    }
}
public class StringChainTrie {

    private int globalMax = 0;
    public int stringChain (String[] dict){
        if (dict == null || dict.length == 0) {
            return 0;
        }
        TriNode head = new TriNode(0);
        for (String str : dict) {
            TriNode current = head;
            TriNode child = null;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (current.next[c-'a'] == null) {
                    child = new TriNode(0);
                    current.next[c-'a'] = child;
                } else {
                    child = current.next[c-'a'];
                }
                current = child;
            }
            current.val = 1;
        }
        dfs(head, 0);
        return globalMax;
    }

    private void dfs(TriNode head, int sum) {
        if (head.val == 1) {
            sum++;
            globalMax = Math.max(globalMax, sum);
        }
        for (int i = 0; i < 26; i++) {
            if (head.next[i] != null) {
                dfs(head.next[i], sum);
            }
        }
    }
}
