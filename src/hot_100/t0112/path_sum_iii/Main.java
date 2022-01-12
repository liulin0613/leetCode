package hot_100.t0112.path_sum_iii;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 *
 * 437. 路径总和 III
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1};
        int targetSum = 1;
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        System.out.println(pathSum(root, targetSum));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        int res = backtrack(root,targetSum);
        res += pathSum(root.left,targetSum);
        res += pathSum(root.right,targetSum);

        return res;
    }

    /**
     * 回溯
     * @param root
     * @param targetSum
     * @return
     */
    private static int backtrack(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        int res = 0;

        int val = root.val;
        if (val == targetSum) {
            res++;
        }

        res += backtrack(root.left, targetSum - val);
        res += backtrack(root.right, targetSum - val);

        return res;
    }

}
