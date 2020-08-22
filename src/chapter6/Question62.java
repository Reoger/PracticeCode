package chapter6;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 *
 * @link {https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/}
 */

public class Question62 {

    @Test
    public void test() {
        Assert.assertEquals(3, lastRemaining(5,3));
    }

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (m + index - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }

}
