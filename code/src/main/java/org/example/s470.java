package org.example;

public class s470 {
    public int rand10() {
        int row, col , idx;
        do{
            row = rand7();
            col = rand7();
            idx = col + (row-1)*7;
        }while (idx > 40);
        return 1+(idx-1)%10;
    }
    public int rand7() {
        return 1;
    }
}
