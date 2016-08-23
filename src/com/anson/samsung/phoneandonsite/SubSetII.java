package com.anson.samsung.phoneandonsite;

import com.anson.util.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenzian on 8/16/16.
 */
public class SubSetII {

    private List<List<Integer>> res = new ArrayList();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        SubSetII subSets = new SubSetII();
        List<List<Integer>> output = subSets.subSets(arr);
        Print.printtwoDList(output);
    }

    public List<List<Integer>> subSets(int[] input) {
        if (input == null || input.length == 0) {
            return res;
        }
        // 一定要记得sort,sort的原因一是为了生成的subset是按照递增顺序的,二是用while skip duplicate的元素的时候判断方便
        Arrays.sort(input);
        List<Integer> tmp = new ArrayList();
        res.add(tmp);
        subSetHelper(input, 0, tmp);
        return res;
    }

    private void subSetHelper(int[] input, int start, List<Integer> tmp) {
        for (int i = start; i < input.length; i++) {
            tmp.add(input[i]);
            res.add(new ArrayList<>(tmp));
            subSetHelper(input, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
            while (i < input.length - 1 && input[i] == input[i + 1]) {
                i++;
            }
        }
    }
}
