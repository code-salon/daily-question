package day009_LC64;

/**
 * @Classname MinPathSum_wjf
 * @Description
 * @Date 2022/11/11 10:33
 * @Created by wangjinfeng
 */
public class MinPathSum_wjf {

    public int minPathSum(int[][] grid) {
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (i==0&&j==0) {
                    grid[i][j]=grid[i][j];
                }
                if (i==0&&j!=0){
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                }
                if (i!=0&&j==0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                if (i!=0&&j!=0) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
