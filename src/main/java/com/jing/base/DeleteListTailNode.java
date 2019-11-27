package com.jing.base;


/**
 * 删除链表倒数第K个节点
 * @author GuoJingyuan
 * @date 2019/10/24
 */
public class DeleteListTailNode {

    public static void main(String[] args) {
        ListNode root = new ListNode(0);
        ListNode r1 = new ListNode(1);
        ListNode r2 = new ListNode(2);
        ListNode r3 = new ListNode(3);
        ListNode r4 = new ListNode(4);
        ListNode r5 = new ListNode(5);
        root.next = r1;r1.next = r2;r2.next = r3;r3.next = r4;r4.next = r5;

        ListNode resultHead = new DeleteListTailNode().deleteLast(root, 7);
        while (resultHead != null) {
            System.out.println(resultHead.val);
            resultHead = resultHead.next;
        }
    }

    public ListNode deleteLast(ListNode head, int k) {
        ListNode p1,p2;
        p1 = head;
        p2 = head;
        for (int i = 0; i < k; i++) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        if (p2 == null) {
            return null;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = null;
        return head;
    }
}
