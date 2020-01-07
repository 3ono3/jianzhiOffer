package com.jing.base;

/**
 * 判断一棵树是不是另一棵树的子树
 * @author GuoJingyuan
 * @date 2020/1/6
 */
public class SubTreeJudge {
    public static void main(String[] args) {
        BinaryTreeNode f0 = new BinaryTreeNode(8);
        BinaryTreeNode fr1 = new BinaryTreeNode(7);
        BinaryTreeNode fl1 = new BinaryTreeNode(8);
        BinaryTreeNode fl21 = new BinaryTreeNode(9);
        BinaryTreeNode fl22 = new BinaryTreeNode(2);
        BinaryTreeNode fl31 = new BinaryTreeNode(4);
        BinaryTreeNode fl32 = new BinaryTreeNode(7);

        f0.right = fr1;
        f0.left = fl1;
        fl1.left = fl21;
        fl1.right = fl22;
        fl22.left = fl32;
        fl22.right = fl31;

        BinaryTreeNode sfl1 = new BinaryTreeNode(8);
        BinaryTreeNode sfl21 = new BinaryTreeNode(9);
        BinaryTreeNode sfl22 = new BinaryTreeNode(2);
        sfl1.left = sfl21;
        sfl1.right = sfl22;

        boolean result = new SubTreeJudge().haveTree(f0, sfl1);
        System.out.println(result);
    }

    boolean haveTree(BinaryTreeNode treeFather, BinaryTreeNode treeSub) {
        boolean result = false;

        if (treeFather != null && treeSub != null) {
            if (treeFather.value == treeSub.value) {
                result = judge(treeFather, treeSub);
            }
            if (!result) {
                result = haveTree(treeFather.left, treeSub);
            }
            if (!result) {
                result = haveTree(treeFather.right, treeSub);
            }
        }

        return result;
    }

    boolean judge(BinaryTreeNode treeFather, BinaryTreeNode treeSub) {
        if (treeSub == null) {
            return true;
        }
        if (treeFather == null) {
            return false;
        }
        if (treeFather.value != treeSub.value) {
            return false;
        }
        return judge(treeFather.left, treeSub.left) && judge(treeFather.right, treeSub.right);
    }


}
