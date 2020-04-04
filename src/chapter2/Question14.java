package chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * 剪绳子
 * {@see https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8}
 * <p>
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 * <p>
 * 思路一：动态规划
 * 设当绳子长度为 n 时，得到的最大乘积为 f(n),有递推公式 f(n) = max( f(n - i) * f(i) ) 0<i<n
 * <p>
 * 思路二：贪心算法
 * 尽可能多得剪出长度为 3 的绳子，当且仅当绳子的长度为 4 时，需要把绳子剪乘两个长度为 2 的绳子
 */

public class Question14 {

    @Test
    public void test() {
        Assert.assertEquals(0, cutRope(0));
        Assert.assertEquals(18, cutRope(8));
        Assert.assertEquals(1, cutRope(2));
        Assert.assertEquals(4, cutRope(4));


        Assert.assertEquals(0, cutRope2(0));
        Assert.assertEquals(18, cutRope2(8));
        Assert.assertEquals(1, cutRope2(2));
        Assert.assertEquals(4, cutRope2(4));
    }

    public int cutRope(int target) {
        if (target <= 1) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }

        int[] dp = new int[target + 1];
        for (int i = 0; i < 4; i++) {
            dp[i] = i;
        }

        for (int i = 4; i <= target; i++) {
            dp[i] = getMaxValue(dp, i);
        }

        return dp[target];
    }

    private int getMaxValue(int[] dp, int length) {
        int maxValue = 0;
        for (int i = 1; i <= length; i++) {
            int temp = dp[i] * dp[length - i];
            if (temp > maxValue) {
                maxValue = temp;
            }
        }
        return maxValue;
    }

    public int cutRope2(int target) {
        if (target <= 1) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int timesOf3 = target / 3;
        if(timesOf3 * 3 + 1 == target){
            timesOf3--;
        }
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int) ((int)Math.pow(2, timesOf2) * Math.pow(3, timesOf3));
    }
}
