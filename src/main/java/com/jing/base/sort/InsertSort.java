package com.jing.base.sort;

import java.util.Arrays;

/**
 * 插入排序，从原数组中选一个数插入另一个排序好的数组中
 * LinkedList
 * @author GuoJingyuan
 * @date 2019/12/4
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] originals = {5,21,3,4,7,9,14,1,0,0,5,7};
        int[] sorted = new InsertSort().inSort(originals);
        Arrays.stream(sorted).forEach(System.out::println);
    }

    public int[] inSort(int[] originals) {
        int length = originals.length;
        int[] sorted = new int[length];
        sorted[0] = originals[0];
        for (int i = 1; i < length; i++) {
            int wait = originals[i];
            for (int j = i-1; j >=0; j--) {
                if (sorted[j] > wait) {
                    sorted[j+1] = sorted[j];
                    if (j == 0) {
                        sorted[j] = wait;
                        break;
                    }
                } else {
                    sorted[j+1] = wait;
                    break;
                }
            }

        }
        return sorted;
    }

}
