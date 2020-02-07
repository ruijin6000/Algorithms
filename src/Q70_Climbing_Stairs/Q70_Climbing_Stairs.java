/** 70. Climbing Stairs
 *You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * **/

package Q70_Climbing_Stairs;

public class Q70_Climbing_Stairs {

    public int climbStairs(int n) {
       int x = n/2;
       int y = n%2;
       int N = x+y;
       int r = x;
       int sum=0;

       while(x!=0) {
           int temp = combine(N,r);
          sum =sum+ temp;
          x--;
          y=y+2;
          r=x;
          N = x+y;
      }


       return sum+1;
    }


       public int combine(int N, int r) {

        if (N ==r ){ return 1; }

        int temp1= N;
        int temp2= N-r;
        int upper = 1;
        int lower =1;

        for (int i = 0 ; i< (N-r); i++) {
               upper =  upper * temp1;
               temp1--;
               lower = lower *temp2;
               temp2--;
        }
     return upper/lower;



//           int fact=1;
//           for(int i=1;i<=number;i++){
//               fact=fact*i;
//           }
//           return fact;
       }

    public static void main (String[] args) {
        Q70_Climbing_Stairs app = new Q70_Climbing_Stairs();

        System.out.println(app.climbStairs(1));
        System.out.println(app.climbStairs(2));
        System.out.println(app.climbStairs(3));
        System.out.println(app.climbStairs(4));
        System.out.println(app.climbStairs(5));
        System.out.println(app.climbStairs(6));
        System.out.println(app.climbStairs(20));

    }
}


/**  Solution
 public int climbStairs(int n) {
 int memo[] = new int[n + 1];
 return climb_Stairs( n, memo);
 }

 public int climb_Stairs(int n, int memo[]) {
 if(n==0 || n==1) {
 return 1;
 }

 if (n<0 ) {
 return 0;
 }

 if (memo[n]>0) {
 return memo[n];
 }
 memo[n] = climb_Stairs(n-1, memo) + climb_Stairs(n-2, memo);
 return memo[n];
 }
 **/