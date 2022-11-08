package day009_LC64;

/**
 * 64. 最小路径和
 *
 * @author zhayujie
 * @date 2022/11/8
 */
public class MinPathSum_yujie {
    public int minPathSum(int[][] grid) {
        // dp[i][j]定义：移动至坐标 i,j 时最小的路径和
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
