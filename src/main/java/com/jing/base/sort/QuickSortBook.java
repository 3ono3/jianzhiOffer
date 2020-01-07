package com.jing.base.sort;

import java.util.Arrays;

/**
 * 书上的快速排序
 * @author GuoJingyuan
 * @date 2019/12/16
 */
public class QuickSortBook {
    public static void main(String[] args) {
        int[] originals = {5,253,2,1,35,317,753,35,7};
        new QuickSortBook().quickSort(originals, originals.length, 0, originals.length-1);
        Arrays.stream(originals).forEach(System.out::println);
    }
    int randomInRange(int start, int end) {
        return (int) (Math.random()*(end -start+1)+start);
    }
    void swap(int[] data, int index1, int index2) {
        int mid = data[index1];
        data[index1] = data[index2];
        data[index2] = mid;
    }

    int partition(int[] data, int length, int start, int end) {
        if (data == null || length <= 0 || start < 0 || end >= length) {
            throw new RuntimeException("参数不合法");
        }

        int index = randomInRange(start, end);
        swap(data, index, end);
        int small = start - 1;
        for (index = start; index < end; index++) {
            if (data[index] < data[end]) {
                small++;
                if (small != index) {
                    swap(data, index, small);
                }
            }
        }
        small++;
        swap(data, small, end);
        return small;
    }

    void quickSort(int[] data, int length, int start, int end) {
        if (start == end) {
            return;
        }
        int index = partition(data, length, start, end);
        if (index > start) {
            quickSort(data, length, start, index-1);
        }
        if (index < end) {
            quickSort(data, length, index+1, end);
        }
    }
}
