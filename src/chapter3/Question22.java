package chapter3;

import common.ListNode;
import org.junit.Test;

/**
 * 链表中倒数的的k 个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @see {https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a}
 */

public class Question22 {

    @Test
    public void test() {
        int[] test = {1,2,3,4,5,6};
        ListNode root = ListNode.getMockListNode(test);
        ListNode node = FindKthToTail(root,6);

        ListNode.printfListNoe(node);
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tempNode = head;
        for (int i = 0; i < k; i++) {
            if (tempNode != null) {
                tempNode = tempNode.next;
            } else {
                return null;
            }
        }
        while (head != null) {
            if (tempNode == null) {
                return head;
            }
            head = head.next;
            tempNode = tempNode.next;
        }

        return null;
    }

}
