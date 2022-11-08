package day007_LC22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * @author zhayujie
 * @date 2022/11/7
 */
public class GenerateParenthesis_yujie {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 深度优先搜索
        generateParenthesisCore(n, n, "", res);
        return res;
    }

    private void generateParenthesisCore(int left, int right, String stack, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(stack);
            return;
        }
        // 通过递归调用进行回溯
        if (left > 0) {
            generateParenthesisCore(left-1, right, stack + "(", res);
        }
        if (right > left) {
            generateParenthesisCore(left, right-1, stack + ")", res);
        }
    }
}
