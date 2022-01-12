package hot_100.t0106.construct_binary_tree_from_preorder_and_inorder_traversal;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 105. 从前序与中序遍历序列构造二叉树
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        // 打印后序遍历
        TreeNodeUtils.postOrder(buildTree(preorder, inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int p, int q) {
        if (i > j) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i]);

        int m;
        for (m = p; m <= q; m++) {
            if(inorder[m] == preorder[i]){
                break;
            }
        }

        int size = m - p;

        // preorder   i  m [  .left.  ] [  .right.  ]  j
        // inorder    p  [  .left.  ] m [  .right.  ]  q

        root.left = buildTree(preorder,i+1,i+size,inorder,p,m-1);
        root.right = buildTree(preorder,i+size+1,j,inorder,m+1,q);

        return root;
    }
}
