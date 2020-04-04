package chapter3;

import org.junit.Test;

/**
 * 打印从 1 到最大的 n 位数
 * 输入数字 n， 按顺序打印从1到最大的n位十进制的数。比如输入3，则打印1、2、3 ... 998、999。
 * <p>
 * 需要考虑大数问题，需要转乘字符串来处理，避免数据溢出
 * 思路1：使用递归来实现全排列，然后按照数字的习惯进行输出
 * 思路2：用字符串来实现大数组操作，判断是否到数组的尾部和加1的操作都放到一个函数中
 */

public class Question17 {

    @Test
    public void test() {
//        printf1ToMaxOfDigits(3);
        printf1ToMaxOfDigits2(3);
    }

    void printf1ToMaxOfDigits(int n) {
        if (n < 1) {
            return;
        }

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }

        String number = sb.toString();
        String nextNumber;
        while ((nextNumber = getNextNum(n, number)) != null) {
            printfNumber(nextNumber);
            number = nextNumber;
        }
    }


    String getNextNum(int n, String curNum) {
        int carry = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int digits = curNum.charAt(i) - '0' + carry;
            if (digits > 9) {
                digits -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(digits);
        }

        if (carry == 1) {
            return null;
        }

        return sb.reverse().toString();
    }

    private void printfNumber(String str) {
        if (str == null || str.length() == 0) {
            return;
        }

        int index = 0;
        int length = str.length();
        while (index < length && str.charAt(index) == '0') {
            index++;
        }
        String result = str.substring(index);
        System.out.println(result);
    }


    //全排列
    void printf1ToMaxOfDigits2(int n) {
        if (n < 1) {
            return;
        }

        for (int i = 0; i < 10; i++) {
            printf1ToMaxOfDigits2Core(String.valueOf(i), n);
        }

    }

    void printf1ToMaxOfDigits2Core(String str, int n) {
        if (str.length() == n) {
            printfNumber(str);
            return;
        }

        for (int i = 0; i < 10; i++) {
            printf1ToMaxOfDigits2Core(str + i, n);
        }
    }


}
