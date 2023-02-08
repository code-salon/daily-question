public class LongestConsecutive_wjf {

    public int longestConsecutive(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        Set<Integer> numsSet = new HashSet<Integer>();
        for (int num:nums) {
            numsSet.add(num);
        }
        int maxLength=0;
        for (int num:nums) {
            if (!numsSet.contains(num-1)) {
                int tempLength = 0;
                while (numsSet.contains(num+1)) {
                    tempLength+=1;
                    num+=1;
                }
                maxLength = Math.max(maxLength, tempLength);
            }
        }
        return maxLength;
    }
}
