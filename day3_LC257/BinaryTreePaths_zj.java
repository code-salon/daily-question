package day3_LC257;

import java.util.*;

/**
 * @autor zj
 * @date 2022/11/08 10:12
 */
public class BinaryTreePaths_zj {
    /*--------------------------------------------递归做法----------------------------------------*/
    public List<String> binaryTreePaths(TreeNode root) {
        return getTreeStr(root, "", new ArrayList<String>());
    }

    //str需要不断拼接所以要作为入参
    public List<String> getTreeStr(TreeNode currentNode, String str, List<String> treeStr) {
        if (currentNode == null) {
            return treeStr;
        }
        if (str != null && str.length() > 0) {
            str += "->";
        }
        str = str + currentNode.val;
        if (currentNode.left == null && currentNode.right == null) {
            //叶子节点终止
            treeStr.add(str);
        }
        if (currentNode.left != null) {
            getTreeStr(currentNode.left, str, treeStr);
        }
        if (currentNode.right != null) {
            getTreeStr(currentNode.right, str, treeStr);
        }
        return treeStr;
    }

    /*---------------------------------------非递归做法-----------------------------------------*/
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> treeStr = new ArrayList<>();
        //存储分支节点 需要先进后出 起到栈的作用
        LinkedList<TreeNode> branchNode = new LinkedList<>();
        //存储分支节点的历史路径
        Map<TreeNode,String> historyMap = new HashMap<>();
        TreeNode currentNode = root;
        if (root == null) {
            return treeStr;
        }
        String str = "";
        while (branchNode.size() != 0 || currentNode != null) {
            if (str.length() > 0) {
                str = str + "->";
            }
            str += currentNode.val;
            if (currentNode.right != null && currentNode.left != null) {
                //规定存储右节点 遍历左节点
                branchNode.add(currentNode.right);
                historyMap.put(currentNode.right,str);//存储当前右节点  历史路径
                currentNode = currentNode.left;
            } else if (currentNode.right != null && currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null && currentNode.left != null) {
                currentNode = currentNode.left;
            } else {
                //为叶子节点 取上一个分支节点
                treeStr.add(str);
                //获取历史路径接着遍历
                currentNode = branchNode.pollLast();
                str = historyMap.get(currentNode);
            }
        }
        return treeStr;
    }


}
