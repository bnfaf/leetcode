package org.example;

public class s541 {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int start = 0;
        int length = s.length();
        while (start < length){
            StringBuilder tmp = new StringBuilder();
            int firstK = (start + k > length) ? length : start + k;
            int secondK = (start + (2 * k) > length) ? length : start + (2 * k);
            tmp.append(s.substring(start, firstK));
            res.append(tmp.reverse());
            if (firstK < secondK){
                res.append(s.substring(firstK, secondK));
                start += 2 * k;
            }
        }
        return res.toString();
    }

}
