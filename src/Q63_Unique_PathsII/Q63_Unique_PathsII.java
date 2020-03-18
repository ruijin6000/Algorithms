package Q63_Unique_PathsII;

public class Q63_Unique_PathsII {

    int [][] memo;
    int m;
    int n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        memo = new int[m][n];

        for (int i =0 ;i < m ; i++) {
            for(int j=0; j<n ; j++) {
                memo[i][j]=-1;
            }
        }
        return helper(obstacleGrid,0,0);
    }

    public int helper(int[][] obs, int row, int col) {

        if ( row >=m || col >= n ) {
            return 0;
        }

        if(obs[row][col] == 1) {
            return 0;
        }

        if( row == m-1 && col == n-1 ) {
            return 1;
        }

        if ( memo[row][col] > -1 ) {
            return memo[row][col];
        }

        memo[row][col] = helper(obs,row+1,col)+helper(obs,row,col+1);
        return memo[row][col];
    }



    public static void main (String args[]) {
        Q63_Unique_PathsII app = new Q63_Unique_PathsII();
        int[][] obstacleGrid = new int[3][3];
        app.uniquePathsWithObstacles(obstacleGrid);
    }

}
