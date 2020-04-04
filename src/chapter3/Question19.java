package chapter3;

import org.junit.Assert;
import org.junit.Test;

/**
 * 正则表达式匹配
 *
 * @see {https://www.nowcoder.com/practice/45327ae22b7b413ea21df13ee7d6429c}
 * <p>
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

public class Question19 {

    @Test
    public void test() {
        char[] str = {'a', 'a', 'a'};

        Assert.assertTrue(match(str, new char[]{'a', 'b', '*', 'a', 'c', '*', 'a'}));
        Assert.assertTrue(match("".toCharArray(), "".toCharArray()));
        Assert.assertTrue(match("".toCharArray(), ".*".toCharArray()));
        Assert.assertTrue(match(str, "a*".toCharArray()));
        Assert.assertFalse(match(str, "aa".toCharArray()));
        Assert.assertFalse(match(str, "aa.a".toCharArray()));
        Assert.assertFalse(match(str, "ab*a".toCharArray()));

    }

    public boolean match(char[] str, char[] pattern) {
        if (pattern == null && str == null) {
            return true;
        } else if (pattern == null || str == null) {
            return false;
        }
        return matchPatterns(str, 0, pattern, 0);
    }

    boolean matchPatterns(char[] chars, int indexChars, char[] patterns, int indexPatterns) {
        if (indexChars >= chars.length && indexPatterns >= patterns.length) {
            return true;
        }

        if (indexChars < chars.length && indexPatterns >= patterns.length) {
            return false;
        }

        if (indexPatterns + 1 < patterns.length && patterns[indexPatterns + 1] == '*') {
            if ((indexChars < chars.length && patterns[indexPatterns] == chars[indexChars]) || (patterns[indexPatterns] == '.' && indexChars < chars.length)) {
                return matchPatterns(chars, indexChars + 1, patterns, indexPatterns + 2) ||
                        matchPatterns(chars, indexChars, patterns, indexPatterns + 2) ||
                        matchPatterns(chars, indexChars + 1, patterns, indexPatterns);
            } else {
                return matchPatterns(chars, indexChars, patterns, indexPatterns + 2);
            }
        }

        if (indexChars >= chars.length) {
            return false;
        }

        if (patterns[indexPatterns] == '.' || patterns[indexPatterns] == chars[indexChars]) {
            return matchPatterns(chars, indexChars + 1, patterns, indexPatterns + 1);
        }
        return false;
    }


}
