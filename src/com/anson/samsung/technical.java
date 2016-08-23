package com.anson.samsung;

import java.util.Random;

/**
 * Created by chenzian on 8/13/16.
 */
public class technical {
    /*
    * http://www.1point3acres.com/bbs/thread-81480-1-1.html
    * 面经题1
    *
    * Print 500 random numbers from 1 to 500. If the number divisble by 3 print "foo" if divisible by 5 print "bar" if divisible by 3 and 5 print "foobar"    (fizbuzz)
    */
    int random = new Random().nextInt(500) + 1;


    /*
    * 3. Write a function that takes a restraunt bill. Calculate the minimum tip such that the resulting total is a palindrome. You may disreguard the decimal point '.' in the palindrome.  (Find the next Palindrome)

ex. calcPalin(12.10)
        0.11
    *
    * double 和float都不care小数点后面到底有几个零。12.10和12.1是完全相同的两个数,一旦赋值给double,都会变成12.1.所以这个数字必须给成String的形式"12.10"才能保住这个零。
    * 然后,去掉中间的小数点之后,劈成两半,从中间开始用two pointer往两边扩,不断match到相对大的数字,就ok了。例如 1234, 2match3,1match4.
    * */

    /*
        http://www.1point3acres.com/bbs/thread-197686-1-1.html
        第5题
        1)先做inverted index
        2)对于query的每一个单词,拿到对应的list的copy (List<Type> newList = new ArrayList(list1)), 然后针对每一个query出现的单词递进地去做retainAll操作(找list的intersection)
        list1.retainAll(list2); retainAll虽然返回的是boolean,但是list1本身update成了intersection之后的交集。

        第4题
        http://www.jiuzhang.com/solutions/palindrome-partitioning-ii/
        参考九章这个做法version1的预处理部分,就是一个二维dp

    */

    /*
    * http://www.1point3acres.com/bbs/thread-180210-1-1.html
    * 1.给两个数(a, b)，找出中间的prime number(inclusive), 好像leetcode上有类似的题目.
follow up讨论了下如何优化, 说skip所有偶数. 还有就是外层for loop 只需要loop到 sqrt(n),而不需要弄到n
    http://www.geeksforgeeks.org/sieve-of-eratosthenes/

      2. gcd of n numbers
      http://stackoverflow.com/questions/15351195/finding-the-gcd-of-n-numbers
      recursion的做法, gcd(a,b,c) = gcd(gcd(a,b),c);

      3.sort string，给一个set of string, 照字母排序. 基本就是implement sort() function, 没啥特别的
      写一个greaterThan的method, 比较两个String谁大谁小,然后把这个sort弄进快排或者merge sort
    *
    * */

}
