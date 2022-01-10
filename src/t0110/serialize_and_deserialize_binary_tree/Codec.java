package t0110.serialize_and_deserialize_binary_tree;

import utils.tree_node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * 297. 二叉树的序列化与反序列化
 * 困难
 *
 * @author liulin
 */
public class Codec {
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

    public static void main(String[] args) {

        Integer[] nodes = new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};

        StringBuilder sb = new StringBuilder();
        for (Integer node : nodes) {
            if(node != null){
                sb.append(node).append(",");
            }else {
                sb.append("null").append(",");
            }
        }

        Codec deser = new Codec();
        TreeNode root = deser.deserialize(sb.toString());

        Codec ser = new Codec();
        System.out.println(ser.serialize(root));

        deser.deserialize(ser.serialize(root));
    }
}
