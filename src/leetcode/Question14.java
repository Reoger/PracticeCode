package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Question14 {

    @Test
    public void test() {
        Assert.assertEquals("aa", longestCommonPrefix(new String[]{"aaa", "aa", "aaa"}));
//        Assert.assertEquals("aa", longestCommonPrefix(new String[]{"aa", "aa"}));
//        Assert.assertEquals("a", longestCommonPrefix(new String[]{"aa", "ab"}));
//        Assert.assertEquals("", longestCommonPrefix(new String[]{"a", "a", "b"}));
//        Assert.assertEquals("fl", longestCommonPrefix(new String[]{"flower","flow","flight"}));
//        Assert.assertEquals("", longestCommonPrefix(new String[]{""}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        char[] chars = strs[0].toCharArray();
        int index = chars.length;
        if (index <= 0) {
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            char[] tempChars = strs[i].toCharArray();
            for (int j = 0; j < tempChars.length; j++) {
                if (tempChars[j] != chars[j]) {
                    index = j - 1;
                    if (index < 0) {
                        return "";
                    }
                    break;
                } else {
                    index = Math.min(index, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= index; i++) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }

}
