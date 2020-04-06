package chapter5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的 k 个数
 *
 * @link {https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf}
 */

public class Question40 {

    @Test
    public void test() {
        int[] test1 = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList result = GetLeastNumbers_Solution(test1, 4);
        System.out.println(result);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input == null || input.length == 0 || k < 0) {
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i : input) {
            if (queue.size() < k) {
                queue.offer(i);
            } else {
                queue.offer(i);
                queue.poll();
            }
        }

        result.addAll(queue);
        result.sort(Comparator.naturalOrder());
        return result;
    }

}
