/** 56. Merge Intervals
 *Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * **/
package Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (int[]a, int[] b) -> {
            return a[0]-b[0];
        });


        for(int i = 0; i < intervals.length -1; i++){
            //
            if(intervals[i+1][0] <= intervals[i][1] ){
                intervals[i+1][0] =  Math.min(intervals[i][0], intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);

            }
            //没交集
            else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }

        }
        list.add(new int[]{intervals[intervals.length-1][0], intervals[intervals.length-1][1]});
//        // list.toDeepArray()
//        int[][] intArray = list.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
//        return intArray;
        int size = list.size();

        return null;

    }



    public static void main(String[] arg){

        int[][] temp = new int[][]{{1,3}, {2,6} , {8,10} ,{15,18}};

        for (int i =0 ; i<temp.length ; i++){

        }
        System.out.println(temp);
        Merge_Intervals myApp = new Merge_Intervals();
        myApp.merge(temp);

    }
}
