package sword_to_offer.t0215.zhong_jian_er_cha_shu_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * 剑指 Offer 07. 重建二叉树
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        TreeNodeUtils.layerOrder(buildTree(preorder,inorder));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
       return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode build(int[] preorder, int i, int j, int[] inorder, int p, int q) {

        if(i > j){
            return null;
        }

        TreeNode root = new TreeNode(preorder[i]);

        int m = p;
        for(;m<=q;m++){
            if(inorder[m] == preorder[i]){
                break;
            }
        }

        int size = m - p;

        root.left = build(preorder,i+1,i+size,inorder,p,m-1);
        root.right = build(preorder,i+size+1,j,inorder,m+1,q);

        return root;
    }
}
