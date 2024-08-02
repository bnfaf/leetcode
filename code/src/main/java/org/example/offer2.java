package org.example;

import java.util.ArrayList;
import java.util.List;

public class offer2 {
    public String addBinary(String a, String b) {
        List<Integer> list = new ArrayList<>();
        int m = a.length()-1;
        int n = b.length()-1;
        int carry = 0;
        while (m >=0 || n >= 0){
            int p = m >= 0 ? Integer.parseInt(String.valueOf(a.charAt(m))):0;
            int q = n >= 0 ? Integer.parseInt(String.valueOf(b.charAt(n))):0;
            int res = p + q + carry;
            list.add(res%2);
            carry = res / 2;
            m -= 1;
            n -= 1;
        }
        if (carry == 1){
            list.add(carry);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size()-1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        offer2 solution = new offer2();
        System.out.println(solution.addBinary("1", "1"));
    }
}
