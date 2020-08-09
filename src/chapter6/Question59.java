package chapter6;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 1. 滑动窗口的最大值
 *
 * @link {https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/}
 *
 * 2.队列的最大值
 * {@link chapter6.MaxQueue }
 */
public class Question59 {

    @Test
    public void testMaxSlidingWindow() {
        Assert.assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7},
                maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 0) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty()) {
                queue.offer(i);
            } else {
                while (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                    queue.removeFirst();
                }
                while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                    queue.removeLast();
                }
                queue.addLast(i);
            }

            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }


    @Test
    public void testMaxQueue() {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }


}
