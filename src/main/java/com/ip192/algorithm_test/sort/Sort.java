package com.ip192.algorithm_test.sort;

public class Sort {
    private int[] init = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    /**
     * 插入排序
     * 小到大
     */
    public int[] insertSort() {
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
     */
    public int[] shellSort() {
        for (int gap = init.length / 2; gap > 0; gap /= 2) {
            for (int j = 0; (j + gap) < init.length; j++) {
//                for (int)
            }
        }

        return init;
    }


    /**
     * 快排
     */
    public int[] speedSort(int[] origin) {
        int[] left; // little than
        int[] right; // great than

        for (int from = 1; from < origin.length; from++) {
//            if (origin[0] > origin[from]) left[left.length - 1] = origin[from];
        }


        return init;
    }


    public int[] chooseSort() {
        for (int i = 0; i < init.length; i++) {
            int min = i;
            for (int j = i + 1; j < init.length; j++) {
                if (init[j] < init[i]) {
                    min = j;
                }
            }
            if (i != min) {
                init[i] = init[i] + init[min];
                init[min] = init[i] - init[min];
                init[i] = init[i] - init[min];
            }
        }

        return init;
    }
}
