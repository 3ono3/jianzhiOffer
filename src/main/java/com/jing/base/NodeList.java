package com.jing.base;

/**
 * @author GuoJingyuan
 * @date 2020/1/3
 */
public class NodeList{
    private int val;
    private NodeList next;

    /**
     * 获取测试链表
     * 0->1->2->3->4->5->6
     * @return
     */
    public static NodeList getTestNode() {
        NodeList n0 = new NodeList(0);
        NodeList n1 = new NodeList(1);
        NodeList n2 = new NodeList(2);
        NodeList n3 = new NodeList(3);
        NodeList n4 = new NodeList(4);
        NodeList n5 = new NodeList(5);
        NodeList n6 = new NodeList(6);
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        return n0;
    }
    @Override
    public String toString() {
        return "NodeList{" +
                "val=" + val +
                '}';
    }

    public NodeList(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public NodeList getNext() {
        return next;
    }

    public void setNext(NodeList next) {
        this.next = next;
    }
}
