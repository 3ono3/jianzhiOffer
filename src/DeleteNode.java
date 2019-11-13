import java.util.SortedMap;

/**
 * 删除链表节点，
 * 当要删除的节点不是最后节点，将下一个节点的值赋给要删除的节点，当前节点下一个节点指向下下个节点
 * 删除最后一个节点，遍历，将上一个节点指针的next指为Null
 * @author GuoJingyuan
 * @date 2019/10/23
 */
public class DeleteNode {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        new DeleteNode().test();
    }
    public void test() {
        ListNode root = new ListNode(1);
        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(3);
        ListNode r3 = new ListNode(4);
        root.next = r1;
        r1.next = r2;
        r2.next = r3;
        deleteNode(root, r3);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
    public void deleteNode(ListNode head, ListNode target) {
        if (target.next != null) {
            ListNode tn = target.next;
            target.val = tn.val;
            target.next = tn.next;
        } else {
            if (head == target) {
                head = null;
            } else {
                while (head.next != null) {
                    if (head.next == target) {
                        head.next = null;
                    }else {
                        head = head.next;
                    }
                }
            }
        }
    }
}
