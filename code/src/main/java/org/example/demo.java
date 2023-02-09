package org.example;

public class demo {
    public static void main(String[] args) {
        Other o = new Other();
        final int i = new demo().addOne(1);
        System.out.println(i);
    }

    public int addOne(final int x) {
        return x + 1;
    }


}
class Other {
    public int i;
}