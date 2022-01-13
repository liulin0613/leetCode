package hot_100.t0113.diameter_of_binary_tree;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * 543. 二叉树的直径
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1,2,3,4,5};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        System.out.println(diameterOfBinaryTree(root));
    }

    static int len =  0;

    public static int diameterOfBinaryTree(TreeNode root) {
        backtrack(root);
        return len;
    }

    private static int backtrack(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = backtrack(root.left);
        int right = backtrack(root.right);

        len = Math.max(len,left + right);

        return Math.max(left,right) + 1;
    }
}
