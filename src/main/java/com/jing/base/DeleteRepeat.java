package com.jing.base;

/**
 * 删除链表中重复节点
 * @author GuoJingyuan
 * @date 2019/12/25
 */
public class DeleteRepeat {
    public static void main(String[] args) {
        NodeList headNode = new NodeList(3);
        NodeList node1 = new NodeList(3);
        NodeList node2 = new NodeList(3);
        NodeList node3 = new NodeList(3);
        NodeList node4 = new NodeList(3);
        NodeList node5 = new NodeList(3);
        NodeList node6 = new NodeList(3);
        headNode.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        headNode = new DeleteRepeat().deleteRepeat(headNode);
        while (headNode != null) {
            System.out.println(headNode.getVal());
            headNode = headNode.getNext();
        }
    }
    NodeList deleteRepeat(NodeList head) {
        if (head.getNext() == null) {
            return head;
        }
        NodeList preNode = null;
        NodeList p = head;
        while (p != null){
            NodeList pNext = p.getNext();
            boolean needDel = false;
            if (pNext != null && p.getVal() == pNext.getVal()){
                needDel = true;
            }
            if (!needDel) {
                preNode = p;
                p = p.getNext();
            } else {
                while (p.getNext() != null && p.getVal() == p.getNext().getVal()) {
                    p = p.getNext();
                }
                p = p.getNext();
                if (preNode == null) {
                    if (p == null) {
                        return null;
                    }
                    head.setVal(p.getVal());
                    head.setNext(p.getNext());
                } else {
                    preNode.setNext(p);
                }
            }

        }
        return head;
    }
}
