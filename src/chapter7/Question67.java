package chapter7;

import org.junit.Assert;
import org.junit.Test;

/**
 * 把字符串转换成整数
 *
 * @LINK {https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/}
 */
public class Question67 {

    @Test
    public void test() {
        Assert.assertEquals(4444, strToInt("+4444 aa"));
        Assert.assertEquals(-4444, strToInt("-4444 aa"));
    }

    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int res = 0;
        int maxValue = Integer.MAX_VALUE / 10;
        int i = 1;
        int sign = 1;
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') {
                break;
            }
            if (res > maxValue || res == maxValue && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}
