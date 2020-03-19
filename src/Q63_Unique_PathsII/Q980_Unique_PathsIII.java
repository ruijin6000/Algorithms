/**
 * On a 2-dimensional grid, there are 4 types of squares:
 * <p>
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 * <p>
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 * <p>
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 **/


package Q63_Unique_PathsII;

import java.util.ArrayList;

public class Q980_Unique_PathsIII {

    int[] startPoint;
    int[] endPoint;
    int m;
    int n;
    int count;
    int[][] grid;


    public int uniquePathsIII(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        boolean[][] memo = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    startPoint = new int[]{i, j};
                }
                if (grid[i][j] == 2) {
                    endPoint = new int[]{i, j};
                }

                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        count++;
        return helper(startPoint[0], startPoint[1], 0,memo);
    }


    public int helper(int row, int col, int myCount, boolean[][] memo) {

        boolean[][] curMemmo = new boolean[m][n];

        for(int i=0 ; i< m; i++) {
            for (int j=0; j<n ; j++) {
                curMemmo[i][j] = memo[i][j];
            }
        }

        curMemmo[row][col] = true;

        System.out.println("Row :"+ row + "   "+ "Col :" + col);
        int sum = 0;

        if (grid[row][col] == -1 ) {
            return 0;
        }

        if (grid[row][col] == 2 ) {
             if (myCount == this.count) {return 1;}
             else {return 0;}
        }


        if( row+1 < m && curMemmo[row+1][col] == false ) {
            sum += helper(row + 1, col, ++myCount, curMemmo);
            myCount--;
        }

        if(row-1 >=0 && curMemmo[row-1][col] == false) {
            sum += helper(row - 1, col, ++myCount, curMemmo);
            myCount--;
        }

        if(col+1<n && curMemmo[row][col+1] == false) {
            sum += helper(row, col + 1, ++myCount, curMemmo);
            myCount--;
        }

        if(col-1 >=0 && curMemmo[row][col-1] == false) {
            sum += helper(row, col - 1, ++myCount, curMemmo);
            myCount--;
        }

        return sum;

    }


    public static void main(String args[]) {
        Q980_Unique_PathsIII app = new Q980_Unique_PathsIII();
        int[][] array = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}};

        int[][] array2 = new int[][]{
                {0,1},
                {2,0}
                };

        System.out.println(app.uniquePathsIII(array2));

    }
}

