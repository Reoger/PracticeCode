package chapter3;

import common.ListNode;
import org.junit.Test;

/**
 * 反转链表
 *
 * @see {https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca}
 */

public class Question24 {

    @Test
    public void test() {
        int[] test = {1,2,3,4,5};
        ListNode node = ReverseList(ListNode.getMockListNode(test));
        ListNode.printfListNoe(node);
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        ListNode result = null;
        while (cur != null) {
            next = cur.next;
            if (cur.next == null) {
                result = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return result;
    }

}
