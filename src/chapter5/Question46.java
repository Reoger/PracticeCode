package chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 把数字翻译成字符串
 *
 * @link {https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/}
 */


public class Question46 {

    @Test
    public void test() {
        Assert.assertEquals(5, translateNum(12258));
        Assert.assertEquals(2, translateNum(25));
        Assert.assertEquals(1, translateNum(0));
        Assert.assertEquals(2, translateNum(18580));
        Assert.assertEquals(2, translateNum(419605557));
    }


    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int begin = 1;
        int pre = begin;
        int total = begin;
        for(int i = 1; i < chars.length; i++) {
            if(chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '5')) {
                total = pre + begin;
            } else {
                total = pre;
            }

            begin = pre;
            pre = total;
        }

        return total;
    }

}
