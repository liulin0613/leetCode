package hot_100.t0106.maximum_depth_of_binary_tree;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * 104. 二叉树的最大深度
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);
        TreeNodeUtils.layerOrder(root);
        System.out.println(maxDepth(root));
    }

    static int maxLen = 0;
    public static int maxDepth(TreeNode root) {
        getMaxDepth(root,0);
        return maxLen;
    }

    private static void getMaxDepth(TreeNode root,int len) {
        if(root == null){
            maxLen = Math.max(maxLen,len);
            return;
        }

        getMaxDepth(root.left,len+1);
        getMaxDepth(root.right,len+1);
    }
}
