package t0111.house_robber_iii;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 *
 * 337. 打家劫舍 III
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{3,4,5,1,3,null,1};

        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);
        System.out.println(rob(root));
        System.out.println(rob2(root));
        System.out.println(rob3(root));

    }

    /**
     * 暴力枚举
     * @param root
     * @return
     */
    public static int rob(TreeNode root) {
        if(root == null){
            return 0;
        }

        int money = root.val;

        if(root.left != null){
            money += rob(root.left.left) + rob(root.left.right);
        }

        if(root.right != null){
            money += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(money,rob(root.left) + rob(root.right));
    }

    /**
     * 记忆化
     * 使用 HashMap 存储
     * @param root
     * @return
     */
    public static int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return robInternal(root, memo);

    }

    private static int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if(root == null){
            return 0;
        }

        if(memo.containsKey(root)) return memo.get(root);

        int money = root.val;

        if(root.left != null){
            money += robInternal(root.left.left,memo) + robInternal(root.left.right,memo);
        }

        if(root.right != null){
            money += robInternal(root.right.left,memo) + robInternal(root.right.right,memo);
        }

        int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
        memo.put(root, result);

        return result;
    }

    /**
     * 动态规划
     * @param root
     * @return
     */
    public static int rob3(TreeNode root) {
        int[] result = backtrack(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] backtrack(TreeNode root) {
        if(root == null){
            return new int[2];
        }

        int[] left = backtrack(root.left);
        int[] right = backtrack(root.right);

        int[] result = new int[2];
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
