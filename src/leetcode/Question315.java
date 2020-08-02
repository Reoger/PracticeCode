package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 */
public class Question315 {

    @Test
    public void test() {
        Assert.assertEquals(countSmaller(new int[]{5, 2, 6, 1}), Arrays.asList(2, 1, 1, 0));
        Assert.assertEquals(countSmaller(new int[]{2, 0, 1}), Arrays.asList(2, 0, 0));

    }


    //@wrong answer
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return ans;
        }

        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        int[] result = new int[nums.length];
        int[] indexs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexs[i] = i;
        }

        merge(nums, copy, indexs, result, 0, nums.length - 1);
        for (int n : result) {
            ans.add(n);
        }
        return ans;
    }


    private void merge(int[] data, int[] copy, int[] indexs, int[] res, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        merge(data, copy, indexs, res, start, mid);
        merge(data, copy, indexs, res, mid + 1, end);

        int i = start;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            if (data[indexs[i]] > data[indexs[j]]) {
                for (int k = i; k <= mid; k++) {
                    res[indexs[k]]++;
                }
                copy[index++] = indexs[j++];
            } else {
                copy[index++] = indexs[i++];
            }
        }

        while (i <= mid) {
            copy[index++] = indexs[i++];
        }
        while (j <= end) {
            copy[index++] = indexs[j++];
        }
        index = 0;
        while (start <= end) {
            indexs[start++] = copy[index++];
        }
    }


}
