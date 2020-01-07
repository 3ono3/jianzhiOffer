package com.jing.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 矩阵中的路径
 * 回溯法
 * @author GuoJingyuan
 * @date 2019/10/18
 */
public class RectanglePath {
    public static void main(String[] args) {
        char[][] data = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}};
        List<String> match = new LinkedList<>();
        boolean x = new RectanglePath().have(data, "bfce", match);
        System.out.println(x);
        if (x) {
            for (String m : match) {
                System.out.print(m + "; ");
            }
        }

    }
    boolean have(char[][] data, String target, List<String> match) {
        Stack<List<Integer>> stack = new Stack<>();
        char[] targetAry = target.toCharArray();
        int num = data.length;
        if (num < 1) {
            return false;
        }
        int len = data[0].length;
        int targetIndex = 0;
        char tc = targetAry[targetIndex];
        int fi = 0, fj = 0;
        boolean hf = false;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < len; j++) {
                if (data[i][j] == tc) {
                    fi = i;
                    fj = j;
                    push(stack, fi, fj);
                    hf = true;
                }
            }
        }
        if (!hf) {
            return false;
        }
        match.add(fi + "," + fj);
        while (targetIndex < targetAry.length - 1) {
            targetIndex++;
            tc = targetAry[targetIndex];
            //上
            if (fi > 0) {
                if (tc == data[fi - 1][fj]) {
                    --fi;
                    match.add(fi + "," + fj);
                    push(stack, fi, fj);
                    continue;
                }
            }
            //右
            if (fj < len) {
                if (tc == data[fi][fj + 1]) {
                    ++fj;
                    match.add(fi + "," + fj);
                    push(stack, fi, fj);
                    continue;
                }
            }
            //下
            if (fi < num-1) {
                if (tc == data[fi + 1][fj]) {
                    ++fi;
                    match.add(fi + "," + fj);
                    push(stack, fi, fj);
                    continue;
                }
            }
            //左
            if (fj > 0) {
                if (tc == data[fi][fj - 1]) {
                    --fj;
                    match.add(fi + "," + fj);
                    push(stack, fi, fj);
                    continue;
                }
            }

            if (stack.empty()) {
                return false;
            }
            ((LinkedList<String>) match).removeLast();
            targetIndex--;
            List<Integer> lastMatch = stack.pop();
            fi = lastMatch.get(0);
            fj = lastMatch.get(1);
        }
        return true;
    }
    void push(Stack <List<Integer>> stack, int i, int j) {
        List<Integer> adL = new ArrayList<>();
        adL.add(i);
        adL.add(j);
        stack.push(adL);
    }
}
