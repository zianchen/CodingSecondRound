package com.anson.samsung;

/**
 * Created by chenzian on 8/4/16.
 */
public class CutParentheses {

    public static void main(String[] args) {
        String test = ")**( ( ) ()";
        CutParentheses cutParentheses = new CutParentheses();
        System.out.println(cutParentheses.cutInParentheses(test));
    }

    public int cutInParentheses(String parentheses) {
        int len = parentheses.length();
        int lp = 0, rp = 0;
        int i = 0, j = len - 1;
        while (i < j) {
            char left = parentheses.charAt(i);
            char right = parentheses.charAt(j);
            if (left == '(') {
                lp++;
                i++;
            }
            if (right == ')') {
                rp++;
                j--;
            } else {
                i++;
                j--;
            }
        }
        if (parentheses.charAt(i) == '(') {
            lp++;
        } else if (parentheses.charAt(i) == ')') {
            rp++;
        }
        return lp == rp ? i : -1;
    }
}
