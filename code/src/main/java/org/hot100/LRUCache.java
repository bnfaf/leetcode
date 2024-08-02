package org.hot100;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int value;
    Node prefix;
    Node next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    int size;
    LRUCache(int capacity){
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prefix = head;
        this.capacity = capacity;
        this.size = 0;
    }
    public int get(int key){
        Node node = map.get(key);
        if (node != null){
            remove(node);
            addFirst(node);
            return node.value;
        }else{
            return -1;
        }
    }
    public void put(int key, int value){
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
        }else{
            Node node = new Node(key, value);
            addFirst(node);
            this.size++;
            if (this.size == capacity){
                int last = removeLast();
                map.remove(last);
                size--;

            }
        }
    }
    private void remove(Node node){
        node.prefix.next = node.next;
        node.next.prefix = node.prefix;
    }
    private void addFirst(Node node){
        node.next = head.next;
        head.next.prefix = node;
        node.prefix = head;
    }
    private int  removeLast(){
        Node node = tail.prefix;
        remove(node);
        return node.key;

    }
}
