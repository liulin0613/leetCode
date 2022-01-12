package hot_100.t0112.convert_bst_to_greater_tree;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * 538. 把二叉搜索树转换为累加树
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        TreeNodeUtils.layerOrder(convertBST(root));
    }

    /**
     * 回溯
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        backtrack(root);
        return root;
    }

    static int adder = 0;

    private static void backtrack(TreeNode root) {
        if(root == null){
            return;
        }


        backtrack(root.right);
        root.val = root.val + adder;
        adder = root.val;
        backtrack(root.left);
    }
}
