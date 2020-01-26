package Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class Q57_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> temp = new ArrayList<>();
        int M = newInterval[0];
        int N = newInterval[1];

        /** 最左边**/
        if (N<intervals[0][0]) {
            temp.add (newInterval);
            for (int i = 0 ; i<intervals.length; i++){
                temp.add(intervals[i]);
            }
        }


        /**check 能不能merge **/
        for (int i = 0; i < intervals.length; i++) {

            /** 不能merge 在中间**/
            if (M > intervals[i][1] && N < intervals[i + 1][0]) {
                for (int j = 0; j < intervals.length; j++) {
                    temp.add(intervals[j]);
                    if (j == i) { temp.add(newInterval); } }
                return temp.toArray(new int[temp.size()][]);
            }




        }
        return null;
    }


        public static void main (String[]arg){

            Q57_Insert_Interval q = new Q57_Insert_Interval();

            int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {10, 11}, {12, 16}};
            int[] newInterval = new int[]{8, 9};
            int[][] result = q.insert(intervals, newInterval);
            System.out.println(Arrays.deepToString(result));

//        int[][] intervals1 = new int[][]{{1,5}};
//        int[] newInterval1 = new int[]{2,7}; // 1, 7
//        int[][] result1 = q.insert(intervals1, newInterval1);
//        System.out.println(Arrays.deepToString(result1));
//
//        int[][] intervals2 = new int[][]{{1,5}};
//        int[] newInterval2 = new int[]{6, 8}; // 1, 5, 6 8
//        int[][] result2 = q.insert(intervals2, newInterval2);
//        System.out.println(Arrays.deepToString(result2));


    }

}
