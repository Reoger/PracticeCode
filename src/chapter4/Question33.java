package chapter4;

import org.junit.Assert;
import org.junit.Test;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @link {https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd}
 */

public class Question33 {


    @Test
    public void test() {
        int[] test1 = {5, 7, 6, 9, 11, 10, 8};
        int[] test2 = {7, 4, 6, 5};
        Assert.assertTrue(VerifySquenceOfBST(test1));
        Assert.assertFalse(VerifySquenceOfBST(test2));
    }


    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verifyCore(sequence,0 , sequence.length - 1);
    }

    private boolean verifyCore(int[] data, int start, int end) {
        if(start >= end) {
            return true;
        }
        int index = end - 1;
        while (index >= start && data[index] > data[end]) {
            index--;
        }
        for (int i = start; i < index; i++) {
            if (data[i] > data[end]) {
                return false;
            }
        }

        return verifyCore(data,start, index) && verifyCore(data, index + 1, end - 1);
    }

}
