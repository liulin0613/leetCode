package sword_to_offer.t0301.cong_shang_dao_xia_da_yin_er_cha_shu_iii_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = {3,9,20,null,null,15,7};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean flag = true;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur != null){
                    list.add(cur.val);
                    if(cur.left != null) queue.offer(cur.left);
                    if(cur.right != null) queue.offer(cur.right);
                }
            }

            if(!flag){
                Collections.reverse(list);
            }

            flag = !flag;
            res.add(list);
        }

        return res;
    }
}
