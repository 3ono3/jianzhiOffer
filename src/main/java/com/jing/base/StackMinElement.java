package com.jing.base;

import java.util.Stack;

/**
 * 打造一个栈，存储最小元素
 * @author GuoJingyuan
 * @date 2019/10/31
 */
public class StackMinElement {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer ele) {
        dataStack.push(ele);
        minStack.push(minStack.isEmpty()? ele : Math.min(minStack.peek(), ele));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackMinElement sme = new StackMinElement();
        sme.push(12);
        sme.push(9);
        sme.push(17);
        sme.push(22);

        sme.dataStack.lastElement();
        sme.minStack.lastElement();
        System.out.println(sme.min());
    }
}
