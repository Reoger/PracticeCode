package leetcode;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 对称二叉树
 *
 * @link {https://leetcode-cn.com/problems/symmetric-tree/}
 */
public class Question101 {

    @Test
    public void test() {
        Integer[] a = {1, 2, 2, 3, 4, 4, 3};
        TreeNode node = TreeNode.getMockTreeNode(a, 0);
        Assert.assertTrue(isSymmetric(node));
        Assert.assertTrue(isSymmetric2(node));
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(left);
        stack.add(right);
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            if (right == null && left == null) {
                continue;
            } else if ((right == null || left == null) || right.val != left.val) {
                return false;
            }

            stack.add(left.left);
            stack.add(right.right);
            stack.add(left.right);
            stack.add(right.left);
        }

        return left == null && right == null;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        } else if (root.left.val == root.right.val) {
            return isSymmetricCore(root.left, root.right);
        }

        return false;
    }

    private boolean isSymmetricCore(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricCore(left.left, right.right) && isSymmetricCore(left.right, right.left);
    }

}
