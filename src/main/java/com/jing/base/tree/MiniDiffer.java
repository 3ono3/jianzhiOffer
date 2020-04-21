package com.jing.base.tree;

import com.jing.base.BinaryTreeNode;
import com.jing.base.traverse.tree.TraverseUtil;

import java.beans.BeanInfo;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
public class MiniDiffer {
    private int diff = Integer.MAX_VALUE;
    private int nodeValue1 = 0;
    private int nodeValue2 = 0;

    public static void main(String[] args) {
        BinaryTreeNode head = new BinaryTreeNode(543);
        BinaryTreeNode l1 = new BinaryTreeNode(384);
        BinaryTreeNode r1 = new BinaryTreeNode(652);
        BinaryTreeNode l22 = new BinaryTreeNode(455);
        BinaryTreeNode r22 = new BinaryTreeNode(699);
        head.left = l1;
        head.right = r1;
        l1.right = l22;
        r1.right = r22;
        TraverseUtil.levelTraverse(head);
        System.out.println();
        MiniDiffer miniDiffer = new MiniDiffer();
        int diff = miniDiffer.solution(head);
        System.out.println("最小绝对值差：" + diff);
//        System.out.println("node1: " + miniDiffer.nodeValue1);
//        System.out.println("node2: " + miniDiffer.nodeValue2);
    }

    /**
     * 二叉搜索树，左边比中间小，右边比中间大
     * 最小差为：根节点与左子树最右节点 / 根节点与右子树最左节点
     * @return
     */
    public int solution(BinaryTreeNode head) {
        int diff = Integer.MAX_VALUE;
        if (head == null) {
            return 0;
        }
        BinaryTreeNode lr = getLeftRight(head.left);
        BinaryTreeNode rl = getRightLeft(head.right);
        int rootValue = head.value;
        if (lr != null && rl != null) {
            int dl = rootValue - lr.value;
            int dr = rl.value - rootValue;
            return dl < dr ? dl : dr;
        }
        if (rl != null) {
            return rl.value - rootValue;
        }
        if (lr != null) {
            return rootValue - lr.value;
        }
        return rootValue;
    }


    /**
     * 获取左子树最右边的节点
     * @param leftRoot
     * @return
     */
    public BinaryTreeNode getLeftRight(BinaryTreeNode leftRoot) {
        if (leftRoot == null) {
            return leftRoot;
        }
        BinaryTreeNode p = leftRoot;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    /**
     * 获取右子树最左节点
     * @param rightRoot
     * @return
     */
    public BinaryTreeNode getRightLeft(BinaryTreeNode rightRoot) {
        if (rightRoot == null) {
            return rightRoot;
        }
        BinaryTreeNode p = rightRoot;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public int getDiff(int diff, BinaryTreeNode p) {
        if (p == null) {
            return diff;
        }
        BinaryTreeNode left = p.left;
        if (left != null) {
            int ld = p.value - left.value;
            if (ld < diff) {
                diff = ld;
                nodeValue1 = p.value;
                nodeValue2 = left.value;
            }
            diff = getDiff(diff, left);
        }
        BinaryTreeNode right = p.right;
        if (right != null) {
            int rd = right.value - p.value;
            if (rd < diff) {
                diff = rd;
                nodeValue1 = p.value;
                nodeValue2 = right.value;
            }
            diff = getDiff(diff, right);
        }
        return diff;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int minvalue=Integer.MAX_VALUE;
        if (root.left != null) {
            TreeNode right = root.left;
            while (right.right != null) {
                right = right.right;
            }
            minvalue = root.val - right.val;
        }
        if (root.right != null) {
            TreeNode left = root.right;
            while (left.left != null) {
                left = left.left;
            }
            minvalue = Math.min(left.val - root.val,minvalue);
        }
        return Math.min(minvalue, Math.min(getMinimumDifference(root.left), getMinimumDifference(root.right)));
    }

}
