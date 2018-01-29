package com.ip192.algorithm_test.sort;

public class Sort {
    /**
     * 插入排序
     * 小到大
     * @return int[]
     */
    public int[] insertSort() {
        int[] init = {1, 3, 5, 7, 9, 0};

        for (int i = 1; i < init.length; i++){ // 将第i个元素插入
            for (int j = i - 1; (j >= 0) && (init[j + 1] < init[j]); j--) { // 确保前j个元素的顺序
                init[j + 1] = init[j + 1] + init[j];
                init[j] = init[j + 1] - init[j];
                init[j + 1] = init[j + 1] - init[j];
            }
        }

        return init;
    }

    /**
     * 希尔排序
     * @return int[]
     */
    public int[] shellSort() {
        int[] init = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        for (int gap = init.length / 2; gap > 0; gap /= 2) {
            for (int j = 0; (j + gap) < init.length; j++) {
//                for (int)
            }
        }

        return init;
    }
}
