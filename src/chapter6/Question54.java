package chapter6;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 二叉搜索树的第k大节点
 *
 * @link {https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/}
 */

public class Question54 {

    @Test
    public void test() {

        TreeNode node = TreeNode.getMockTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1}, 0);
        Assert.assertEquals(4, kthLargest(node,3));

    }

    public int kthLargest(TreeNode root, int k) {
        TreeNode node = root;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(node);
        while (!list.isEmpty()) {
            if (node != null && node.right != null) {
                node = node.right;
                list.push(node);
            } else {
                node = list.pop();
                k--;
                if (k == 0) {
                    return node.val;
                }

                if (node.left != null) {
                    node = node.left;
                    list.push(node);
                } else {
                    node = null;
                }
            }
        }
        return 0;
    }


}
