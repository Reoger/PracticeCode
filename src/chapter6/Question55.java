package chapter6;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 1. 二叉树的深度
 * @link {https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/}
 *
 * 2. 平衡二叉树
 * @link {https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/}
 */

public class Question55 {

    @Test
    public void testMaxDepth() {
        TreeNode node = TreeNode.getMockTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        Assert.assertEquals(3, maxDepth(node));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }

    @Test
    public void test() {
        TreeNode node1 = TreeNode.getMockTreeNode(new Integer[]{3,9,20,null,null,15,7}, 0);
        TreeNode node2 = TreeNode.getMockTreeNode(new Integer[]{1,2,2,3,3,null,null,4,4}, 0);
        Assert.assertTrue(isBalanced(node1));
        Assert.assertFalse(isBalanced(node2));

        Assert.assertTrue(isBalanced2(node1));
        Assert.assertFalse(isBalanced2(node2));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public boolean isBalanced2(TreeNode root) {
        return balancedCore(root) != -1;
    }

    private int balancedCore(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = balancedCore(root.left);
        if (left == -1) {
            return -1;
        }
        int right = balancedCore(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

}
