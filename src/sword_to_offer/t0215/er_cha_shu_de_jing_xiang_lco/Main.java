package sword_to_offer.t0215.er_cha_shu_de_jing_xiang_lco;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * 剑指 Offer 27. 二叉树的镜像
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{4,2,7,1,3,6,9};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        TreeNodeUtils.layerOrder(mirrorTree(root));
        TreeNodeUtils.layerOrder(mirrorTree2(root));
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode root1 = new TreeNode(root.val);
        backtrack(root,root1);
        return root1;
    }

    private static void backtrack(TreeNode root, TreeNode root1) {
        if(root == null){
            return;
        }

        root1.left = root.right == null ? null : new TreeNode(root.right.val);
        root1.right = root.left == null ? null : new TreeNode(root.left.val);

        backtrack(root.left,root1.right);
        backtrack(root.right,root1.left);
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
