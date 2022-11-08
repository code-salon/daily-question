package day005_LC495;

/**
 * @Classname FindPoisonedDuration_wjf
 * @Description
 * @Date 2022/11/7 15:23
 * @Created by wangjinfeng
 */
public class FindPoisonedDuration_wjf {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i=0;i<timeSeries.length;i++) {
            if (i+1<timeSeries.length&&timeSeries[i]+duration-1>=timeSeries[i+1]) {
                sum = sum+(timeSeries[i+1]-timeSeries[i]);
            } else {
                sum = sum+duration;
            }
        }
        return sum;
    }
}
