package com.jing.base;

/**
 * 环的入口节点
 * 一个链中若有环返回环的入口节点
 * 思路：两个指针一快一慢必定在环内相遇，从这个节点走到再次到这个节点可以求出环内节点个数
 * 一个指针先走环内节点个数步，两个指针在环的入口节点相遇
 * @author GuoJingyuan
 * @date 2020/1/3
 */
public class LoopStartNode {
    public static void main(String[] args) {
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
        n6.setNext(n0);

        NodeList loopStarNode = new LoopStartNode().getStarNode(n0);
        System.out.println(loopStarNode);
    }

    NodeList getStarNode(NodeList head) {
        NodeList meetN = getMeetNode(head);
        if (meetN == null) {
            //没有环
            return null;
        }
        int loopListLength = getLoopLength(meetN);
        NodeList beforeNode = head;
        NodeList afterNode = head;
        for (int i = 0; i < loopListLength; i++) {
            beforeNode = beforeNode.getNext();
        }
        while (beforeNode != afterNode){
            beforeNode = beforeNode.getNext();
            afterNode = afterNode.getNext();
        }
        return afterNode;
    }

    NodeList getMeetNode(NodeList head) {
        if (head == null) {
            return null;
        }
        NodeList fastNode = head;
        NodeList slowNode = head;

        int fastStep = 2;
        int slowStep = 1;
        fastNode = fastNode.getNext();
        if (fastNode == null) {
            return null;
        }
        fastNode = fastNode.getNext();
        while (fastNode != null) {
            //相遇地点
            if (fastNode == slowNode) {
                return slowNode;
            }
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext();
            if (fastNode == null) {
                return null;
            }
            fastNode = fastNode.getNext();
        }
        return null;
    }

    /**
     * 环的长度
     * @param loopNode 环中一节点
     * @return
     */
    int getLoopLength(NodeList loopNode) {
        NodeList loopN = loopNode;
        int length = 1;
        loopN = loopN.getNext();
        while (loopNode != loopN) {
            length++;
            loopN = loopN.getNext();
        }
        return length;
    }
}
