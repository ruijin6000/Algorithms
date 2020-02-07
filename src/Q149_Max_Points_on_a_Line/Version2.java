package Q149_Max_Points_on_a_Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Version2 {
    int result = 0;
    int max = Integer.MIN_VALUE;
   //y=kx+b
    public int maxPoints(int[][] points) {


        if (points.length == 1) return 1;


        for (int i = 0; i < points.length-1; i++) {

                int y2suby1 =  points[i+1][1]-points[i][1];
                int x2subx1 =  points[i+1][0]-points[i][0];
                int mulb = points[i][1]*x2subx1-points[i][0]*y2suby1;
                int counter = 0;

            for (int j = 0; j < points.length; j++) {

                int left = points[j][1]*x2subx1;
                int right = points[j][0]*y2suby1+mulb;
                  if (left == right){
                      counter++;
                  }
            }

            if (counter>max){
                max= counter;
            }


        }


      return max;

    }


    public int GCD(int a, int b) {
        if(b==0) return a;
        return a % b == 0 ? b : GCD(b, a % b);
    }

    public static void main(String[] arg) {
        Version2 temp = new Version2();
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        int[][] points2 = new int[][]{{3, 10}, {0, 2}, {0, 2}, {3, 10}};

        int[][] points3 = new int[][]{{3, 1}, {12, 3}, {3, 1}, {-6, -1}};
        int[][] points4 = new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 4}, {3, 3}};
        int[][] points5 = new int[][]{{0,0}, {1, 65536},{65536,0}};


        System.out.print(temp.maxPoints(points5));

    }
}
