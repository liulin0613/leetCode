package hot_100.t0106.symmetric_tree;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 101. 对称二叉树
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1,2,1};
        TreeNode root = TreeNodeUtils.generateTree(nodes);
        TreeNodeUtils.layerOrder(root);
        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left,root.right);
    }

    private static boolean check(TreeNode root, TreeNode root1) {
        if(root == root1){
            return true;
        }

        if(root == null || root1 == null){
            return false;
        }


        return root.val == root1.val && check(root.left,root1.right) && check(root.right,root1.left);
    }


}
