package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;
import sun.security.krb5.internal.TGSRep;

import java.util.*;
import java.util.stream.Collectors;

public class s501 {
    public int[] findMode(TreeNode root) {
        TreeNode pre = null, cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        int maxCount = 0, count = 0;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (pre == null || cur.val != pre.val){
                    count = 1;
                }else{
                    count++;
                }
                if (count > maxCount){
                    maxCount = count;
                    res.clear();
                    res.add(cur.val);
                } else if (count == maxCount) {
                    res.add(cur.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }
}
