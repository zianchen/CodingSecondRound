package com.anson.snapchat;

/**
 * Created by chenzian on 6/27/16.
 */
public class ValidUsername {

    public static boolean detectInvalidUsername(String s, String target)
    {
        if (s == null || target == null || Math.abs(s.length() - target.length()) >= 2) {
            return false;
        }
        int m = s.length(), n = target.length();
        if (m == n + 1) {
            return isInvalid(target, s);
        } else {  // n == m + 1
            return isInvalid(s, target);
        }
    }

    public static boolean isInvalid(String shortStr, String longStr) {
        for (int i = 0; i < longStr.length(); i++) {
            String newStr = longStr.substring(0,i) + longStr.substring(i+1);
            if (shortStr.equals(newStr)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "snapchat";
        String target = "snapchat";
        boolean ret = detectInvalidUsername(s,target);
        System.out.println(ret);
    }
}
