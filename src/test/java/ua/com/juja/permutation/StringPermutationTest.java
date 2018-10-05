package ua.com.juja.permutation;

import org.junit.Test;

import java.util.Collection;
import java.util.Random;

import static org.junit.Assert.*;

public class StringPermutationTest {

    @Test
    public void whenCreateThenReturnAllPermutations() {
        final String str = "algorithm";
        final int actualPermutationsSize = 362880;
        final Collection<String> permutations = new StringPermutation().create(str);
        assertEquals(actualPermutationsSize, permutations.size());
    }

    @Test
    public void whenCallCreateWithNullStrThenReturnEmptyCollection() {
        mustReturnEmptyCollectionFor(null);
    }

    @Test
    public void whenCallCreateWithEmptyStrThenReturnEmptyCollection() {
        mustReturnEmptyCollectionFor("");
    }

    @Test
    public void whenStrWithSimpleCharThenReturnSinglePermutation() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.abs(new Random().nextInt(100)); i++) {
            sb.append("a");
        }
        final Collection<String> permutations = new StringPermutation().create(sb.toString());
        assertEquals(1, permutations.size());
    }

    private void mustReturnEmptyCollectionFor(final String str) {
        final Permutation<String> permutation = new StringPermutation();
        final Collection<String> permutations = permutation.create(str);
        assertEquals(0, permutations.size());
    }
}