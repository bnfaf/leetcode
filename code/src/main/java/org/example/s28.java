package org.example;

public class s28 {
    /**
     * KMP 减1实现
     * next[k]=m => [0,m] = [k-m, k]
     * 若不减1，则有[0, next[j]) = [k-next[j], k)
     * @param next
     * @param s
     */
    public void getNext(int[] next, String s){
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++){
            while(j >= 0 && s.charAt(i) != s.charAt(j+1)){
                /**
                 * j >=0 时有[0，j]=[i-1-j, i-1],由next[j]=>[0, next[j]]=[j-next[j],j]
                 * 进行变换时，需要满足[0,m]=[i-1-m. i-1]，j>=next[j]所以有j=next[j]进行探查寻找
                 *
                 *
                 */
                j=next[j];
            }

            if(s.charAt(i) == s.charAt(j+1)){
                j++;
            }
            next[i] = j;
        }
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i < haystack.length(); i++){
            while(j>=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if(j == needle.length()-1){
                return (i-needle.length()+1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        s28 solution = new s28();
        System.out.println(solution.strStr("aabaaabaaac", "aaabaaac"));
    }
}
