package utils.list_node;

public class ListNodeUtils {
    public static ListNode generateListNode(int[] arr) {
        if(arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode next = head;
        for (int i = 1; i < arr.length; i++) {
            next.next = new ListNode(arr[i]);
            next = next.next;
        }
        next.next = null;

        return head;
    }

    public static void iteratorListNode(ListNode l1) {
        while (l1!=null){
            System.out.print(l1.val + " --> ");
            l1 = l1.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void generateCycle(ListNode head,int pos){
        if(pos != -1){
            // 通过 pos 构建环
            ListNode bf = head;
            int index = 0;

            ListNode cycleNode = null;
            while (bf!=null){
                if(index == pos){
                    cycleNode = bf;
                }

                if(bf.next == null){
                    bf.next = cycleNode;
                    break;
                }

                bf = bf.next;
                index++;
            }
        }
    }

    public static ListNode[] generateIntersectionList(int[] listA, int[] listB, int skipA, int skipB) {
        ListNode h1 = new ListNode(-1);
        ListNode ph1 = h1;
        for (int i = 0; i < skipA; i++) {
            ph1.next = new ListNode(listA[i]);
            ph1 = ph1.next;
        }

        ListNode h2 = new ListNode(-1);
        ListNode ph2 = h2;
        for (int i = 0; i < skipB; i++) {
            ph2.next = new ListNode(listB[i]);
            ph2 = ph2.next;
        }

        for (int i = skipA; i < listA.length; i++) {
            ListNode node = new ListNode(listA[i]);
            ph1.next = node;
            ph1 = ph1.next;

            ph2.next = node;
            ph2 = ph2.next;
        }

        return new ListNode[]{h1.next,h2.next};

    }
}
