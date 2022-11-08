package day002_LC171;

/**
 * @autor yud1
 * @date 2022/10/30 22:30
 */
public class TitleToNumber_yud1 {

    public  int titleToNumber(String columnTitle) {
        if(columnTitle == null || columnTitle.length() == 0) return 0;
        int len = columnTitle.length();
        int sum = 0 ;
        for (int i = 0; i < len; i++) {
            sum = sum * 26 +  (columnTitle.charAt(i) - 'A' + 1);
        }
        return sum;
    }
}
