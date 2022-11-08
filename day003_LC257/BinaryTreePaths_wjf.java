package day3_LC257;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname BinaryTreePaths_wjf
 * @Description
 * @Date 2022/11/3 20:07
 * @Created by wangjinfeng
 */
public class BinaryTreePaths_wjf {

    public List<String> binaryTreePaths(TreeNode root) {
        return getTreeStr(root, "", new ArrayList<String>());
    }

    public List<String> getTreeStr(TreeNode node, String str, List<String> result)  {
        if (node==null) {
            return result;
        }
        if (str.length()>0) {
            str = str + "->";
        }
        str = str + node.val;
        if (node.left==null&&node.right==null) {
            result.add(str);
            return result;
        }
        if (node.left!=null) {
            getTreeStr(node.left, str, result);
        }
        if (node.right!=null) {
            getTreeStr(node.right, str, result);
        }
        return result;
    }
}
