package day4_LC121;

/**
 * 进步抱告 121. 买卖股票的最佳时机
 *
 * @author zhayujie
 * @date 2022/11/2
 */
public class MaxProfit_yujie {
    /**
     * 动态规划解法
     *
     * dp[i]定义: 截止到第i天，能赚到的最大金额
     * 递推公式: dp[i] = (prices[i] - min) > dp[i-1] ? (prices[i] - min) : dp[i - 1]
     *
     * PS.这里都定义min了，感觉用dp有点牵强
     */
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = (prices[i] - min) > dp[i-1] ? (prices[i] - min) : dp[i - 1];
            min = Math.min(min, prices[i]);
        }
        return dp[prices.length-1];
    }

    /**
     * 普通解法：本质是求 最高点 - 最低点
     */
    public int maxProfitNormal(int[] prices) {
        // 当前最低点
        int min = prices[0];
        // 当前最大差距
        int maxDiff = 0;
        for (int i = 1; i < prices.length; i++) {
            // 可优化成 Math.max/min
            min = prices[i] < min ? prices[i] : min;
            int diff = prices[i] - min;
            maxDiff = diff > maxDiff ? diff : maxDiff;
        }
        return maxDiff;
    }
}
