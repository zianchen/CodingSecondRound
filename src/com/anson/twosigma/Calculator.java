package com.anson.twosigma;

import java.util.*;

/**
 * Created by chenzian on 6/29/16.
 */

abstract class Operation{

    public abstract float getResult(float f1, float f2);
}

class Add extends Operation{
    @Override
    public float getResult(float f1, float f2) {
        return f1 + f2;
    }
}

class Sub extends Operation{
    @Override
    public float getResult(float f1, float f2) {
        return f1 - f2;
    }
}

class Mul extends Operation{
    @Override
    public float getResult(float f1, float f2) {
        return f1 * f2;
    }
}

class Div extends Operation{
    @Override
    public float getResult(float f1, float f2) {
        return f1 / f2;
    }
}

class OperationFactory{

    protected Map<Character, Operation> oMap = new HashMap();

    public OperationFactory(){
        oMap.put('+', new Add());
        oMap.put('-', new Sub());
        oMap.put('*', new Mul());
        oMap.put('/', new Div());
    }

    float calculate(float f1, float f2, char op) {
        return oMap.get(op).getResult(f1, f2);
    }
}

class Tokens {

    private String s;
    private int index;

    public Tokens(String input) {
        this.s = input;
        this.index = 0;
    }
    public boolean hasNext() {
        if (index == s.length()) {
            return false;
        }
        while (s.charAt(index) == ' ') {
            index++;
        }
        return index < s.length();
    }
    public boolean isValue() {
        return Character.isDigit(s.charAt(index));
    }
    public char getChar(){
        char c = s.charAt(index);
        index++;
        return c;
    }
    public float getValue() {
        int temp = index+1;
        while(s.charAt(temp) != ' ') {
            temp++;
        }
        float res = Float.parseFloat(s.substring(index,temp));
        index = temp + 1;
        return res;
    }
}
public class Calculator {

    protected static Tokens tk;
    protected static Stack<Float> stk = new Stack();

    public static float evaluate(String s) throws Exception {
        tk = new Tokens(s);
        while (tk.hasNext()) {
            if (tk.isValue()) {
                float operand = tk.getValue();
                stk.push(operand);
            } else {
                float f1 = Float.MIN_VALUE, f2 = Float.MIN_VALUE;
                if (!stk.isEmpty()) {
                    f2 = stk.pop();
                }
                if (!stk.isEmpty()) {
                    f1 = stk.pop();
                }
                if (f1 != Float.MIN_VALUE && f2 != Float.MIN_VALUE) {
                    stk.push(calculate(f1, f2, tk.getChar()));
                } else {
                    throw new Exception("invalid reverse polish notation!");
                }
            }
        }
        float result = stk.pop();
        if (!stk.isEmpty()) {
            throw new Exception("invalid reverse polish notation!");
        }
        return result;
    }

    public static float calculate(float f1, float f2, char op) {
        OperationFactory factory = new OperationFactory();
        return factory.calculate(f1, f2, op);
    }
}



