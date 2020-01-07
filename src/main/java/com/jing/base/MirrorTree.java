package com.jing.base;

import com.jing.base.traverse.tree.TraverseUtil;

/**
 * 树的镜像
 * @author GuoJingyuan
 * @date 2020/1/7
 */
public class MirrorTree {
    public static void main(String[] args) {

        BinaryTreeNode f0 = new BinaryTreeNode(8);
        BinaryTreeNode fr1 = new BinaryTreeNode(6);
        BinaryTreeNode fl1 = new BinaryTreeNode(8);
        BinaryTreeNode fl21 = new BinaryTreeNode(9);
        BinaryTreeNode fl22 = new BinaryTreeNode(2);
        BinaryTreeNode fl31 = new BinaryTreeNode(4);
        BinaryTreeNode fl32 = new BinaryTreeNode(7);

        f0.right = fr1;
        f0.left = fl1;
        fl1.left = fl21;
        fl1.right = fl22;
        fl22.left = fl31;
        fl22.right = fl32;

        TraverseUtil.levelTraverse(f0);
        System.out.println();
        System.out.println("-f0-");
        System.out.println(f0.value);
        BinaryTreeNode mirrorTree = new MirrorTree().getMirror(f0);
        System.out.println("-mir-");
        System.out.println(mirrorTree.value);
        TraverseUtil.levelTraverse(mirrorTree);
    }

    BinaryTreeNode getMirror(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        BinaryTreeNode right = root.right;
        root.right = root.left;
        root.left = right;
        getMirror(root.left);
        getMirror(root.right);

        return root;
    }
}
