package chapter4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列
 *
 * @link {https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7}
 */
public class Question38 {


    @Test
    public void test() {
        ArrayList result = Permutation("abc");
        System.out.println(result);
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }
        permutationCore(result, 0, str.toCharArray());
        Collections.sort(result);
        return result;
    }

    private void permutationCore(ArrayList<String> list, int index, char[] chars) {
        if (index == chars.length) {
            String str = String.valueOf(chars);
            if (!list.contains(str)) {
                list.add(str);
            }
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            permutationCore(list, index + 1, chars);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


}
