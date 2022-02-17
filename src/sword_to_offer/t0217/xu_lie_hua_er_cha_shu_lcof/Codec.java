package sword_to_offer.t0217.xu_lie_hua_er_cha_shu_lcof;

import utils.tree_node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 *
 * 剑指 Offer 37. 序列化二叉树
 * 困难
 *
 * @author liulin
 */
public class Codec {
    public static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                sb.append("null").append(",");
            }else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if(nodes[0].equals("null")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                continue;
            }

            cur.left = index >= nodes.length || nodes[index].equals("null") ? null : new TreeNode(Integer.parseInt(nodes[index]));
            cur.right = index+1 >= nodes.length || nodes[index+1].equals("null") ? null : new TreeNode(Integer.parseInt(nodes[index+1]));

            index += 2;

            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        return root;
    }
}
