package sword_to_offer.t0301.er_cha_shu_zhong_he_wei_mou_yi_zhi_de_lu_jing_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 *
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = {5,4,8,11,null,13,4,7,2,null,null,null,null,5,1};
        int target = 22;

        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);
        System.out.println(pathSum(root, target));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        backtrack(res,root,new ArrayList<>(),target);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, TreeNode root, ArrayList<Integer> temp, int target) {
        if(root == null || target < 0) return;

        temp.add(root.val);
        target -= root.val;

        if(root.left == null && root.right ==null && target == 0){
            res.add(new ArrayList<>(temp));
        }

        backtrack(res,root.left,temp,target);
        backtrack(res,root.right,temp,target);

        temp.remove(temp.size() - 1);
    }
}
