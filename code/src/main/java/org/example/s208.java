package org.example;

/**
 * 前缀树
 */
public class s208 {
    private s208[] children;
    private boolean isEnd;

    public s208() {
        children = new s208[26];
        isEnd = false;
    }

    public void insert(String word) {
        s208 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null){
                node.children[index] = new s208();
            }
            node = node.children[index];
        }
        node.isEnd = true;

    }

    public boolean search(String word) {
        s208 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    private s208 searchPrefix(String prefix) {
        s208 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
