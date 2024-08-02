package main.java.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PermutationsTwo {

    static List<Integer> list;
    static List<List<Integer>> res;
    static Map<Integer, Integer> map;

    public static void main(String[] args) {
        int[] nums = {1,1,3};
        List<List<Integer>> res = permuteUnique(nums);
        res.stream().forEach(innerList -> System.out.println(innerList));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        res = new ArrayList<>();
        map = new HashMap<>();
        for(int num: nums){
            map.put(num,  map.getOrDefault(num, 0) + 1);
        }
        // Print the map to verify
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        dfs(nums);
        return res;
    }

    static void dfs(int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            if (value>0){
                list.add(key);
                map.put(key, value-1);

                dfs(nums);

                value = map.get(key);
                map.put(key, value+1);
                list.remove(list.size() - 1);
            }
        }
    }
}