package org.example;

import com.sun.java.swing.plaf.windows.WindowsTabbedPaneUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class s301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<String>();
        Set<String> currSet = new HashSet<String>();
        currSet.add(s);
        while (true) {
            for (String str: currSet){
                if (isValid(str)){
                    ans.add(str);
                }
            }
            if (ans.size() > 0){
                return ans;
            }
            Set<String> nextSet = new HashSet<String>();
            for (String str: currSet) {
                for (int i = 0; i<str.length();i++){
                    if (i>0&&str.charAt(i) == str.charAt(i-1)){
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')'){
                        nextSet.add(str.substring(0, i) + str.substring(i+1));
                    }
                }
            }
            currSet = nextSet;
        }
    }
    public boolean isValid(String str){
        char[] ss = str.toCharArray();
        int count = 0;

        for (char c : ss) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}
