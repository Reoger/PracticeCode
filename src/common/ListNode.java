package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printfListNoe(ListNode root) {
        System.out.println("=========start=============");
        while (root != null) {
            System.out.print(root.val);
            root = root.next;
            if (root != null) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
        System.out.println("=========end============");
    }


    public static ListNode getMockListNode(int[] nums) {
        ListNode test1 = new ListNode(-1);
        ListNode temp = test1;
        for (int value : nums) {
            ListNode tempNode = new ListNode(value);
            temp.next = tempNode;
            temp = tempNode;
        }

        return test1.next;
    }



}
