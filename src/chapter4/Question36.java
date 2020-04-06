package chapter4;

import common.TreeNode;
import org.junit.Test;

/**
 * 二叉搜索树与双向链表
 *
 * @link {https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5}
 */

public class Question36 {

    @Test
    public void test() {

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode node = convertCore(pRootOfTree);
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode preNode;

    private TreeNode convertCore(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }

        convertCore(pRoot.left);

        pRoot.left = preNode;

        if(preNode != null) {
            preNode.right = pRoot;
        }

        preNode = pRoot;
        convertCore(pRoot.right);

        return pRoot;
    }

}
