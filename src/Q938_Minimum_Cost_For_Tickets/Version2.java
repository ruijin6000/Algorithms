package Q938_Minimum_Cost_For_Tickets;

import java.util.HashSet;
import java.util.Set;

public class Version2 {

    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;
    int[] days;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet();
        for (int d: days) dayset.add(d);
        return dp(1);
    }

    public int dp(int i) {
        if (i > days[days.length-1])
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans;
        if (dayset.contains(i)) {
            ans = Math.min(dp(i+1) + costs[0],
                    dp(i+7) + costs[1]);
            ans = Math.min(ans, dp(i+30) + costs[2]);
        } else {
            ans = dp(i+1);
        }

        memo[i] = ans;
        return ans;
    }


    public static void main(String[] args) {

        Version2 app = new Version2();
        int [] days1 = new int[] {1,4,6,7,8,20};
        int[] costs1 = new int[] {2,7,15};

        int [] days = new int[] {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        int[] costs = new int[] {3,13,45};

        System.out.println(app.mincostTickets(days,costs));
    }
}
