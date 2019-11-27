package com.jing.base;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 数组中重复数字
 * 长度为n的数组，数字范围0~n-1
 * @author GuoJingyuan
 * @date 2019/11/12
 */
public class RepeatAry {

    public static void main(String[] args) {
        int[] targetAry = {2,3,1,0,4,5,6};
        Set<Integer> result = new RepeatAry().getRepeatData(targetAry);
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public Set<Integer> getRepeatData(int[] targetAry) {
        Set<Integer> result = new HashSet<>();
        if (targetAry.length < 2) {
            return result;
        }
        for (int i = 0; i < targetAry.length; i ++) {
            while (targetAry[i] != i) {
                int targetIndex = targetAry[i];
                int targetVal = targetAry[targetIndex];
                if (targetVal == targetIndex) {
                    result.add(targetIndex);
                    break;
                }
                targetAry[i] = targetVal;
                targetAry[targetIndex] = targetIndex;
            }
        }
        return result;
    }
}
