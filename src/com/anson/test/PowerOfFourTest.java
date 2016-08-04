package com.anson.test;

import com.anson.twosigma.PowerOfFour;
import org.junit.Test;

/**
 * Created by chenzian on 8/3/16.
 */
public class PowerOfFourTest {
    @Test
    public void isPowerOFFour() throws Exception {
        PowerOfFour powerOfFour = new PowerOfFour();
        System.out.println(powerOfFour.isPowerOfFour(64l));
    }

}