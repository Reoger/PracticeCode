package leetcode;

import java.util.Arrays;

/**
 * 转变数组后最接近目标值的数组和
 *
 * @link {https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/}
 */

public class Question1300 {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            double average = (target - sum) * 1.0 / (len - i - 1);
            if(average <= arr[i]) {

                return arr[i];
            }
        }

        return arr[len - 1];
    }
}
