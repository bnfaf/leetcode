package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class s904 {
    public int totalFruit(int[] fruits) {

        ArrayList<Integer> store = new ArrayList<Integer>();
        int length = 0;
        int left = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (store.size() < 2 ){
                if (!store.contains(fruits[i])){
                    store.add(fruits[i]);
                }
                
            } else if (store.size() == 2) {
                if (!store.contains(fruits[i])) {
                    length = i - left > length ? i - left : length;
                    left = i-1;
                    store.clear();
                    store.add(fruits[i-1]);
                    store.add(fruits[i]);
                    while (fruits[left-1] == fruits[i-1]){
                        left--;
                    }
                }
            }
        }
        length = fruits.length - left > length ? fruits.length - left : length;
        return length;
    }
}
