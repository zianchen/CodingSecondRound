package com.anson.twosigma;

/**
 * Created by chenzian on 8/3/16.
 */
public class PowerOfFour {

    /**
     * The basic idea is from power of 2, We can use "n&(n-1) == 0" to determine if n is power of 2.
     * For power of 4, the additional restriction is that in binary form, the only "1" should always
     * located at the odd position. For example, 4^0 = 1, 4^1 = 100, 4^2 = 10000. So we can use "num
     * & 0x55555555==num" to check if "1" is located at the odd position.
     *
     * @param num
     * @return
     */

//    boolean isPowerOfFour(long num) {
//        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x5555555555555555l) == num);
//    }


//    public boolean isPowerOfFour(long num) {
//       if (num <= 0) {
//           return false;
//       }
//       // 这里要单独处理num == 1的原因是,如果不处理,下一轮recursion就会num / 4把 num变成0,从而返回false
//       if (num == 1) {
//           return true;
//       }
//       return (num % 4 == 0) && isPowerOFFour(num / 4);
//    }
    public boolean isPowerOfFour(long num) {
        return (num > 0) && ((num & (num - 1)) == 0) && (num % 3 == 1);
    }
}





