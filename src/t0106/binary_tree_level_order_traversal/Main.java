package t0106.binary_tree_level_order_traversal;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * 102. 二叉树的层序遍历
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nodes = new Integer[]{1,2,3,4,5};
        TreeNode root = TreeNodeUtils.generateTreeByLevel(nodes);
        TreeNodeUtils.layerOrder(root);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);

        while (!nodes.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int levelCount = nodes.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode temp = nodes.poll();
                if(temp!=null){
                    level.add(temp.val);

                    if(temp.left!=null){
                        nodes.offer(temp.left);
                    }

                    if(temp.right!=null){
                        nodes.offer(temp.right);
                    }
                }
            }

            res.add(level);
        }
        return res;
    }
}
