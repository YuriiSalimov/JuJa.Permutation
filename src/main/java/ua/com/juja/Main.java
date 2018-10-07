package ua.com.juja;

import ua.com.juja.permutation.Permutation;
import ua.com.juja.permutation.StringPermutation;

public class Main {

    public static void main(String[] args) {
        final String str = "algorithm";
        final Permutation permutation = new StringPermutation();
        permutation.print(str);
    }
}
