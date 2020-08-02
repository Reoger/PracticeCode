package chapter5;

import common.ListNode;

/**
 * 两个链表的第一个公共节点
 *
 * @link {https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/}
 */

public class Question52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        int indexA = 0;
        int indexB = 0;
        while (a != null) {
            a = a.next;
            indexA++;
        }
        while (b != null) {
            b = b.next;
            indexB++;
        }
        a = headA;
        b = headB;
        int index = Math.abs(indexA - indexB);
        if (indexA > indexB) {
            for (int i = 0; i < index; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < index; i++) {
                b = b.next;
            }
        }
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headA : a.next;
            b = b == null ? headB : b.next;
        }
        return a;
    }
}
