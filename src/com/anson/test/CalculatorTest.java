package com.anson.test;

import com.anson.twosigma.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenzian on 6/29/16.
 */
public class CalculatorTest {

    @Test
    public void process() throws Exception {
        Calculator calculator = new Calculator();
        List<String> RPN = Arrays.asList("2 1 + 3 *", " 4 13 5 / +");
        for (String s : RPN) {
            calculator.evaluate(s);
            float ret = calculator.evaluate(s);
            System.out.println("ret is : " + ret);
        }
    }
}