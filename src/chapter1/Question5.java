package chapter1;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题5：替换空格
 * <p>
 * link：https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423
 */
public class Question5 {

    @Test
    public void test() {
        StringBuffer test1 = new StringBuffer("We Are Happy.");
        String result1 = "We%20Are%20Happy.";
        Assert.assertEquals(result1, replaceSpace(test1));
    }

    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int spaceCount = 0;
        StringBuffer result = new StringBuffer(str);
        int length = result.length();
        for (int i = 0; i < length; i++) {
            if (result.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        result.setLength(spaceCount * 2 + length);
        int i = length - 1;
        int j = result.length() - 1;
        while (i < j && i >= 0) {
            char tempChar = result.charAt(i--);
            if (tempChar == ' ') {
                result.setCharAt(j--, '0');
                result.setCharAt(j--, '2');
                result.setCharAt(j--, '%');
            } else {
                result.setCharAt(j--, tempChar);
            }
        }

        return result.toString();
    }

}
