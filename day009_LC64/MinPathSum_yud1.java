package day009_LC64;

/**
 * @autor yud1
 * @date 2022/11/6 10:09
 */
public class MinPathSum_yud1 {


    /**
     *     //行数
     *     public int m;
     *
     *     //列数
     *     public int n;
     */

    /**
     * 利用动态规划的思想解决
     * dp[i][j]:表示走到grid[i][j]的最小路径和
     * 递推公式：
     *       dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
     * 特殊值：
     *       第一行和第一列 只能从从左往右和从上往下走
     *       dp[i][0] = dp[i-1][0] + grid[i][0];
     *       dp[0][i] = dp[0][i-1] + grid[0][i];
     */
    public int minPathSum(int[][] grid) {
        //行数
        int m =  grid.length;
        //列数
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //处理第一列
        for(int i = 1; i < m ; i ++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //处理第一行
        for(int i = 1; i < n ; i ++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }


    /**
     *     递归会栈溢出
     * public int minPathSum(int[][] grid, int i , int j){
     *         if (i == m-1 && j == n-1) {
     *             return grid[i][j];
     *         }else if(i == m-1){
     *             return grid[i][j] + minPathSum(grid,i,j+1);
     *         } else if (j== n-1) {
     *             return grid[i][j] + minPathSum(grid,i,j+1);
     *         }else {
     *             return Math.min(minPathSum(grid,i,j+1), minPathSum(grid,i,j+1)) + grid[i][j];
     *         }
     *     }
     */
}
