package org.example;

import java.util.*;


public class offer30 {
    Map<Integer, Integer> map;
    List<Integer> list;
    public offer30() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        int size = list.size();
        if (!map.containsKey(val)){
            map.put(val, size);
            list.add(val);

            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int size = list.size();
        if (!map.containsKey(val)){
            return false;
        }
        Integer index = map.get(val);
        int last = list.get(size-1);
        list.set(index, last);
        map.put(last, index);
        list.remove(size-1);
        map.remove(val);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
