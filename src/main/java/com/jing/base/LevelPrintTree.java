package com.jing.base;

import com.jing.base.traverse.tree.TraverseUtil;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 层次打印二叉树，每层占一行
 * @author GuoJingyuan
 * @date 2020/1/13
 */
public class LevelPrintTree {

    public static void main(String[] args) {
        BinaryTreeNode f0 = new BinaryTreeNode(8);
        BinaryTreeNode fr1 = new BinaryTreeNode(6);
        BinaryTreeNode fl1 = new BinaryTreeNode(8);
        BinaryTreeNode fl21 = new BinaryTreeNode(9);
        BinaryTreeNode fl22 = new BinaryTreeNode(2);
        BinaryTreeNode f23 = new BinaryTreeNode(7);
        BinaryTreeNode f24 = new BinaryTreeNode(5);
        BinaryTreeNode fl31 = new BinaryTreeNode(4);
        BinaryTreeNode fl32 = new BinaryTreeNode(7);

        f0.right = fr1;
        fr1.left = f23;
        fr1.right = f24;
        f0.left = fl1;
        fl1.left = fl21;
        fl1.right = fl22;
        fl22.left = fl31;
        fl22.right = fl32;

        TraverseUtil.levelTraverse(f0);
        System.out.println("-f0-");
        System.out.println(f0.value);
        System.out.println("start line");
        new LevelPrintTree().printLineTree(f0);
        System.out.println("start zhi");
        new LevelPrintTree().printZhiTree(f0);
    }

    void printLineTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> nodeQueue = new ConcurrentLinkedQueue<>();
        nodeQueue.add(root);
        int nextLevel = 0;
        int printLine = 1;
        while (!nodeQueue.isEmpty()) {
            BinaryTreeNode node = nodeQueue.poll();
            if (node.left != null) {
                nodeQueue.add(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                nextLevel++;
            }
            System.out.print(node.value + "  ");
            printLine--;
            if (printLine == 0) {
                System.out.println();
                printLine = nextLevel;
                nextLevel = 0;
            }
        }
    }

    /**
     * 之字形打印，左右左右
     * 使用两个栈
     */
    void printZhiTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> nodeLeftStack = new Stack<>();
        Stack<BinaryTreeNode> nodeRightStack = new Stack<>();
        boolean flag = false;
        nodeRightStack.add(root);

        while (true) {
            if (!flag) {
                if (nodeRightStack.empty()) {
                    return;
                }
                while (!nodeRightStack.empty()) {
                    BinaryTreeNode node = nodeRightStack.pop();
                    System.out.println(root.value);
                    if (node.left != null) {
                        nodeLeftStack.add(node.left);
                    }
                    if (node.right != null) {
                        nodeLeftStack.add(node.right);
                    }
                }
                flag = !flag;
            } else {
                if (nodeLeftStack.empty()) {
                    return;
                }
                while (!nodeLeftStack.empty()) {
                    BinaryTreeNode node = nodeLeftStack.pop();
                    System.out.println(root.value);
                    if (node.right != null) {
                        nodeRightStack.add(node.right);
                    }
                    if (node.left != null) {
                        nodeRightStack.add(node.left);
                    }
                }
                flag = !flag;
            }
        }

    }

}
