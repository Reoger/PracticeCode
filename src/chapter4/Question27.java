package chapter4;

import common.TreeNode;
import org.junit.Test;

/**
 * 二叉树的镜像
 *
 * @link {https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011}
 */

public class Question27 {

    @Test
    public void test() {
        Integer[] test = {8, 6, 10, 5, 7, 9, 11};
        TreeNode root = TreeNode.getMockTreeNode(test, 0);
        Mirror(root);
        TreeNode.printfTree(root);

    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        Mirror(root.left);
        Mirror(root.right);
    }


}
