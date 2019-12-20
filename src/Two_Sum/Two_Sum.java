package Two_Sum;// #001
// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// Example:
// Given nums = [2, 7, 11, 15], target = 9,
//
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

import java.util.HashMap;
import java.util.Map;

class TwoSum {
   //Solution 1
    public int[] twoSum1(int[] nums, int target) {
       for (int i =0; i <nums.length; i++) {
           for(int j=i+1; j<nums.length;j++) {
               if (target == nums[i]+nums[j]){
                   return new int[] {i,j};
               }
           }

       }
        throw new IllegalArgumentException("No two sum solution");
    }

    //Solution 2
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    //Solution3
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.print("the complement is "+ complement+"\n");

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
