package org.example;

import java.util.HashMap;
import java.util.Map;

public class S8 {
    public int myAtoi(String s) {
        int res = 0, i = 0, flag = 1;
        if (s.length() == 0){
            return 0;
        }
        while (i<s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()){
            return 0;
        }
        if (s.charAt(i) =='-'){
            flag = -1;
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        System.out.println(flag);
        while (i < s.length() && Character.isDigit(s.charAt(i))){
            int r = s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && r > 7)){
                return flag > 0?Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + r;
            i++;
        }
        return flag > 0 ? res:-res;
    }
}


class Automation{
    public int sign = 1;
    public long ans = 0;
    private String state = "state";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c){
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)){
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }
    private int get_col(char c){
        if (c == ' '){
            return 0;
        }
        if (c == '+' || c == '-'){
            return 1;
        }
        if (Character.isDigit(c)){
            return 2;
        }
        return 3;

    }

}