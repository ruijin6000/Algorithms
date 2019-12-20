//447
package numberOfBoomerangs;

import java.util.HashMap;

public class points {
    public int numberOfBoomerangs(int[][] points) {


        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        int length =  points.length;
        for(int i = 0; i < length-1; i++){

            for(int j = 0 ; j < length; j++ ){



                int x = (int)Math.pow((points[i][0] - points[j][0]) , 2);
                int y = (int)Math.pow((points[i][1] - points[j][1]) , 2);
                int sum = x + y;

                map.put(sum, map.getOrDefault(sum, 0)+1);

            }

            System.out.print( map);

            for (Integer distance : map.keySet()) {
                if(map.get(distance) >=2)
                    result += fact(map.get(distance));
                result += (map.get(distance))*(map.get(distance)-1);
            }

            map.clear();
        }


        return result;
    }


     static int fact(int n)
    {
        if (n == 0)
            return 1;

        return n*fact(n-1);
    }

    public static void main (String[] args ) {
        points temp = new points ();
       int[][] ps = new int[][]{{0,0},{1,0},{2,0}};

     System.out.print( temp.numberOfBoomerangs(ps));


    }
}



