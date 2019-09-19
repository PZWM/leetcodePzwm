package cn.uuusee.pzwm.utils;

import cn.uuusee.pzwm.structure.ListNode;

import java.util.List;

public class PrintUtils {
    public static void printList(List list){
        boolean first=true;
        for(Object o:list) {
            if(first){
                System.out.println("");
                first=false;
            }else{
                System.out.print(",");
            }
            System.out.print(o);
        }
    }

    /**
     * 打印单项链表
     * @param l 单项链表第一个值
     */
    public static void printListNode(ListNode l) {
        System.out.print(l.val);
        while (l.next!=null){
            l=l.next;
            System.out.print("->");
            System.out.print(l.val);
        }
    }
}
