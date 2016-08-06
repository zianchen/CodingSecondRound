package com.anson.twosigma;

/**
 * Created by chenzian on 8/3/16.
 */

//给一个random number generator的iterator, 要求你基于这个iterator实现另一个叫做ModFiveIterator的数据结构, 其中要求生
//成的随机数可以被五整除, 完成你自己的hasnext(), next()
//随机数的iterator有getnext next. 是产生的随机数中是5的倍数
//iterator有三个methods，第三个remove()我觉得不需要删除underline collection然后我就直接在那个函数里throw Exception
//iterator要在next()中判断hasNext().因为作为一个iterator, 要调用next()不是非得先有hasNext().

// - mode 5 iterator

public class ModFiveIterator extends RandomIterator {

    private RandomIterator rit;
    private int nextElement;

    public ModFiveIterator(RandomIterator randomIterator) {
        rit = randomIterator;
        nextElement = -1;
    }

    public boolean hasNext() throws Exception {
        while (rit.hasNext()) {
            int cur = rit.next();
            if (cur % 5 == 0) {
                nextElement = cur;
                return true;
            }
        }
        return false;
    }

    public int next() throws Exception {
        if (!hasNext()) {
            throw new Exception("No more elements!");
        }
        System.out.println(nextElement);
        return nextElement;
    }

    public void remove() {
//        这里有问题的,根据这篇帖子,这里不能这么实现
//        http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=188714&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D34%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
        rit.remove();
    }
}

