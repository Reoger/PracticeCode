package chapter3;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 树的子结构
 *
 * @link {https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88}
 * <p>
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

public class Question26 {

    @Test
    public void test() {
        Integer[] test1 = {1, 2, 3, 4, 5, 6, 7};
        Integer[] test2 = {2, 4, 5};
        Integer[] test3 = {1, 2, 4};
        TreeNode root1 = TreeNode.getMockTreeNode(test1, 0);
        TreeNode root2 = TreeNode.getMockTreeNode(test2, 0);
        TreeNode root3 = TreeNode.getMockTreeNode(test3, 0);
        Assert.assertTrue(HasSubtree(root1, root2));
        Assert.assertFalse(HasSubtree(root1, root3));
    }


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val == root2.val && hasSubTreeCore(root1, root2)) {
            return true;
        }

        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean hasSubTreeCore(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return hasSubTreeCore(root1.left, root2.left) && hasSubTreeCore(root1.right, root2.right);
        }
        return false;
    }


}
