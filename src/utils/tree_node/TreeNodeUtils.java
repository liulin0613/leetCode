package utils.tree_node;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNodeUtils {
    static int index;

    public static TreeNode generateTree(Integer[] arr) {
        if(arr.length<1){
            return null;
        }
        return createTree(arr);
    }

    // 递归建立二叉树
    public static TreeNode createTree(Integer[] arr) {
        TreeNode node = null;
        if(index < arr.length){
            if (arr[index] == null) {
                index++;
                return null;
            }
            node = new TreeNode(arr[index]);
            index++;
            node.left = createTree(arr);
            node.right = createTree(arr);
        }
        return node;
    }

    //前序遍历
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            preOrder(root.left);
            System.out.print(root.val + " ");
            preOrder(root.right);
        }
    }

    //后序遍历
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void layerOrder(TreeNode root){
        System.out.print("layer order : ");
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode temp = queue.peek();
            if(temp.left != null){
                queue.offer(temp.left);
            }

            if(temp.right!=null){
                queue.offer(temp.right);
            }

            TreeNode node = queue.poll();
            if(node!=null){
                System.out.print(node.val+" ");
            }else {
                System.out.print("null ");
            }
        }

        System.out.println();
    }
}
