package com.longwei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by longweisu on 11/11/16.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) {
            return ret;
        }
        Arrays.sort(nums);
        ArrayList<Integer> toChoose = new ArrayList<Integer>();
        backtrace(new ArrayList<Integer>(), ret, nums);
        return ret;
    }

    private void backtrace(ArrayList<Integer> path, List<List<Integer>> ret, int[] nums) {
        if (path.size() == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }
        //ret.add(new ArrayList<Integer>(path));

        for (int i = 0; i < nums.length; i++){
            if(path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrace(path, ret, nums);
            path.remove(path.size() - 1);
        }
    }
}
