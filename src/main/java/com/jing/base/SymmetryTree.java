package com.jing.base;

import java.util.LinkedList;

/**
 * 树是不是对称树(按中线对称)
 * 中 -> 左 -》 右 遍历
 * 中 -》 右 -》 左 遍历
 * 顺序相同
 * @author GuoJingyuan
 * @date 2020/1/7
 */
public class SymmetryTree {

    public static void main(String[] args) {
        SymmetryTree st = new SymmetryTree();

        BinaryTreeNode f0 = new BinaryTreeNode(7);
        BinaryTreeNode f11 = new BinaryTreeNode(7);
        BinaryTreeNode f12 = new BinaryTreeNode(7);
        BinaryTreeNode f21 = new BinaryTreeNode(7);
        BinaryTreeNode f22 = new BinaryTreeNode(7);
        BinaryTreeNode f23 = new BinaryTreeNode(7);
        BinaryTreeNode f24 = new BinaryTreeNode(7);
        f0.left = f11;
        f0.right = f12;
        f11.left = f21;
        f11.right = f22;
        f12.left = f23;
//        f12.right = f24;

        LinkedList<String> leftList = st.leftRight(new LinkedList<>(), f0);
        LinkedList<String> rightList = st.rightLeft(new LinkedList<>(), f0);

        if (leftList == null || rightList == null || leftList.size() != rightList.size()) {
            System.out.println("false");
            return;
        }
        for (int i = 0; i < rightList.size(); i++) {
            if (!leftList.get(i).equals(rightList.get(i))) {
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
        return;
    }
    private LinkedList<String> leftRight(LinkedList<String> nodeList, BinaryTreeNode root) {
        if (root == null) {
            nodeList.add("null");
            return nodeList;
        }
        nodeList.add(String.valueOf(root.value));
        leftRight(nodeList, root.left);
        leftRight(nodeList, root.right);
        return nodeList;
    }
    
    private LinkedList<String> rightLeft(LinkedList<String> nodeList, BinaryTreeNode root) {
        if (root == null) {
            nodeList.add("null");
            return nodeList;
        }
        nodeList.add(String.valueOf(root.value));
        rightLeft(nodeList, root.right);
        rightLeft(nodeList, root.left);
        return nodeList;
    }
}
