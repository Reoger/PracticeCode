package chapter3;

import common.ListNode;
import org.junit.Test;


/**
 * 链表中环的入口节点
 *
 * @see {https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4}
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 分三步来处理：
 * 1. 利用两个速度不一致的指针，当它们相遇时，说明链表上有环
 * 2. 在有环的情况下，在环内，循环一圈，获取当前环的长度 n
 * 3. 两个指针，一个先走环长度 n 步，另外一个指针慢走，等到他们相遇时，即时环的入口
 */
public class Question23 {

    @Test
    public void test() {
        int[] test = {1,2,3,4,5};
        ListNode root = ListNode.getMockListNode(test);
        root.next.next.next.next.next = root.next.next;
        ListNode result = EntryNodeOfLoop(root);
        System.out.println(result.val);
    }


    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        boolean haveCircle = false;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            if (p2.next != null) {
                p2 = p2.next.next;
            }
            if (p1 == p2) {
                haveCircle = true;
                break;
            }
        }

        if (!haveCircle) {
            return null;
        }

        int len = 1;
        p1 = p1.next;
        while (p1 != null && p1 != p2) {
            p1 = p1.next;
            len++;
        }

        p1 = pHead;
        p2 = pHead;
        for (int i = 0; i < len; i++) {
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }


}
