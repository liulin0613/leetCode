package sword_to_offer.t0303.cong_shang_dao_xia_da_yin_er_cha_shu_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * 面试题32 - I. 从上到下打印二叉树
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = {3,9,20,null,null,15,7};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);

        System.out.println(Arrays.toString(levelOrder(root)));
    }

    public static int[] levelOrder(TreeNode root) {
        if(root == null) return new int[]{};

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if(temp.left != null){
                queue.offer(temp.left);
            }

            if(temp.right != null){
                queue.offer(temp.right);
            }
        }

        int[] res = new int[list.size()];
        int idx = 0;
        for (Integer integer : list) {
            res[idx++] = integer;
        }

        return res;
    }
}
