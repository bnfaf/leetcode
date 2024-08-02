package org.example;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class s752 {
    public int openLock(String[] deadends, String target) {
        String begin = "0000";
        Deque<String> deque = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains(begin)){
            return -1;
        }
        set.add(begin);
        deque.add(begin);
        int num = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-- > 0){
                StringBuilder sb = new StringBuilder(deque.pollFirst());
                if (sb.toString().equals(target)){
                    return num;
                }
                for (int i = 0; i < 4; i++){
                    if (sb.charAt(i) < '9'){
                        sb.setCharAt(i, (char) (sb.charAt(i)+1));
                        if (!set.contains(sb.toString())){
                            deque.addLast(sb.toString());
                            set.add(sb.toString());
                        }
                        sb.setCharAt(i, (char) (sb.charAt(i)-1));
                    }else{
                        sb.setCharAt(i, '0');
                        deque.addLast(sb.toString());
                        if (!set.contains(sb.toString())){
                            deque.addLast(sb.toString());
                            set.add(sb.toString());
                        }
                        sb.setCharAt(i, '9');
                    }
                    if (sb.charAt(i) > '0'){
                        sb.setCharAt(i, (char) (sb.charAt(i)-1));
                        if (!set.contains(sb.toString())){
                            deque.addLast(sb.toString());
                            set.add(sb.toString());
                        }
                        sb.setCharAt(i, (char) (sb.charAt(i)+1));
                    }else{
                        sb.setCharAt(i, '9');
                        if (!set.contains(sb.toString())){
                            deque.addLast(sb.toString());
                            set.add(sb.toString());
                        }
                        sb.setCharAt(i, '0');
                    }
                }
            }
            num += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] dead = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        s752 solution = new s752();
        System.out.println(solution.openLock(dead, target));
    }
}
