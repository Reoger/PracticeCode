package chapter5;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * link {https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1}
 */

public class Question41 {

    private PriorityQueue<Integer> minPop = new PriorityQueue<>(Comparator.naturalOrder());
    private PriorityQueue<Integer> maxPop = new PriorityQueue<>(Comparator.reverseOrder());
    private int count = 0;

    public void Insert(Integer num) {
        if(count % 2 == 0) {
            minPop.offer(num);
            maxPop.offer(minPop.poll());
        } else {
            maxPop.offer(num);
            minPop.offer(maxPop.poll());
        }

        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            int a = minPop.isEmpty() ? 0 : minPop.peek();
            int b = maxPop.isEmpty() ? 0 : maxPop.peek();
            return (a + b) * 1.0 / 2;
        }

        return (double) (maxPop.isEmpty() ? 0 : maxPop.peek());
    }


    @Test
    public void test() {
        int[] test = {1,2,3,4,5,6};
        for (int value : test) {
            Insert(value);
        }

        System.out.println(GetMedian());
    }

}
