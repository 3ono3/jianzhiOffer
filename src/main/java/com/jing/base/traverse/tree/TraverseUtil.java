package com.jing.base.traverse.tree;

import com.jing.base.BinaryTreeNode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 树的遍历
 * @author GuoJingyuan
 * @date 2020/1/7
 */
public class TraverseUtil {
    //前序遍历
    public static void beforeTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        beforeTraverse(root.left);
        beforeTraverse(root.right);
    }
    //中序遍历
    public static void middleTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        middleTraverse(root.left);
        System.out.println(root.value);
        middleTraverse(root.right);
    }
    //后序遍历
    public static void endTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        endTraverse(root.left);
        endTraverse(root.right);
        System.out.println(root.value);
    }
    public static void levelTraverse(BinaryTreeNode root) {
        Queue<BinaryTreeNode> binaryTreeNodes = new ConcurrentLinkedQueue<>();
        binaryTreeNodes.add(root);
        levelTraverse(binaryTreeNodes);
    }
    //层次遍历
    private static void levelTraverse(Queue<BinaryTreeNode> queue) {
        if (queue == null || queue.size()==0) {
            return;
        }
        BinaryTreeNode node = queue.poll();
        if (node != null) {
            System.out.print(node.value + " - ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        levelTraverse(queue);
    }
}
