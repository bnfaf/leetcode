package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < words.length){
            List<String> temp = new ArrayList<>();
            int length = 0;
            while (index < words.length&&length + temp.size()-1+words[index].length() <=maxWidth){
                temp.add(words[index]);
                length += words[index].length();
                index++;
            }
            int num;
            if ((maxWidth - length) % (Math.max(temp.size()-1, 1)) == 0){
                num = (maxWidth - length) / (Math.max(temp.size()-1, 1));
            }else{
                num = (maxWidth - length) / (Math.max(temp.size()-1, 1)) + 1;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< temp.size(); i++){
                sb.append(temp.get(i));
                for (int j = 0; j < Math.min(num, maxWidth - length-i*num); j++) {
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        s68 solution = new s68();
        System.out.println(solution.fullJustify(words, 16));
    }
}
