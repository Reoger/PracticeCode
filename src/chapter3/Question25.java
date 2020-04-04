package chapter3;

import common.ListNode;
import org.junit.Test;

/**
 * 合并两个排序的链表
 *
 * @link {https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337}
 */


public class Question25 {

    @Test
    public void test() {
        int[] test1 = {1, 3, 5, 6, 9};
        int[] test2 = {2, 4, 6, 8, 10};
        ListNode result = Merge(ListNode.getMockListNode(test1), ListNode.getMockListNode(test2));
        ListNode.printfListNoe(result);
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            } else if (list2 == null) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        return result.next;

    }


}
