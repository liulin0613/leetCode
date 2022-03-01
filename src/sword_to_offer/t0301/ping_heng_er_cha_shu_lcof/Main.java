package sword_to_offer.t0301.ping_heng_er_cha_shu_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 *
 * 剑指 Offer 55 - II. 平衡二叉树
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = {3,null,20,null,null,15,7};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        System.out.println(isBalanced(root));
    }

    static boolean balance = true;
    public static boolean isBalanced(TreeNode root) {
        height(root);
        return balance;
    }

    private static int height(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        if(Math.abs(right - left) > 1){
            balance = false;
        }

        return Math.max(left,right) + 1;
    }
}
