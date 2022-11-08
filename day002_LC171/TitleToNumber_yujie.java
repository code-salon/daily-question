package day002_LC171;

/**
 * 171. Excel 表列序号
 *
 * @author zhayujie
 * @date 2022/10/30
 */
public class TitleToNumber_yujie {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (char ch : columnTitle.toCharArray()) {
            sum = sum * 26 + ((ch - 'A') + 1);
        }
        return sum;
    }
}
