package chapter6;

import java.util.LinkedList;

/**
 * 队列的最大值
 *
 * @link {https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/}
 */

public class MaxQueue {
    LinkedList<Integer> mQueue;
    LinkedList<Integer> mMaxQueue;

    public MaxQueue() {
        mQueue = new LinkedList<>();
        mMaxQueue = new LinkedList<>();
    }

    public int max_value() {
        if (mMaxQueue.isEmpty()) {
            return -1;
        }
        return mMaxQueue.peekFirst();
    }

    public void push_back(int value) {
        mQueue.add(value);
        while (!mMaxQueue.isEmpty() && mMaxQueue.peekLast() < value) {
            mMaxQueue.pollLast();
        }
        mMaxQueue.add(value);
    }

    public int pop_front() {
        if (mQueue.isEmpty()) {
            return -1;
        }

        int value = mQueue.pop();
        if (value == mMaxQueue.peekFirst()) {
            mMaxQueue.pop();
        }
        return value;
    }
}
