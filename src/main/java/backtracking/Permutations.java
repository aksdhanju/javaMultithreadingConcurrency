package main.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        res.stream().forEach(innerList -> System.out.println(innerList));
    }
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        permuteArray(nums, 0,n-1, result);
        return result;
    }
    static void permuteArray(int[] nums, int low, int high, List<List<Integer>> result) {
        if(low==high) {
//            List<Integer> list = new ArrayList<>();
//            for (int element: nums) {
//                list.add(element);
//            }
            List<Integer> list = Arrays.stream(nums).boxed().toList();
            result.add(list);
            return;
        }

        for(int i=low;i<=high;i++) {
            swap(nums,i,low);
            permuteArray(nums, low+1,high, result);
            swap(nums,i,low);
        }
    }
    static void swap(int[] nums, int i, int low) {
        int temp = nums[i];
        nums[i]=nums[low];
        nums[low]=temp;
    }
}
