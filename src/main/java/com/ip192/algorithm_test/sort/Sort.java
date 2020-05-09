package com.ip192.algorithm_test.sort;

public class Sort {
    private int[] init = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    /**
     * 插入排序
     * 从第二个元素开始，假设前面元素已经排好顺序，向左边按顺序进行插入(比较交换)
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
     * 快速排序（分区交换排序）
     * 选取第一个元素为基准数，与第二个比较交换、与第n个比较交换，与第三个、与第n-1个比较交换，直到两边相遇
     * 递归对基准数两边的分数组实施比较逻辑
     * 首尾交替比较可以达到同时找大的和小的，若只从一边比较可能要重复搬运
     */
    public int[] speedSort(int[] origin) {
        int[] left; // little than
        int[] right; // great than

        for (int from = 1; from < origin.length; from++) {
//            if (origin[0] > origin[from]) left[left.length - 1] = origin[from];
        }


        return init;
    }


    /**
     * 选择排序
     * 从第一个元素向右开始找最小的，将第一轮找到的最小值与第一个元素交换
     * 继续从第二个向右找最小的(第二小)交换到第二个位置，直到最后
     */
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


    /**
     * 归并排序
     * 是将两个排好序的数组合并成一个
     * 定义一个长数组用来存放两个待合并数组，分别从第一个元素开始取，比较大小然后放到长数组中
     */
}
