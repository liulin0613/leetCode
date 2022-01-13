package hot_100.t0113.merge_two_binary_trees;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * 617. 合并二叉树
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes1 = new Integer[]{1,3,2,5};
        Integer[] nodes2 = new Integer[]{2,1,3,null,4,null,7};

        TreeNode root1 = TreeNodeUtils.generateTreeByLevel(nodes1);
        TreeNode root2 = TreeNodeUtils.generateTreeByLevel(nodes2);

        TreeNodeUtils.layerOrder(mergeTrees(root1,root2));
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);

        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);

        return merged;
    }
}
