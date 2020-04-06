package chapter4;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 对称的二叉树
 *
 * @link {https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb}
 */
public class Question28 {

    @Test
    public void test() {
        Integer[] test1 = {8, 6, 6, 5, 7, 7, 5};
        Integer[] test2 = {8, 6, 9, 5, 7, 7, 5};

        Assert.assertTrue(isSymmetrical(TreeNode.getMockTreeNode(test1, 0)));
        Assert.assertFalse(isSymmetrical(TreeNode.getMockTreeNode(test2, 0)));

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        if (pRoot.left == null && pRoot.right == null) {
            return true;
        }

        if (pRoot.left != null && pRoot.right != null && pRoot.left.val == pRoot.right.val) {

            return isSymmetricalCore(pRoot.left, pRoot.right);
        }

        return false;
    }

    boolean isSymmetricalCore(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.val == right.val) {
            return isSymmetricalCore(left.left, right.right) && isSymmetricalCore(left.right, right.left);
        }

        return false;
    }

}
