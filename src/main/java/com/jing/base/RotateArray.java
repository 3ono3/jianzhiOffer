package com.jing.base;

/**
 * 旋转数组
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * @author GuoJingyuan
 * @date 2019/10/18
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] original = {3,4,5,1,2};
        System.out.println(new RotateArray().lessEle(original));
    }

    public int lessEle(int[] original) {
        int low = 0;
        int height = original.length - 1;
        int middle = 0;
        while (low <= height) {
            if (height - low < 2) {
                return original[height] > original[low] ? original[low] : original[height];
            }
            middle = low + (height - low) / 2;
            if (original[low] <= original[middle]) {
                low = middle;
            } else if (original[middle] <= original[height]) {
                height = middle;
            }
        }
        return original[middle];
    }
}
