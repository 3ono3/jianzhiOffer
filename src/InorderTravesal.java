import javax.swing.tree.TreeNode;

/**
 * 中序遍历的下一个节点
 * @author GuoJingyuan
 * @date 2019/10/17
 */
public class InorderTravesal {
     private class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public int nextNodeVal(TreeLinkNode local) {
         if (local.right != null) {
             local = local.right;
             while (local.left != null) {
                 local = local.left;
             }
             return local.val;
         } else {
             while (local.next != null) {
                 TreeLinkNode parent = local.next;
                 if (parent.left == local) {
                     return parent.val;
                 }
                 local = local.next;
             }
         }
         return 0;
    }

}
