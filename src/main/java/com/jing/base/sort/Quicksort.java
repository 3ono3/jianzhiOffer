package com.jing.base.sort;

import java.util.Arrays;

/**
 * 快速排序，选择一个数，比它小的放左边，比它大的放右边
 * @author GuoJingyuan
 * @date 2019/12/13
 */
public class Quicksort {

    public static void main(String[] args) {
        int[] originals = {5,253,2,1,35,317,753,35,7};
        new Quicksort().qs(0, originals.length-1, originals);
        Arrays.stream(originals).forEach(System.out::println);
    }

    public void qs(int start, int end ,int[] originals) {
        int bs = start;
        int be = end;
        if (start >= end) {
            return ;
        }
        int flag = originals[end];
       while (start < end) {
           while (originals[start] <= flag && start < end) {
              start++;
           }
           originals[end] = originals[start];
           originals[start] = flag;
           while (originals[end] >= flag && start < end) {
               end--;
           }
           originals[start] = originals[end];
           originals[end] = flag;
       }
       qs(bs, --end, originals);
       qs(++start, be, originals);
    }
}
