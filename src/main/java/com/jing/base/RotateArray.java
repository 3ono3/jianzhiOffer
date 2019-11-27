package com.jing.base;

/**
 * 旋转数组
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * @author GuoJingyuan
 * @date 2019/10/18
 */
public class RotateArray {


    public int lessEle(int[] original) {
        int low = 0;
        int height = original.length - 1;
        int middle = 0;
        while (low < height) {
            middle = low + (height - low) / 2;
            if (original[height] < original[middle]) {
                low = middle;
            } else if (original[low] > original[middle] && original[middle-1] < original[middle]) {
                height = middle;
            }
        }
        return original[middle];
    }
}
