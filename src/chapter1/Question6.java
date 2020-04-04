package chapter1;

import common.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 从头到尾打印链表
 * link:https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035
 */

public class Question6 {

    @Test
    public void test() {
        int[] listData = {1,2,3,4,5,6};
        ListNode head = new ListNode(-1);
        ListNode tempData = head;
        for (int i = 0; i < listData.length; i++) {
            ListNode temp = new ListNode(listData[i]);
            tempData.next = temp;
            tempData = temp;
        }


        List<Integer> mockResult = new ArrayList<>();
        for (int i = listData.length -1 ; i >= 0 ; i--) {
            mockResult.add(listData[i]);
        }
        ArrayList result = printListFromTailToHead(head.next);
        ArrayList result2 = printListFromTailToHead2(head.next);

        Assert.assertEquals(mockResult, result);
        Assert.assertEquals(mockResult, result2);
    }

    //可以先将链表存放到栈中，然后将栈中的元素依次弹出
    //时间复杂度 O(n),空间复杂度 O(n)
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if(listNode == null) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

    ArrayList<Integer> result = new ArrayList<>();

    //方法2：利用递归来实现栈的效果
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return null;
        }

        printListFromTailToHead2(listNode.next);
        result.add(listNode.val);
        return result;
    }

}
