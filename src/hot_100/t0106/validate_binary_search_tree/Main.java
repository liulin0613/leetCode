package hot_100.t0106.validate_binary_search_tree;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * 98. 验证二叉搜索树
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] root = new Integer[]{2,2,null,null,2};
        TreeNode node = TreeNodeUtils.generateTree(root);
        System.out.println(isValidBST(node));
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        inOrder(root,order);
        for (int size = order.size()-1; size > 0; size--) {
            if(order.get(size) <= order.get(size - 1)){
                return false;
            }
        }
        return true;
    }

    private static void inOrder(TreeNode root, List<Integer> order) {
        if(root == null){
            return;
        }

        inOrder(root.left,order);
        order.add(root.val);
        inOrder(root.right,order);
    }

}
