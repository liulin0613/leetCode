package sword_to_offer.t0215.dui_cheng_de_er_cha_shu_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * 剑指 Offer 28. 对称的二叉树
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1,2,2,null,3,null,3};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return backtrack(root.left,root.right);
    }

    private static boolean backtrack(TreeNode left, TreeNode right) {
        if(left == right){
            return true;
        }

        if(left == null || right == null || left.val != right.val){
            return false;
        }

        return backtrack(left.left,right.right) && backtrack(left.right,right.left);
    }
}
