package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 *
 * @link {https://leetcode-cn.com/problems/largest-rectangle-in-histogram/}
 * #单调栈
 */

public class Question84 {

    @Test
    public void test() {
        Assert.assertEquals(10, largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(10, largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(3, largestRectangleArea2(new int[]{2, 1, 2}));
    }


    public int largestRectangleArea(int[] heights) {
        if (heights.length <= 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            while (right + 1 < heights.length && heights[right + 1] >= curHeight) {
                right++;
            }

            ans = Math.max(ans, (right - left + 1) * curHeight);
        }

        return ans;
    }

    public int largestRectangleArea2(int[] heights) {
        if(heights.length <= 0) {
            return 0;
        }

        if(heights.length == 1) {
            return heights[0];
        }

        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < newHeights.length; i++) {
            int curHeights = newHeights[i];
            while (!stack.isEmpty() && newHeights[stack.peekLast()] > curHeights) {
                int height = newHeights[stack.removeLast()];
                int width = stack.isEmpty() ? i : i - stack.peekLast() - 1;
                ans = Math.max(ans, width * height);
            }

            stack.addLast(i);
        }

        return ans;
    }

    public int largestRectangleArea3(int[] heights) {
        if (heights.length == 0){
            return 0;
        }

        int n = heights.length;
        int[] stk = new int[n + 1];
        int tt = 0;
        int ans = heights[0];
        stk[0] = -1;
        for (int i = 0; i < n; i++) {
            while (tt != 0 && heights[stk[tt]] > heights[i]) {
                ans = Math.max(ans, heights[stk[tt]] * (i - stk[--tt] - 1));
                // tt--;
            }
            stk[++tt] = i;
        }
        while (tt != 0) {
            ans = Math.max(ans, heights[stk[tt]] * (n - stk[--tt] - 1));
        }
        return ans;
    }

}
