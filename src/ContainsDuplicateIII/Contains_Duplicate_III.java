//220
package ContainsDuplicateIII;

import java.math.BigInteger;

public class Contains_Duplicate_III {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        for (int i=0; i<nums.length-1 ; i++) {

            for (int j=i+1; j< nums.length ; j++) {

                long absValue =Math.abs((long) ((long)nums[i]-(long)nums[j]));

                long absIndexValue = Math.abs(i-j);

                  if ( absValue <= t && absIndexValue<=k){

                      return true;
                }
            }

        }


      return false;
    }

    public static void main(String[] args){


        int  [] nums = new int [] {-1,2147483647};
        int  [] num2 = new int [] {1,0,1,1};
        int  [] num3 = new int [] {1,5,9,1,5,9};
        int  [] num4 = new int [] {2147483647,-2147483647}; // k =1 t = 2147483647


        Contains_Duplicate_III temp= new Contains_Duplicate_III();

        System.out.print(temp.containsNearbyAlmostDuplicate(num4,1,2147483647));
        long a = 2147483647 + 2147483647;
        System.out.println(a);

    }
}
