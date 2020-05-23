package chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1 ~ n 整数中 1 出现的次数
 * link {https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6}
 */

public class Question43 {

    @Test
    public void test() {
        Assert.assertEquals(6, NumberOf1Between1AndN_Solution(13));
        Assert.assertEquals(1600, NumberOf1Between1AndN_Solution(2000));
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            count += (a + 8) / 10 * i + (a % 10 == 1 ? n % i + 1 : 0);
        }
        return count;
    }


    /**
     *
     * @param n the limit {1, n}
     * @param x only in {1, 9}
     * @return the x show count on {1, n}
     */
    public int NumverOfXBetween1AndN_Solution(int n, int x) {
        int count = 0;
        int diff = 9 - x;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i;
            count += (a + diff) / 10 * i + (a % 10 == x ? n % i + 1: 0);
        }
        return count;
    }

}
