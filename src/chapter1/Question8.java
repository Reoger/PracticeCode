package chapter1;

import common.TreeLinkNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 二叉树的下一个节点
 * link:https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e
 */

public class Question8 {

    @Test
    public void test() {

        /**
         *    1
         *   / |
         *  2   3
         * / |
         * 4  5
         */
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode slave1 = new TreeLinkNode(2);
        TreeLinkNode slave2 = new TreeLinkNode(3);
        TreeLinkNode slave3 = new TreeLinkNode(4);
        TreeLinkNode slave4 = new TreeLinkNode(5);
        root.left = slave1;
        root.right = slave2;
        slave1.left = slave3;
        slave1.right = slave4;
        slave1.next = root;
        slave2.next = root;
        slave3.next = slave1;
        slave4.next = slave1;

        Assert.assertEquals(3, GetNext(root).val);
        Assert.assertEquals(5, GetNext(slave1).val);
        Assert.assertEquals(2, GetNext(slave3).val);
        Assert.assertEquals(1, GetNext(slave4).val);

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode tempNode = pNode.right;
        if (tempNode != null) {
            while (tempNode.left != null) {
                tempNode = tempNode.left;
            }
            return tempNode;
        }

        while (pNode.next != null) {
            tempNode = pNode.next;
            if (tempNode.left == pNode) {
                return tempNode;
            }
            pNode = pNode.next;
        }
        return null;
    }


}