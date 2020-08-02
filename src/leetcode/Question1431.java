package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 * @link {https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/}
 */

public class Question1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }

        for (int candy: candies) {
            ans.add((candy + extraCandies)>=max);
        }

        return ans;
    }

}
