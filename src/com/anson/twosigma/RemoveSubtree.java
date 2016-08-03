package com.anson.twosigma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenzian on 8/2/16.
 */
class Node{
    int parent;
    boolean valid;
    boolean visited;

    Node (int p) {
        parent = p;
        valid = true;
        visited = false;
    }
}

public class RemoveSubtree {
    public static void deleteSubTree(List<Node> treeArray, int index, int n) {
        // n 代表数组里一共有n个元素
        Node target = treeArray.get(index);
        target.valid = false;
        target.visited = true;

        for (int i = 0; i < n; i++) {
            if (treeArray.get(i).visited) {
                continue;
            }
            if (needDelete(treeArray, i)) {
                label(treeArray, i);
            }
        }
    }

    public static boolean needDelete(List<Node> treeArray, int i) {
        while (i != -1 && !treeArray.get(i).visited) {
            treeArray.get(i).visited = true;
            i = treeArray.get(i).parent;
        }
        if (i == -1) {
            return false;
        }
        return !treeArray.get(i).valid;
    }

    public static void label(List<Node> treeArray, int i) {
        while (treeArray.get(i).valid) {
            treeArray.get(i).valid = false;
            i = treeArray.get(i).parent;
        }
    }
    public static void printTree(List<Node> treeArray) {
        for (int i = 0; i < treeArray.size(); i++) {
            System.out.println(i + "'s parent is: " + treeArray.get(i).parent + " valid is: " + treeArray.get(i).valid);
        }
    }
    public static void main(String[] args) {
        int[] input = {5, 5, 1, 7, 3, 7, 7, -1};
        List<Node> treeArray = new ArrayList();
        for (int i = 0; i < input.length; i++) {
            treeArray.add(i, new Node(input[i]));
        }
        int n = input.length;
        printTree(treeArray);
        System.out.println();
        deleteSubTree(treeArray, 5, n);
        printTree(treeArray);
    }
}
