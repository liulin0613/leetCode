package t0106.binary_tree_inorder_traversal;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * 94. 二叉树的中序遍历
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{};
        TreeNode root = TreeNodeUtils.generateTree(nums);
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        inOrder(root,result);
        return result;
    }

    private static void inOrder(TreeNode root, List<Integer> result) {
        if(root == null){
            return;
        }

        inOrder(root.left,result);
        result.add(root.val);
        inOrder(root.right,result);
    }


}
