package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Question125 {


    @Test
    public void test() {
        Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertFalse(isPalindrome("race a car"));
        Assert.assertFalse(isPalindrome("0P"));
    }


    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int start = 0;
        String temp = s.toLowerCase();
        int end = temp.length() - 1;
        while (start < end) {
            while (start < end && isNotValidChar(temp, start)) {
                start++;
            }
            while (start < end && isNotValidChar(temp, end)) {
                end--;
            }

            if (start == end) {
                return true;
            }

            char a = temp.charAt(start);
            char b = temp.charAt(end);

            if (a != b) {

                return false;
            }
            start++;
            end--;
        }

        return true;
    }


    private boolean isNotValidChar(String s, int index) {
        char c = s.charAt(index);
        if (c >= '0' && c <= '9') {
            return false;
        }
        return c < 'a' || c > 'z';
    }
}
