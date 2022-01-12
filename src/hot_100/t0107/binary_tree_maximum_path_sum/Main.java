package hot_100.t0107.binary_tree_maximum_path_sum;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * 124. 二叉树中的最大路径和
 * 困难
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{-10,9,20,null,null,15,7};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);
        System.out.println(maxPathSum(root));
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        backtrack(root);
        return maxSum;
    }

    private static int backtrack(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftGain = Math.max(backtrack(root.left),0);
        int rightGain = Math.max(backtrack(root.right),0);

        int gain = leftGain + rightGain + root.val;
        maxSum = Math.max(maxSum,gain);

        return Math.max(leftGain,rightGain) + root.val;
    }


}
