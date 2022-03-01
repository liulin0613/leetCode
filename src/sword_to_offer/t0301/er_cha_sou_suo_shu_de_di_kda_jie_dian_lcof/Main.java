package sword_to_offer.t0301.er_cha_sou_suo_shu_de_di_kda_jie_dian_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 简单
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = {3,1,4,null,2};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);
        int k = 1;

        System.out.println(kthLargest(root,k));
    }

    public static int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);

        return list.get(list.size() - k);
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
