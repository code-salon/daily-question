package day004_LC121;

/**
 * @Classname MaxProfit_wjf
 * @Description
 * @Date 2022/11/7 9:34
 * @Created by wangjinfeng
 */
public class MaxProfit_wjf {

    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i=0;i<prices.length-1;i++) {
            for (int j=i+1;j<prices.length;j++) {
                if (prices[i]<prices[j]&&(prices[j]-prices[i]>max)) {
                    max = prices[j]-prices[i];
                }
            }
        }
        return max;
    }

    public static int maxProfitV2(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i=0;i<prices.length;i++) {
            if (prices[i]<min) {
                min = prices[i];
            }else if (prices[i]-min>max) {
                max = prices[i]-min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("============"+i);
    }
}
