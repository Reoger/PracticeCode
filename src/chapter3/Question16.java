package chapter3;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数值的数组次方
 *
 * @see {https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00}
 * <p>
 * 需要考虑：
 * 1. 底数为 0 的情况
 * 2. 指数为 0，指数为负数，指数为整数
 */

public class Question16 {

    @Test
    public void test() {
        Assert.assertEquals(0, Power(0, 1),0.0001);
        Assert.assertEquals(4, Power(2, 2),0.0001);
        Assert.assertEquals(8, Power(2, 3),0.0001);
        Assert.assertEquals(-8, Power(-2, 3),0.0001);
        Assert.assertEquals(0.5, Power(2, -1),0.0001);
    }

    public double Power(double base, int exponent) {

        if (base == 0) {
            return 0;
        }

        if (exponent == 0) {
            return 1;
        }

        int exponentOfMath = Math.abs(exponent);
        double result = 1;
        // 可以利用递归减少乘法运算
        for (int i = 0; i < exponentOfMath; i++) {
            result *= base;
        }

        if (exponent < 0) {
            result = 1 / result;
        }

        return result;
    }

    /**
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public double Power2(double base, int n) {
        double res = 1, curr = base;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        } else {// n==0
            return 1;// 0的0次方
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1)
                res *= curr;
            curr *= curr;// 翻倍
            exponent >>= 1;// 右移一位
        }
        return n >= 0 ? res : (1 / res);
    }


}
