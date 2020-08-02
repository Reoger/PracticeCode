package common;


import org.junit.Test;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 构建二叉树
     */
    public static TreeNode getMockTreeNode(Integer[] array, int index) {
        TreeNode tn;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = getMockTreeNode(array, 2 * index + 1);
            tn.right = getMockTreeNode(array, 2 * index + 2);
            return tn;
        }
        return null;
    }

    public static void printfTree(TreeNode root) {
        if(root != null) {
            System.out.print(root.val + " -> ");
            printfTree(root.left);
            printfTree(root.right);
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tempNode = root;

        while (!stack.isEmpty()) {
            if (tempNode != null && tempNode.left != null) {
                stack.push(tempNode.left);
                tempNode = tempNode.left;
            } else {
                tempNode = stack.pop();
                System.out.print(tempNode.val + " -> ");

                if (tempNode.right != null) {
                    stack.push(tempNode.right);
                    tempNode = tempNode.right;
                } else {
                    tempNode = null;
                }
            }

        }
    }

}
