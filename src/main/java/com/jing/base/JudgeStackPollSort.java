package com.jing.base;

import java.util.Stack;

/**
 * 给出插入序列,弹出序列，判断弹出序列可不可以是栈的弹出序列
 * @author GuoJingyuan
 * @date 2020/1/13
 */
public class JudgeStackPollSort {

    public static void main(String[] args) {
        JudgeStackPollSort tt = new JudgeStackPollSort();
        int[] push = {1,2,3,4,5};
        int[] pop = {5,4,2,3,1};
        boolean result = tt.judge(push, pop);
        System.out.println(result);
    }
    boolean judge(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        if (push == null || pop == null || push.length != pop.length) {
            return false;
        }
        for (int i = 0; i < pop.length; i++) {
            int pushValue = push[i];
            if (pop[popIndex] == pushValue) {
                popIndex++;
            } else {
                stack.add(pushValue);
            }
        }
        if (stack.empty() && popIndex == pop.length) {
            return true;
        }
        for (; popIndex < pop.length; popIndex++) {
            if (pop[popIndex] != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
