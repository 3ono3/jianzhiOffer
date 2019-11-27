package com.jing.base;

import java.util.Map;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author GuoJingyuan
 * @date 2019/10/18
 */
public class TailToHeadPrintLink {

    public static void main(String[] args) {
        new TailToHeadPrintLink().prepare();
    }
    public void prepare() {
        LinkNode root = new LinkNode(1);
        LinkNode r2 = new LinkNode(2);
        root.next = r2;
        r2.next = new LinkNode(3);
//        printNode(root);
        //使用栈打印
        printUseStack(root);
    }
    class LinkNode {
        private int val;
        public LinkNode next;
        LinkNode(int val) {
            this.val = val;
        }
    }
    public void printNode(LinkNode root) {
        LinkNode head = new LinkNode(-1);
        Map<String, String> [] ssAr = new Map[30];
        while (root != null) {
            LinkNode m = root.next;
            root.next = head.next;
            head.next = root;
            root = m;
        }

        while (head.next != null) {
            head = head.next;
            System.out.println(head.val);
        }
    }


    //使用栈（先入后出）
    public void printUseStack(LinkNode root) {
        Stack<Integer> stack = new Stack<>();
        while (root != null) {
            stack.push(root.val);
            root = root.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
