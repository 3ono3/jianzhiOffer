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
        BinaryTreeNode head = new BinaryTreeNode(236);
        BinaryTreeNode l1 = new BinaryTreeNode(104);
        BinaryTreeNode r1 = new BinaryTreeNode(701);
        BinaryTreeNode l22 = new BinaryTreeNode(227);
        BinaryTreeNode r22 = new BinaryTreeNode(911);
        head.left = l1;
        head.right = r1;
        l1.right = l22;
        r1.right = r22;
        TraverseUtil.levelTraverse(head);
        System.out.println();
        MiniDiffer miniDiffer = new MiniDiffer();
        int diff = miniDiffer.solution(head);
        System.out.println("最小绝对值差：" + diff);
        System.out.println("node1: " + miniDiffer.nodeValue1);
        System.out.println("node2: " + miniDiffer.nodeValue2);
    }

    /**
     * 二叉搜索树，左边比中间小，右边比中间大
     * @return
     */
    public int solution(BinaryTreeNode head) {
        int diff = Integer.MAX_VALUE;
        if (head == null) {
            return 0;
        }
        return getDiff(diff, head);
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
