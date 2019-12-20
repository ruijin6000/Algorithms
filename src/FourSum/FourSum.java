package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);

            // -4, -1, -1, -1,0,1,2   t:-1
            //      i
            //              j

            // i
            //     j
            // .         l .
            // .               h
            List<List<Integer>> wrapList = new ArrayList<>();
            int length = nums.length;
            for(int i = 0; i<length-3; i++ ){
                if( i > 0 && nums[i] == nums[i-1]) continue;

                for(int j = i + 1; j < length-2; j++){


                    int l = j + 1;
                    int h = length -1;
                    while(l < h){
                        int sum = nums[i] + nums[j] + nums[l] + nums[h];
                        if(sum < target){
                            l++;
                        }
                        else if (sum > target){
                            h--;
                        }
                        else {
                            List<Integer> list = new ArrayList<>();
                            list.addAll(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                            wrapList.add(list);
                            while(l < h && nums[l+1] == nums[l]) l++;
                            while(l < h && nums[h-1] == nums[h]) h--;
                            l++;
                            h--;
                        }
                    }

                    while (j >=1 && j<length-2 && nums[j +1] == nums[j] ) {
                        j++;
                    }
                }


            }
            return wrapList;

        }
    }
}
