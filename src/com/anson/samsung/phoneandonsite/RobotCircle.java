package com.anson.samsung.phoneandonsite;

import com.anson.util.Print;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzian on 8/16/16.
 */
public class RobotCircle {

    private Map<Character, Character> leftMap = new HashMap<>();
    private Map<Character, Character> rightMap = new HashMap<>();

    {
        leftMap.put('N', 'W');
        leftMap.put('W', 'S');
        leftMap.put('S', 'E');
        leftMap.put('E', 'N');
        rightMap.put('N', 'E');
        rightMap.put('E', 'S');
        rightMap.put('S', 'W');
        rightMap.put('W', 'N');
    }

    public static void main(String[] args) {
        String[] input = {"GRG", "G", "L", "R"};
        RobotCircle robotCircle = new RobotCircle();
        String[] res = robotCircle.robotCircle(input);
        Print.printArray(res);
    }

    public String[] robotCircle(String[] input) {
        if (input == null || input.length == 0) {
            throw new NullPointerException("input is empty!");
        }
        String[] res = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            res[i] = hasCircle(input[i], 0, 0) ? "YES" : "NO";
        }
        return res;
    }

    private boolean hasCircle(String s, int x, int y) {
        int posX = x;
        int posY = y;
        char currDirection = 'N';
        boolean hasLoop = false;
        for (char c : s.toCharArray()) {
            if (c == 'G') {
                switch (currDirection) {
                    case 'N':
                        posY++;
                        break;
                    case 'S':
                        posY--;
                        break;
                    case 'E':
                        posX++;
                        break;
                    case 'W':
                        posX--;
                        break;
                    default:
                        break;
                }
            } else if (c == 'L') {
                currDirection = leftMap.get(currDirection);
            } else {
                currDirection = rightMap.get(currDirection);
            }
        }
        /**
         * 主要是这里非常不好想
         * if currentPos == (0,0), must be true;
         * if currentPos != (0,0), just curDirection == N will be false, all other direction will lead robot back with couple of String calls.
         */
        if (posX == x && posY == y) {
            hasLoop = true;
        } else {
            hasLoop = currDirection != 'N';
        }
        return hasLoop;
    }
}
