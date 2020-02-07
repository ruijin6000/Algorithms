/** 31  Next Permutation
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1 **/

package Q31_Next_Premutation;

import java.util.Arrays;
import java.util.Collections;

public class Q31_NextPeremutation {
    int index = -1;

    public void nextPermutation(int[] nums) {

        helper(nums);

        if ( index ==-1) {
            reverse(nums,nums.length);
        }
        else {
            Arrays.sort(nums, index+1, nums.length );
        }

    }

    public void helper(int[] nums){
        for (int i=nums.length-1; i>=0; i-- ) {
            int min = nums[i];
            for (int j=i; j>=0; j--) {
                if (min > nums[j]) {
                    nums[i] = nums[j];
                    nums[j] = min;
                    index = j;
                    return;
                }
            }
        }
    }

    static void reverse(int a[], int n)
    {
        int i, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }

    }

    public static void main(String[] args) {

        int[] array = new int[] {4,2,0,2,3,2,0};
        Q31_NextPeremutation app = new Q31_NextPeremutation();
     app.nextPermutation(array);
        for (int i : array){
            System.out.println(i);
        }
    }

}
