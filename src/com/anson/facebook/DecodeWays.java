package com.anson.facebook;

/**
 * Created by chenzian on 8/19/16.
 */
public class DecodeWays {
    public static void main(String[] args) {
        String input = "27";
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings(input));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        String sub = s.substring(0, 2);
        if (Integer.parseInt(sub) <= 26) {
            return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        } else {
            return numDecodings(s.substring(1));
        }
    }
}
