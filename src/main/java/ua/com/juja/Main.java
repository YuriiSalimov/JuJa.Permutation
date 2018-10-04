package ua.com.juja;

import ua.com.juja.permutation.Permutation;
import ua.com.juja.permutation.StringPermutation;

public class Main {

    public static void main(String[] args) {
        final String str = "algorithm";
        final Permutation<String> permutation = new StringPermutation();
        permutation.print(str);
        analyzeCreate(permutation, str);
    }

    /**
     * Подсчитывает и выводит среднее время (100 итерация)
     * создания перестановок переданой строки.
     */
    private static void analyzeCreate(final Permutation<String> permutation, final String str) {
        final int iterationNumbers = 100;
        long time = 0;
        for (int i = 0; i < iterationNumbers; i++) {
            time -= System.currentTimeMillis();
            permutation.create(str);
            time += System.currentTimeMillis();
        }
        System.out.println("Analyze CREATE time: " + (time / iterationNumbers) + " ms");
    }
}
