package com.anson.facebook;

/**
 * Created by chenzian on 8/22/16.
 */
public class ExcelTitle {
    public static void main(String[] args) {
        ExcelTitle excelTitle = new ExcelTitle();
        System.out.println(excelTitle.convertToTitle(36));
    }

    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
//            sb.append((char)('A' + n % 26 - 1));   要不断往前面加
            sb.insert(0, (char) ('A' + n % 26 - 1));
            n /= 26;
        }
        return sb.toString();
    }
}
