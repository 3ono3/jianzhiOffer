package com.jing.base;

/**
 * 合并两个排序链表
 * @author GuoJingyuan
 * @date 2020/1/6
 */
public class MergeNodeList {

    public static void main(String[] args) {
        NodeList n0 = new NodeList(0);
        NodeList n1 = new NodeList(1);
        NodeList n2 = new NodeList(2);
        NodeList n3 = new NodeList(3);
        NodeList nEq = new NodeList(3);
        NodeList nEq2 = new NodeList(4);
        NodeList n4 = new NodeList(4);
        NodeList n5 = new NodeList(5);
        NodeList n6 = new NodeList(6);
        NodeList n7 = new NodeList(7);
        n0.setNext(n2);
        n2.setNext(n4);
        n4.setNext(n6);

        n1.setNext(n3);
        n3.setNext(nEq);
        nEq.setNext(nEq2);
        nEq2.setNext(n5);
        n5.setNext(n7);

        NodeList mergedNode = new MergeNodeList().getMerged(n0, n1);
        while (mergedNode != null) {
            System.out.print(mergedNode);
            mergedNode = mergedNode.getNext();
        }
    }
    NodeList getMerged(NodeList s1, NodeList s2) {
        if (s1 == null) {
            return s2;
        }
        if (s2 == null) {
            return s1;
        }
        NodeList newNode = null;
        if (s1.getVal() < s2.getVal()) {
            newNode = s1;
            s1 = s1.getNext();
        } else {
            newNode = s2;
            s2 = s2.getNext();
        }
        NodeList newNodeHead = newNode;
        while (s1 != null && s2 != null) {
            if (s1.getVal() < s2.getVal()) {
                newNode.setNext(s1);
                s1 = s1.getNext();
                newNode = newNode.getNext();
            } else {
                newNode.setNext(s2);
                s2 = s2.getNext();
                newNode = newNode.getNext();
            }
        }
        if (s1 != null) {
            newNode.setNext(s1);
        }
        if (s2 != null) {
            newNode.setNext(s2);
        }
        return newNodeHead;
    }
}
