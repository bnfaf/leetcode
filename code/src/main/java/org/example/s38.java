package org.example;

public class s38 {
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        StringBuilder sb = new StringBuilder("1");
        int[] arr = new int[10];
        for (int i = 2; i <=n; i++ ) {
            int length = sb.length();
            int left = 0, right = 0;
            while (right < length){
                if (right+1<length && sb.charAt(right+1) == sb.charAt(left)){
                    right++;
                }else{
                    sb.append(right-left+1);
                    sb.append(sb.charAt(left));
                    left = right+1;
                    right = left;
                }
            }
            sb.delete(0, length);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        s38 solution = new s38();
        System.out.println(solution.countAndSay(5));
    }
}
