package org.example;

import java.util.HashMap;
import java.util.Map;

class Nodes{
    int key;
    int value;
    Nodes prefix;
    Nodes next;
    Nodes(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class s146 {

    Nodes head;
    Nodes tail;
    Map<Integer, Nodes> map;
    int capacity;
    int size;


    public s146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Nodes(0, 0);
        tail = new Nodes(0, 0);
        head.next = tail;
        tail.prefix = head;
        size = 0;
    }

    public int get(int key) {
        Nodes node = map.get(key);
        if (node != null){
            delete(node);
            addFirst(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        Nodes node = map.get(key);
        if(node!=null){
            node.value = value;
            delete(node);
            addFirst(node);
        }else{
            node = new Nodes(key, value);
            map.put(key, node);
            addFirst(node);
            size++;
            if (size > capacity){
                int s = removeLast();
                map.remove(s);
                size--;
            }
        }
    }
    public void delete(Nodes node){
        node.prefix.next = node.next;
        node.next.prefix = node.prefix;
    }
    public void addFirst(Nodes node){
        node.next = head.next;
        head.next.prefix = node;
        head.next = node;
        node.prefix = head;
    }
    public int removeLast(){
        Nodes node = tail.prefix;
        delete(node);
        return node.key;
    }
}
