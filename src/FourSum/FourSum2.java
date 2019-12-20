package FourSum;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

            int ret = 0;
            Map<Integer, Integer> map_AB = new HashMap<>();
            Map<Integer, Integer> map_CD = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {

                    System.out.print(map_AB.get(A[i]+B[j]));
                    if (map_AB.get(A[i]+B[j]) == null) {
                        map_AB.put(A[i]+B[j],1);
                    }
                    else {
                        map_AB.put(A[i]+B[j],map_AB.get(A[i]+B[j])+1);
                    }

                    if (map_CD.get(C[i]+D[j]) == null) {
                        map_CD.put(C[i]+D[j],1);
                    }
                    else {
                        map_CD.put(C[i]+D[j],map_CD.get(C[i]+D[j])+1);
                    }

//                    map_AB.put(A[i]+B[j], map_AB.getOrDefault(A[i]+B[j], 0) + 1);
//                    map_CD.put(C[i]+D[j], map_CD.getOrDefault(C[i]+D[j], 0) + 1);

                }
            }

            System.out.print(map_AB+ "\n");
            System.out.print(map_CD+"\n");
//            for (Integer value : map_AB.keySet()) {
//                System.out.print("value"+ map_AB.get(value) + "\n");
//                ret = ret + (map_AB.get(value) * map_CD.getOrDefault(0 - value, 0));
//            }

            for (Integer value : map_AB.keySet()) {
                if (map_CD.get(-value) != null) {
                    ret = ret + map_AB.get(value)* map_CD.get(-value);
                }
//               System.out.print(value + " => ");
//               System.out.print(map_AB.get(value)+ "\n");
            }

            return ret;
        }




      public static void main (String[] args ) {
             FourSum2 solution = new FourSum2();
             int [] A = new int [] {1,2,-4};
             int [] B = new int [] {-2,-1,5};
             int [] C = new int [] {-1,2,-1};
             int [] D = new int [] {0,2,-2};
             System.out.print(solution.fourSumCount(A,B,C,D));


      }


    }








