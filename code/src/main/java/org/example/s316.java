package org.example;

public class s316 {
    public String removeDuplicateLetters(String s) {
        boolean[] visit = new boolean[26];
        int[] nums = new int[26];
        for(char c:s.toCharArray()){
            nums[c - 'a'] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!visit[c - 'a']){
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > s.charAt(i)){
                    if (nums[sb.charAt(sb.length() - 1) - 'a'] > 0){
                        visit[sb.charAt(sb.length() - 1) - 'a']  = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }else{
                        break;
                    }
                }
                sb.append(s.charAt(i));
                visit[c - 'a'] = true;
            }
            nums[c - 'a'] -= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        s316 solution = new s316();
        System.out.println(solution.removeDuplicateLetters(s));
    }
}
