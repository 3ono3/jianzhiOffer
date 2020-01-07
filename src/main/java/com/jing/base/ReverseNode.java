package com.jing.base;

import java.util.Stack;

/**
 * 反转列表
 * 输入链表头部，反转列表
 * @author GuoJingyuan
 * @date 2020/1/6
 */
public class ReverseNode {
    public static void main(String[] args) {
        NodeList n0 = NodeList.getTestNode();
        NodeList head = n0;
        while (n0 != null) {
            System.out.print(n0 + " --> ");
            n0 = n0.getNext();
        }
        System.out.println();
        NodeList r0 = new ReverseNode().bookReverse(head);
        while (r0 != null) {
            System.out.print(r0 + " --> ");
            r0 = r0.getNext();
        }
        System.out.println();
    }
    //只要将后一个节点保存
    NodeList bookReverse(NodeList head) {
        if (head == null) {
            return null;
        }
        NodeList nextNode = null;
        NodeList preNode = head;
        if (head.getNext() == null) {
            return head;
        }
        NodeList node = head.getNext();
        while (node != null) {
            nextNode = node.getNext();
            node.setNext(preNode);
            preNode = node;
            node = nextNode;
        }
        return preNode;
    }
    //缺点，浪费空间
    NodeList reverse(NodeList head) {
        if (head == null) {
            return null;
        }
        Stack<NodeList> nodeStack = new Stack<>();
        while (head != null) {
            nodeStack.push(head);
            head = head.getNext();
        }
        NodeList newHead = nodeStack.pop();
        NodeList newNode = newHead;
        while (!nodeStack.empty()) {
            newNode.setNext(nodeStack.pop());
            newNode = newNode.getNext();
            newNode.setNext(null);
        }
        return newHead;
    }
}
