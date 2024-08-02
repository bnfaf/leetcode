package org.example;

public class S2696 {
    public int minLength(String s) {
        boolean flag;
        while(s.length()>0){
            flag = true;
            if (s.contains("AB")){
                s = s.replaceAll("AB", "");
                flag = false;
            }
            if (s.contains("CD")){
                s = s.replaceAll("CD", "");
                flag = false;
            }
            if (flag){
                break;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        String s = "ABFCACDB";
        S2696 s2696 = new S2696();
        System.out.println(s2696.minLength(s));
    }
}
