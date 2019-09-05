package cn.uuusee.pzwm;

public class num2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=l1;
        int index = 0;
        ListNode l1Pre = null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                l1 = new ListNode(0);
                l1Pre.next = l1;
            }
            l1.val = (l2 != null ? l2.val : 0) + l1.val+index;
            if (l1.val > 9) {
                index = 1;
                l1.val -= 10;
            } else
                index = 0;
            l1Pre = l1;
            if (l1.next != null)
                l1 = l1.next;
            else l1 = null;
            if (l2.next != null)
                l2 = l2.next;
            else
                l2 = null;

        }
        if(index>0)
            l1Pre.next=new ListNode(index);
        return result;
    }


    /**
     * (2 -> 4 -> 3) + (5 -> 6 -> 4)
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        ListNode a = addTwoNumbers(l1, l2);
        while (a.next != null) {
            System.out.print(a.val + "->");
            a = a.next;
        }
    }

    static
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
