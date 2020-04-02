package Q1_Two_Sum;

import Q1_Two_Sum.TwoSum;

public class Test {


    public static void main (String args[]) {
        TwoSum test1 = new TwoSum();

        int [] nums = new int [] {2,7,11,15};
        int target = 9;

        //test1.twoSum1(nums,target);
        System.out.print(   test1.twoSum1(nums,target)[0]+"\n");
        System.out.print(   test1.twoSum1(nums,target)[1]+"\n");

        int [] array2 = test1.twoSum3(nums,target);
        System.out.print(   array2[0]+"\n");
        System.out.print(   array2[1]);

    }
}
