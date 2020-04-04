package chapter1;

import common.TreeNode;
import org.junit.Test;

/**
 * 重建二叉树
 * link:https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6
 */

public class Question7 {

    @Test
    public void test() {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        TreeNode node = reConstructBinaryTree(pre, in);
        printfTree(node);
    }

    private void printfTree(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.println(node.val);
        printfTree(node.left);
        printfTree(node.right);
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length == 0 || in.length == 0) {
            return null;
        }

        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int[] in, int preStart, int preEnd,
                                           int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        if(preStart == preEnd && inStart == inEnd) {
            return root;
        }
        int index = inStart;
        while (index <= inEnd && in[index] != root.val)
            index++;
        int length = index - inStart;
        root.left = reConstructBinaryTree(pre, in, preStart + 1, preStart + length, inStart, index - 1);
        root.right = reConstructBinaryTree(pre, in, preStart + length + 1, preEnd, index + 1, inEnd);

        return root;
    }
}
