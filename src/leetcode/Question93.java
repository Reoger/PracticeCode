package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 复原IP地址
 *
 * @link {https://leetcode-cn.com/problems/restore-ip-addresses/}
 */
public class Question93 {

    List<String> res = new ArrayList<>();
    final static int COUNT = 4;
    int[] dp = new int[COUNT];


    @Test
    public void test() {
        List<String> ans = restoreIpAddresses("25525511135");
        System.out.println(Arrays.toString(ans.toArray()));
    }

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return res;
    }

    private void dfs(String s, int id, int start) {
        if (id == COUNT && start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < COUNT; i++) {
               sb.append(dp[i]);
               if (i + 1 != COUNT) {
                   sb.append(".");
               }
            }
            res.add(sb.toString());
            return;
        }

        if (id == COUNT || start >= s.length()) {
            return;
        }

        if (s.charAt(start) == '0') {
            dp[id] = 0;
            dfs(s, id + 1, start + 1);
            return;
        }

        int address = 0;
        for (int i = start; i < s.length(); i++) {
            address = address * 10 + (s.charAt(i) - '0');
            if (address >= 0 && address <= 0XFF) {
                dp[id] = address;
                dfs(s, id + 1, i + 1);
            } else {
                break;
            }
        }
    }
}
