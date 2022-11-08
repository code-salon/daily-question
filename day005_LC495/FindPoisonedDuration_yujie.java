package day005_LC495;

/**
 * 495. 提莫攻击
 *
 * @author zhayujie
 * @date 2022/11/3
 */
public class FindPoisonedDuration_yujie {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            // 取 两次施放间隔 和 持续时间 的较小值
            sum += Math.min(timeSeries[i] - timeSeries[i-1], duration);
        }
        sum += duration;
        return sum;
    }
}
