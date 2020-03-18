package Q62_Unique_Paths;

public class Q62_UniquePaths {
    int [][] memo;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        this.m = m;
        this.n = n;
        return helper(0,0);

    }

    public int helper(int row, int col) {

        if ( row >=m || col >= n ) {
            return 0;
        }

        if( row == m-1 && col == n-1 ) {
            return 1;
        }

        if ( memo[row][col] > 0 ) {
            return memo[row][col];
        }

        memo[row][col] = helper(row+1,col)+helper(row,col+1);
        return memo[row][col];
    }

    public static void main(String args[]) {
        Q62_UniquePaths app = new Q62_UniquePaths();
        final int temp =app.uniquePaths(3,2);
        System.out.println(temp);


    }

}
