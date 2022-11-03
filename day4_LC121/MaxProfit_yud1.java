package day4_LC121;

/**
 * @autor yud1
 * @date 2022/11/2 14:19
 */
public class MaxProfit_yud1 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        //卖出最大价格
        int maxPrice = 0;
        //最低价格
        int min = prices[0];
        for (int i=1; i< prices.length;i++){
            //此时的min表示前i-1天的最低价格，prices[i] - min表示在第i天卖出去的最大收益
            maxPrice = Math.max(maxPrice,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return maxPrice;
    }
}
