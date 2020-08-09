package leetcode;

import common.TreeNode;
import org.junit.Test;


/**
 * 二叉树展开为链表
 * @link {https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/}
 *
 */
public class Question114 {

    @Test
    public void test() {
        TreeNode node = TreeNode.getMockTreeNode(new Integer[]{1, 2, 5, 3, 4, null, 6}, 0);
        flatten(node);
       while (node != null) {
           System.out.print(node.val + " -> ");
           node = node.right;
       }
    }


    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

}
