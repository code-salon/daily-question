package day005_LC495;
/**
 * @autor yud1
 * @date 2022/11/3 11:04
 */
public class FindPoisonedDuration_yud1 {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                ans += duration;
            } else {
                ans += timeSeries[i + 1] - timeSeries[i];
            }
        }
        return ans + duration;
    }
}
