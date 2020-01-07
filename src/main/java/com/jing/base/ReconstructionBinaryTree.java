package com.jing.base;

import java.util.HashMap;
import java.util.Map;

public class ReconstructionBinaryTree {

    public static void main(String[] args) {
        int[] preNodeVal = {1,2,4,7,3,5,6,8};
        int[] midNodeVal = {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = new ReconstructionBinaryTree().getBinaryTree(preNodeVal, midNodeVal);
    }
    Map<Integer, Integer> midValInx = null;
    public BinaryTreeNode getBinaryTree(int[] preNodeVal, int[] middleNodeVal) {
        midValInx = new HashMap<Integer, Integer>((int) ((middleNodeVal.length/0.7) + 1));
        for (int i = 0; i < middleNodeVal.length; i++) {
            midValInx.put(middleNodeVal[i], i);
        }
        BinaryTreeNode root = buildTree(preNodeVal, middleNodeVal, 0, 0, middleNodeVal.length-1);
        return root;
    }
    public BinaryTreeNode buildTree(int[] preNode, int[] midNode, int headInd, int midStrInd, int midEndInd) {
        if (midStrInd > midEndInd) {
            return null;
        }
        if (midStrInd == midEndInd) {
            return new BinaryTreeNode(midNode[midStrInd]);
        }
        int rootNodeVal = preNode[headInd];
        BinaryTreeNode node = new BinaryTreeNode(rootNodeVal);
        int midIndex = midValInx.get(rootNodeVal);
        node.left = buildTree(preNode, midNode, headInd+1, midStrInd, midIndex-1);
        node.right = buildTree(preNode, midNode, midIndex+1, midIndex+1, midEndInd);
        return node;
    }
}
