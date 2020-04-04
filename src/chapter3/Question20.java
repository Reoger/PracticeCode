package chapter3;

import org.junit.Assert;
import org.junit.Test;

/**
 * 表示数字的字符串
 *
 * @see {https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2}
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * <p>
 * A[.BeC]
 * A、C 是带符号的数字,其中A可以为空
 * B 是不带符号的数字
 */

public class Question20 {

    @Test
    public void test() {
        Assert.assertTrue(isNumeric("+12.9e3".toCharArray()));
        Assert.assertTrue(isNumeric("+12.9e-3".toCharArray()));
        Assert.assertTrue(isNumeric("+12.09e-3".toCharArray()));
        Assert.assertTrue(isNumeric("123".toCharArray()));
        Assert.assertTrue(isNumeric("3e4".toCharArray()));
        Assert.assertTrue(isNumeric("3e-4".toCharArray()));
        Assert.assertTrue(isNumeric("-1E-16".toCharArray()));
        Assert.assertTrue(isNumeric("-123".toCharArray()));
        Assert.assertTrue(isNumeric("-.123".toCharArray()));

        Assert.assertFalse(isNumeric("12e+4.3".toCharArray()));
        Assert.assertFalse(isNumeric("+-5".toCharArray()));
        Assert.assertFalse(isNumeric("12e".toCharArray()));
    }


    // 从整体上去考虑。

    /**
     * 特征：
     * 1. 小数点只能出现一次，必须出现在 e 之前
     * 2. e 或者 E 后面必须加上数字，只能出现一次。
     * 3. 小数点只能出现一次，不能出现在 e 之后，
     * 4. 符号最多可以出现两次，在不是出现在字符串的第一位时，就必须要在 e 之后出现
     * 5. 不能出现 +、-、. 和数字以外的字符
     */
    boolean isNumeric2(char[] str) {
        // 标记符号、小数点、e是否出现过
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false; // e后面一定要接数字
                if (hasE) return false;  // 不能同时存在两个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) return false;
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') // 不合法字符
                return false;
        }
        return true;
    }


    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }

        int index;
        index = getIndexOfChar(str, 0, '.');
        boolean haveSymbol = false;
        if (index > 0) {
            if(index == 1 && (str[0] == '-' || str[0] == '+')){

            } else if (!isNumericWithSymbol(str, 0, index - 1, true)) {
                return false;
            }
        } else {
            haveSymbol = true;
        }

        int tempIndex = getIndexOfChar(str, index + 1, 'e');
        if (tempIndex > 0) {
            if (!isNumericWithSymbol(str, index + 1, tempIndex - 1, haveSymbol)) {
                return false;
            }
            haveSymbol = true;
            index = tempIndex;
        }

        return index + 1 <= str.length - 1 && isNumericWithSymbol(str, index + 1, str.length - 1, haveSymbol);
    }

    int getIndexOfChar(char[] str, int start, char c) {
        for (int i = start; i < str.length; i++) {
            if (c == 'e' && (str[i] == 'e' || str[i] == 'E')) {
                return i;
            } else if (str[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private boolean isNumericWithSymbol(char[] str, int start, int end, boolean haveSymbol) {
        if (str == null || str.length == 0) {
            return false;
        }
        if (start < 0 || end >= str.length) {
            return false;
        }

        int begin = start;
        if (haveSymbol && (str[start] == '+' || str[start] == '-')) {
            begin++;
        }

        boolean result = false;

        for (int i = begin; i <= end; i++) {
            result = true;
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return result;
    }

}
