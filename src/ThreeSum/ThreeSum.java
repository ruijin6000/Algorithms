/** #15
 *  Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 **/
package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {


    public void helper(int[] nums, int index, List<List<Integer>> list) {
        // a+[b+c]   i = 0
        //List<Integer> bc = new ArrayList<Integer>();


        for (int j = 0; j < nums.length && j != index; j++) {

            for (int k = 0; k < nums.length && k != j; k++) {

                if (nums[index] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[index]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if (exist(list,temp)) {
                        list.add(temp);
                    }
                }
            }
        }
        return;
    }

    public boolean exist (List<List<Integer>> list,  List<Integer> temp ) {

        Collections.sort(temp);
        for (int i =0 ; i< list.size() ; i++ ) {
            Collections.sort(list.get(i));

        }

        for (int j =0 ; j< list.size()  ; j++ ) {
            if (temp.equals(list.get(j)) ) {
                return false;
            }
        }

        return true;
    }


//    public List<List<Integer>> threeSum(int[] nums) {
//
//
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//
//            helper(nums, i, list);
//        }
//
//        return list;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        // -1， -1, -1, 2, -1,  -1
        //      i
        //          l
        //                  h

        Arrays.sort(nums);
        List<List<Integer>> wrapList = new ArrayList<>();
        int size = nums.length;

        for (int i = 0; i < size - 1; i++) {

//            if (i >0  && nums[i - 1] == nums[i]) continue;
            int l = i + 1;
            int h = size - 1;
            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    h--;
                }
                // = 0
                else {
                    List<Integer> list = new ArrayList<>();
                    list.addAll(Arrays.asList(nums[i], nums[l], nums[h]));
                    wrapList.add(list);
                    while (l < h && nums[l + 1] == nums[l]) l++;
                    while (l < h && nums[h - 1] == nums[h]) h--;
                    l++;
                    h--;
                }

            }

             while (i >=0 && i< size -1  && nums[i + 1] == nums[i] ) {
                i++;
            }
        }
        return wrapList;

    }

    public static void main(String[] args) {
         ThreeSum t = new ThreeSum();
        //int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        int[] nums = new int[] {0, 0, 0};
        System.out.print(t.threeSum(nums));

    }


}
