package hot_100.t0109.lowest_common_ancestor_of_a_binary_tree;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 236. 二叉树的最近公共祖先
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        int pv = 5;
        int qv = 1;

        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);
        TreeNode p = new TreeNode(pv);
        TreeNode q = new TreeNode(qv);

        System.out.println(lowestCommonAncestor(root, p, q).val);

    }

    static TreeNode res = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtrack(root,p,q);
        return res;
    }


    /**
     * 从叶子节点开始往上标记 --> true or false
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static boolean backtrack(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return false;
        }

        boolean left = backtrack(root.left,p,q);
        boolean right = backtrack(root.right,p,q);

        if((left && right) || ((left || right) && (root.val == q.val || root.val == p.val))){
            res = root;
        }

        return  left || right || root.val == p.val || root.val == q.val;
    }
}
