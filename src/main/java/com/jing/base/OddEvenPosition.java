package com.jing.base;
import java.util.LinkedList;

/**
 * 调整奇数和偶数的位置，奇数位于偶数之前，且奇数和奇数，偶数和偶数相对位置不变
 * @author GuoJingyuan
 * @date 2019/10/24
 */
public class OddEvenPosition {

    public static void main(String[] args) {
        int[] targetAry = {1,2,3,4,5};
        int[] resAry = new OddEvenPosition().changePosition(targetAry);
        for (int i : resAry) {
            System.out.println(i);
        }
    }

    public int[] changePosition(int[] targetAry) {
        if (targetAry.length <= 1) {
            return targetAry;
        }
        LinkedList<Integer> oddList = new LinkedList<>();
        LinkedList<Integer> evenList = new LinkedList<>();
        for (int i = 0; i < targetAry.length; i++) {
            int item = targetAry[i];
            if (item % 2 == 0) {
                evenList.add(item);
            } else {
                oddList.add(item);
            }
        }
        oddList.addAll(evenList);

        int[] resultArray = new int[oddList.size()];
        for (int i = 0; i < oddList.size(); i++) {
            resultArray[i] = oddList.get(i);
        }
        return resultArray;
    }
}
