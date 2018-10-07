package ua.com.juja.permutation;

import org.junit.Test;

public class StringPermutationTest {

    @Test
    public void whenAddNullStrThenDoNotThrowException() {
        new StringPermutation().print(null);
    }

    @Test
    public void whenAddEmptyStrThenDoNotThrowException() {
        new StringPermutation().print("");
    }
}