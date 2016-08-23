package com.anson.facebook;

/**
 * Created by chenzian on 8/22/16.
 */
public class ExcelNumber {
    public static void main(String[] args) {
        ExcelNumber excelNumber = new ExcelNumber();
        System.out.println(excelNumber.titleToNumber("ABC"));
    }

    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + (s.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
