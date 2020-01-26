package Q53_Maximum_Subarry;

public class Q53_Maximum_Subarry {

    public int maxSubArray(int[] nums) {
        return subSum(nums, 0, nums.length-1 );
    }

    public int subSum(int[] nums, int l, int h){
        if(l == h){ // when refers to the same elem
            return nums[l];
        }
        int m = (l + h)/2; ///4
        int left = subSum(nums, l, m);
        int right = subSum(nums, m+1, h);
        int cross = crossSum(nums, l, m, h);
        if(left >= cross && left >= right){
            return left;
        }
        else if (right >= left && right >= cross){
            return right;
        }
        else
            return cross;
    }

    public int crossSum(int[] nums, int l, int m, int h){
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        int sum = 0;
        for(int i = m; i >= l; i--){
            sum += nums[i];
            if(sum > left){
                left = sum;
            }
        }

        sum = 0;
        for(int i = m+1; i<= h; i++){
            sum += nums[i]; // -1
            if(sum > right){
                right = sum; //-1
            }
        }

        return left + right;
    }
}
