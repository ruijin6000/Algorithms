package Q938_Minimum_Cost_For_Tickets;

public class Q938_Minimum_Cost_For_Tickets {

    int [] memo;
    int []days;
    int [] costs;

    public int mincostTickets(int[] days, int[] costs) {

       this.memo = new int[366];
       this.days = days;
       this.costs =costs;
       return  helper(days[0],0);
    }

    public int helper(int currentDay, int currentIndex){

        if (currentDay >days[days.length-1]){
            return 0;
        }

        while (currentDay > days[currentIndex]){
            currentIndex++;
        }

        currentDay = days[currentIndex];

        if(memo[currentDay]>0) {
            return memo[currentDay];
        }

        int a =  helper(currentDay+1,currentIndex)+costs[0];
        int b =  helper(currentDay+7,currentIndex)+costs[1];
        int c =  helper(currentDay+30,currentIndex)+costs[2];



        memo[currentDay] = Math.min(c, Math.min(a,b) );


        return memo[currentDay];
    }


    public static void main(String[] args) {

        Q938_Minimum_Cost_For_Tickets app = new Q938_Minimum_Cost_For_Tickets();
        int [] days1 = new int[] {1,4,6,7,8,20};
        int[] costs1 = new int[] {2,7,15};

        int [] days = new int[] {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
        int[] costs = new int[] {3,13,45};

        System.out.println(app.mincostTickets(days,costs));
    }


}
