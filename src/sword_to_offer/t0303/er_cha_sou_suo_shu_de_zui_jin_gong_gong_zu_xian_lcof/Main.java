package sword_to_offer.t0303.er_cha_sou_suo_shu_de_zui_jin_gong_gong_zu_xian_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        TreeNode p = new TreeNode(0), q = new TreeNode(9);

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        if(cur.val < p.val && cur.val < q.val){
            cur = lowestCommonAncestor(cur.right,p,q);
        }else if(cur.val > p.val && cur.val > q.val){
            cur = lowestCommonAncestor(cur.left,p,q);
        }

        return cur;
    }
}
