/** 149. Max Points on a Line **/
package Q149_Max_Points_on_a_Line;

import java.util.*;

public class MaxPointOnALine {
    public int maxPoints(int[][] points) {


        int length = points.length;
        if (length == 1) return 1;

        int result = 0;

        Map<Double, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int counter = 0;
            map.clear();
            for (int j = 0; j < length; j++) {

                if (points[i][0] == points[j][0]) {
                    counter++;
                } else {
                    double k = ((double) (points[i][1] - points[j][1])) / ((double) (points[i][0] - points[j][0]));
                    map.put(k, map.getOrDefault(k, 1) + 1);
                }
            }

            int mapMaxValue=0;
         if( !map.isEmpty()) {
             ArrayList<Integer> c = new ArrayList<>(map.values());
             Collections.sort(c);
             int size = c.size();

             mapMaxValue = c.get(size - 1);


         }

            result = Math.max(counter, mapMaxValue);
        }

        return result;
    }

    public static void main(String[] arg) {
        MaxPointOnALine temp = new MaxPointOnALine();
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        int[][] points2 = new int[][]{{3, 10}, {0, 2}, {0, 2}, {3, 10}};

        //[[3,1],[12,3],[3,1],[-6,-1]]

        int[][] points3 = new int[][]{{3, 1}, {12, 3}, {3, 1}, {-6, -1}};
        int[][] points4 = new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 4}, {3, 3}};
        int[][] points5 = new int[][]{{0,0}, {0, 0}};


        System.out.print(temp.maxPoints(points5));


    }
}
