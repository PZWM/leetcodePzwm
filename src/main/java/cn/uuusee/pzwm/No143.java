package cn.uuusee.pzwm;

import cn.uuusee.pzwm.structure.ListNode;
import cn.uuusee.pzwm.utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

public class No143 {
    /*
    * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public static void main(String[] args) {
        Solution143 solution = new Solution143();
        ListNode l = create(1, 2, 3, 4, 5);
        solution.reorderList(l);
        PrintUtils.printListNode(l);
    }

    private static ListNode create(int... a) {
        ListNode re = null;
        ListNode listNode = null;
        for (int i : a) {
            ListNode listNode1 = new ListNode(i);

            if (listNode != null)
                listNode.next = listNode1;
            listNode = listNode1;
            if (re == null)
                re = listNode;

        }
        return re;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution143 {
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode f = head;
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        while (head.next != null) {
            head = head.next;
            list.add(0, head);
        }
        int process = list.size() / 2;
        ListNode next = null;
        while (process > 0) {
            next = f.next;
            f.next = list.get(0);
            list.remove(0);
            f.next.next = next;
            f = next;
            process--;
        }
        f.next=null;
    }
}
