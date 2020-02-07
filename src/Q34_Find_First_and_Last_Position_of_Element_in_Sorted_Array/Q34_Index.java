/**Q34
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1] **/

package Q34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Q34_Index {
    int start=-1;
    int end=-1;
    public int[] searchRange(int[] nums, int target) {
        // 5,7,7,8,8,8,8,8,10
        helper1(nums, target, 0, nums.length-1);
        helper2(nums, target, 0, nums.length-1);
        return new int[]{start, end};
    }

    public void helper1(int[] nums,int target,int low, int high){
        if(low <= high){
            int middle = low + (high-low)/2;
            if(target < nums[middle]){
                helper1(nums, target, low, middle-1);
            }
            else if(target > nums[middle]){
                helper1(nums, target, middle+1, high);
            }
            // ==
            else{
                if((middle > 0 && nums[middle] > nums[middle-1] )|| middle ==0){
                    start = middle;
                    return;
                }

                else
                    helper1(nums, target, low, middle-1);
            }
        }
    }

    public void helper2(int[] nums,int target,int low, int high){
        if(low <= high){
            int middle = low + (high-low)/2;
            if(target < nums[middle]){
                helper2(nums, target, low, middle-1);
            }
            else if(target > nums[middle]){
                helper2(nums, target, middle+1, high);
            }
            // ==
            else{
                if((middle < nums.length-1 && nums[middle] < nums[middle+1] ) || middle ==nums.length-1){
                    end = middle;
                    return;
                }

                else
                    helper2(nums, target, middle+1, high);
            }
        }

    }

}
