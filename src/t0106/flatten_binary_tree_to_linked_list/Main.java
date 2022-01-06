package t0106.flatten_binary_tree_to_linked_list;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * 114. 二叉树展开为链表
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1,2,5,3,4,null,6};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);
        flatten(root);
        TreeNodeUtils.inOrder(root);
    }

    static TreeNode newNode = new TreeNode(-1);

    public static void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode s = newNode;
        preOrder(root);

        root.right = s.right.right;
        root.left = null;
    }

    private static void preOrder(TreeNode root) {
        if(root == null){
            return;
        }

        newNode.left = null;
        newNode.right = new TreeNode(root.val);
        newNode = newNode.right;

        preOrder(root.left);
        preOrder(root.right);
    }
}
