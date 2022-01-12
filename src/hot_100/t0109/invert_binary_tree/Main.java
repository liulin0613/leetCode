package hot_100.t0109.invert_binary_tree;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * 226. 翻转二叉树
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{4,2,7,1,3,6,9};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        TreeNodeUtils.layerOrder(root);
        TreeNodeUtils.layerOrder(invertTree(root));

    }

    /**
     * 递归
     * 0 ms  100.00%  35.7 MB 83.91%
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null){
            return root;
        }

        TreeNode left = null;
        TreeNode right = null;

        if(root.left == null){
            right = invertTree(root.right);
        }else if(root.right == null){
            left = invertTree(root.left);
        }else {
            left = invertTree(root.left);
            right = invertTree(root.right);
        }

        root.left = right;
        root.right = left;

        return root;
    }
}
