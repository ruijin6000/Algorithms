/** 322 Coin Change
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:

 Input: coins = [1, 2, 5], amount = 11
 Output: 3
 Explanation: 11 = 5 + 5 + 1
 Example 2:

 Input: coins = [2], amount = 3
 Output: -1**/

package Q322_Coin_Change;


import java.util.Arrays;

public class Q322_Coin_Change {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int memo[] = new int[amount + 1];

        helper(coins, amount, memo);
        return  memo[memo.length-1];
    }

    public int helper(int[] coins, int amount, int[] memo) {

        if (amount < 0) {
            return -1;
        }

        if(amount ==0 ){
            return 0;
        }
        // amount = 1

        if ( memo[amount]>0 || memo[amount] == -1) {
            return memo[amount];
        }

        int min = Integer.MAX_VALUE;


        for (int i = coins.length - 1; i >= 0; i--) {

            int temp = helper(coins, (amount - coins[i]), memo);

            if ( temp >=0 && temp < min ) {
                min=temp;
                memo[amount] = min+1;

            }

        }

         if(memo[amount] == 0) {
             memo[amount]=-1;
         }

        return memo[amount];

    }



    public static void main(String[] args) {
         Q322_Coin_Change app = new Q322_Coin_Change();
          int [] coins = new int[] {1,2,5};
          int amount =11;
        System.out.println(app.coinChange(coins,amount) );
    }

}
