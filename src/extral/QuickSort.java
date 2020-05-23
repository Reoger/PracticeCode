package extral;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    @Test
    public void test() {
        int[] test = {12, 3, 4, 5, 7, 16, 24, 64, 242, 24, 6, 623, 235};
        sort2(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    private void sort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int temp = i;
        // 这里限定了 temp 只能等于 i，不能直接换成 temp = （i+j)/2, 这种方式必须得从顶点开始
        while (i < j) {
            while (i < j && data[temp] <= data[j])
                j--;
            while (i < j && data[temp] >= data[i])
                i++;
            swap(data, i, j);
        }
        swap(data, i, temp);

        sort(data, start, i);
        sort(data, i + 1, end);

    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void sort2(int[] data, int start, int end) {
        if(start >= end){
            return;
        }

        int index = position(data, start, end);
        sort2(data, start, index);
        sort2(data, index + 1, end);
    }

    private int position(int[] data, int start, int end) {
        int small = start - 1;
        int index = (start + end) / 2;
        swap(data, index, end);
        for (int i = start; i < end; i++) {
            if (data[i] < data[end]) {
                ++small;
                swap(data, small, i);
            }
        }
        ++small;
        swap(data, small, end);
        return small;
    }


}
