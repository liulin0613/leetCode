package sword_to_offer.t0301.er_cha_sou_suo_shu_de_hou_xu_bian_li_xu_lie_lcof;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 中等
 *
 * @author liulin
 */
public class Main {
    public static void main(String[] args) {
        int[] postorder = {4, 8, 6, 12, 16, 14, 10};

        System.out.println(verifyPostorder(postorder));
    }

    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length - 1);
    }

    private static boolean recur(int[] postorder, int start, int end) {
        if(start > end){
            return true;
        }

        int idx = start;
        while (postorder[idx] < postorder[end]){
            idx ++;
        }

        int m = idx;

        while (postorder[idx] > postorder[end]){
            idx++;
        }

        return idx == end && recur(postorder,start,m-1) && recur(postorder,m,end-1);
    }
}
