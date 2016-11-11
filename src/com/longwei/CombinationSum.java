package com.longwei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by longweisu on 11/11/16.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> path = new ArrayList<Integer>();
        searchHelper(candidates, target, path, 0, 0, result);
        return result;
    }

    private void searchHelper(int[] candidates, int target, ArrayList<Integer> path, int index, int pathSum, List<List<Integer>>ret) {

        if (pathSum > target) return;
        if (pathSum == target) {
            ret.add(new ArrayList<Integer>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            pathSum= pathSum + candidates[i];
            if( pathSum > target ) {
                return;
            }
            path.add(candidates[i]);
            searchHelper(candidates, target, path, i ,pathSum, ret);
            path.remove(path.size() -1);
            pathSum = pathSum - candidates[i];
        }
    }
}
