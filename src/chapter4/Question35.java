package chapter4;

import org.junit.Test;

/**
 * 复杂链表的复制
 *
 * @link {https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba}
 */
public class Question35 {

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    @Test
    public void test() {
        RandomListNode head = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        head.random = node3;
        node1.random = null;
        node2.random = node3;
        node3.random = head;

        printf(head);
        RandomListNode a = Clone(head);
        System.out.println();
        printf(a);
        System.out.println(a == head);
    }

    private void printf(RandomListNode node) {
        while (node != null) {
            System.out.println(" node :" + node.label + " and random: " + (node.random == null ? null : node.random.label));
            node = node.next;
        }
    }


    /**
     * 三步：
     * 1. 复制相同的节点插入到原来的链表汇总
     * 2. 将 random 复制
     * 3。将链表查分成新的链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode listNode = pHead;
        RandomListNode tempNode;

        while (listNode != null) {
            RandomListNode copyNode = new RandomListNode(listNode.label);
            tempNode = listNode.next;
            listNode.next = copyNode;
            copyNode.next = tempNode;
            listNode = tempNode;
        }

        listNode = pHead;
        while (listNode != null) {
            tempNode = listNode.next;
            if (listNode.random != null) {
                tempNode.random = listNode.random.next;
            }
            listNode = tempNode.next;
        }

        RandomListNode result = pHead.next;

        listNode = pHead;

        while (listNode.next != null) {
            tempNode = listNode.next;

            listNode.next = tempNode.next;
            listNode = tempNode;

        }

        return result;
    }
}
