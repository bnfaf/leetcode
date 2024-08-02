package org.example;

public class S2496 {
    public int maximumValue(String[] strs) {
        int res = 0;
        for (String s: strs){

            res = Math.max(res, getInt(s));
        }
        return res;
    }

    public int getInt(String s){
        try {
            return Integer.parseInt(s);
        }catch (NumberFormatException e) {
            return s.length();
        }
    }

    public static void main(String[] args) {
        S2496 s2496 = new S2496();
        String[] strs = {"alic3","bob","3","4","00000"};
        System.out.println(s2496.maximumValue(strs));
    }
}
