package com.anson.samsung.phoneandonsite;

/**
 * Created by chenzian on 8/15/16.
 */
public class SwapWithoutTemp {

    // 注意, java里要swap 两个int,一定要在当前函数中swap,因为无论是int还是integer,都无法将对应数值的地址传入形参,传递的都是值。
//    即便是Integer a = new Integer(1) 或者Integer a = 1;
    private int c;
    private int d;

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }

    public void swap(SwapWithoutTemp s) {
        s.c = s.c ^ s.d;
        s.d = s.d ^ s.c;
        s.c = s.c ^ s.d;
    }
}
