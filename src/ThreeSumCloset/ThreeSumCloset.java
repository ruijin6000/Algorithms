package ThreeSumCloset;

//Given an array nums of n integers and an integer target, find three integers in nums
// such that the sum is closest to target. Return the sum of the three integers.
// You may assume that each input would have exactly one solution.
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


import java.util.Arrays;

public class ThreeSumCloset {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int size = nums.length;

        int distance= Math.abs(nums[0]+nums[1]+nums[size-1]-target);
        int result = nums[0]+nums[1]+nums[size-1];

        for (int i = 0; i < size - 1; i++) {

            int l = i + 1;
            int h = size - 1;

            while (l < h) {

                int sum = nums[i] + nums[l] + nums[h];

                if (distance > Math.abs(sum-target) ){
                    distance = Math.abs(sum-target);
                    result = sum;
                }

                if (sum < target) {
                    l++;

                } else if (sum > target) {
                    h--;
                }

                else {

                    return result;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        ThreeSumCloset temp = new ThreeSumCloset();

        System.out.print(temp.threeSumClosest(nums, 1));

    }
}
