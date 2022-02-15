package sword_to_offer.t0215.shu_de_zi_jie_gou_lcof;

import utils.tree_node.TreeNode;
import utils.tree_node.TreeNodeUtils;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 *
 * 剑指 Offer 26. 树的子结构
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        //[4,2,3,4,5,6,7,8,9]
        //[4,8,9]

        //[1,0,1,-4,-3]
        //[1,-4]

        //A = [3,4,5,1,2], B = [4,1]

        Integer[] nodes1 = new Integer[]{4,2,3,4,5,6,7,8,9};
        Integer[] nodes2 = new Integer[]{4,8,9};

        TreeNode A = TreeNodeUtils.generateTreeByLevel(nodes1);
        TreeNode B = TreeNodeUtils.generateTreeByLevel(nodes2);

        System.out.println(isSubStructure(A, B));
        System.out.println(isSubStructure2(A, B));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }

        return backtrack(A,B,false);
    }

    private static boolean backtrack(TreeNode A, TreeNode B, boolean flag) {
        if(B == null) {
            return true;
        }

        if(A == null){
            return false;
        }

        if(A.val == B.val){
            return (backtrack(A.left,B.left,true) && backtrack(A.right,B.right,true))
                    || (backtrack(A.left,B,false) || backtrack(A.right,B,false));
        }else {
            if(flag){
                return false;
            }
            return backtrack(A.left,B,false) || backtrack(A.right,B,false);
        }
    }

    /**
     * 方法二
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure2(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private static boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
