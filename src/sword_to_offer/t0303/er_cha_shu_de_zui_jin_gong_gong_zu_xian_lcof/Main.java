package sword_to_offer.t0303.er_cha_shu_de_zui_jin_gong_gong_zu_xian_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        TreeNode p = new TreeNode(7), q = new TreeNode(6);

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    static TreeNode res = null;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(root,p,q);
        return res;
    }

    private static boolean backtrack(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return false;

        boolean left = backtrack(root.left,p,q);
        boolean right = backtrack(root.right,p,q);

        if (left && right || ((root.val == p.val || root.val == q.val) && (left || right))) {
            res = root;
        }

        return root.val == p.val || root.val == q.val || left || right;
    }
}

