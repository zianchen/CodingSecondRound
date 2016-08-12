package com.anson.test;

import com.anson.twosigma.Calculator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenzian on 6/29/16.
 */
public class CalculatorTest {

    @Test
    public void process() throws Exception {
        Calculator calculator = new Calculator();
        List<String> RPN = Arrays.asList("1 2 /");
        for (String s : RPN) {
            float ret = Calculator.evaluate(s);
            System.out.println("ret is : " + ret);
        }
    }
}