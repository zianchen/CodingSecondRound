package com.anson.samsung.phoneandonsite;

import com.anson.util.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenzian on 8/16/16.
 */
public class PermutationII {

    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        PermutationII permute = new PermutationII();
        List<List<Integer>> output = permute.permutation(arr);
        Print.printtwoDList(output);
    }

    public List<List<Integer>> permutation(int[] input) {
        if (input == null || input.length == 0) {
            return res;
        }
        Arrays.sort(input);
        boolean[] visited = new boolean[input.length];
        List<Integer> tmp = new ArrayList<>();
        dfs(input, tmp, visited);
        return res;
    }

    private void dfs(int[] input, List<Integer> tmp, boolean[] visited) {
        if (tmp.size() == input.length) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(input[i]);
                dfs(input, tmp, visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
                while (i < input.length - 1 && input[i] == input[i + 1]) {
                    i++;
                }
            }
        }
    }
}
