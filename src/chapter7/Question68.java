package chapter7;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;


/**
 * 1. 二叉搜索树的最近公共祖先
 *
 * @Link {https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/}
 *
 * 2. 二叉树的最近公共祖先
 * @Link {https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/}
 */
public class Question68 {

    @Test
    public void test() {
        TreeNode node = TreeNode.getMockTreeNode(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}, 0);
        Assert.assertEquals(6, lowestCommonAncestor(node, new TreeNode(2), new TreeNode(8)).val);
        Assert.assertEquals(2, lowestCommonAncestor(node, new TreeNode(2), new TreeNode(4)).val);

        Assert.assertEquals(2, lowestCommonAncestor2(node, new TreeNode(2), new TreeNode(5)).val);
        Assert.assertEquals(2, lowestCommonAncestor2(node, new TreeNode(2), new TreeNode(4)).val);
    }

    // 二叉搜索树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }


    // 普通的树
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            // 如果树为空，直接返回null
            return null;
        }
        if (root == p || root == q) {
            // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
            return root;
        }
        // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
            return right;
        } else if (right == null) {
            // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，
            // 如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
            return left;
        } else {
            return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
        }
    }

}
