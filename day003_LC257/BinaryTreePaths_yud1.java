package day003_LC257;
import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor yud1
 * @date 2022/10/31 19:45
 */
public class BinaryTreePaths_yud1 {

    List<String> list = null;
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) return list;
        binaryTreePaths(root,"");
        return list;
    }


    public void binaryTreePaths(TreeNode root, String val) {
        if (val != ""){
            val = val + "->";
        }
        val += root.val;
        if(root.left == null && root.right == null){
            list.add(val);
            return;
        }
        if (root.left!=null){
            binaryTreePaths(root.left,val);
        }

        if (root.right!=null){
            binaryTreePaths(root.right, val);
        }
    }
}
