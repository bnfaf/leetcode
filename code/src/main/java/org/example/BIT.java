package org.example;
// 树状数组模板
public class BIT {
    private final int[] tree;
    BIT(int n){
        tree = new int[n];
    }
    // 下标i上的数+1
    public void inc(int i){
        while (i < tree.length){
            this.tree[i] += 1;
            i += i & -i;
        }
    }
    public int sum(int i){
        int res = 0;
        while (i > 0){
            res += tree[i];
            i &= i-1; // i & i-1 将最低位的1改为0 等价与i -= i & -i
        }
        return res;
    }
    public int query(int left, int right){
        return sum(right) - sum(left-1);
    }
}
