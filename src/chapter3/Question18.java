package chapter3;

import common.ListNode;
import org.junit.Test;

/**
 * 删除链表的节点
 */

public class Question18 {

    @Test
    public void test() {
        ListNode listNode = getMockListNode();
        ListNode deleteNode = deleteNode(listNode, listNode.next);
        printfList(deleteNode);

        ListNode listNode2 = getMockListNode();
        ListNode deleteNode2 = deleteNode(listNode2, listNode2.next.next.next.next.next.next);
        printfList(deleteNode2);

    }

    private ListNode getMockListNode() {
        ListNode test1 = new ListNode(-1);
        ListNode temp = test1;
        int[] test = {1, 2, 3, 3, 4, 4, 5};
        for (int value : test) {
            ListNode tempNode = new ListNode(value);
            temp.next = tempNode;
            temp = tempNode;
        }

        return test1.next;
    }

    public void printfList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) {
                System.out.print(" , ");
            }
        }
        System.out.println();
    }

    public ListNode deleteNode(ListNode root, ListNode deleteNode) {
        if (root == null || deleteNode == null) {
            return null;
        }

        ListNode tempNode = deleteNode;
        if (tempNode.next != null) {
            tempNode.val = tempNode.next.val;
            tempNode.next = tempNode.next.next;
            return root;
        }

        if (root == deleteNode) {
            return null;
        }

        tempNode = root;
        while (tempNode != null && tempNode.next != deleteNode) {
            tempNode = tempNode.next;
        }
        tempNode.next = null;
        return root;
    }

    @Test
    public void test2() {
        ListNode listNode = getMockListNode();
        ListNode node = deleteDuplication(listNode);
        printfList(node);
    }

    /**
     * 删除链表中重复的节点
     *
     * @link {https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef}
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
     * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     */

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode resultNode = new ListNode(-1);
        resultNode.next = pHead;

        ListNode preNode = resultNode;
        ListNode curNode = pHead;
        ListNode nextNode = pHead.next;

        while (curNode != null) {
            if (nextNode != null && curNode.val == nextNode.val) {
                while (nextNode != null && curNode.val == nextNode.val) {
                    curNode = nextNode;
                    nextNode = curNode.next;
                }
                preNode.next = nextNode;
            } else {
                preNode = curNode;
            }
            curNode = nextNode;
            nextNode = curNode == null ? null : curNode.next;
        }

        return resultNode.next;
    }
}
