package ua.com.juja.permutation;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class NumberIteratorTest {

    @Test
    public void whenAddNullArrayThenSetHasNextFalse() {
        assertFalse(new NumberIterator(null).hasNext());
    }

    @Test
    public void whenAddEmptyArrayThenSetHasNextFalse() {
        assertFalse(new NumberIterator(new int[0]).hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void throwExceptionWhenNotHasNextAndCallNext() {
        new NumberIterator(null).next();
    }

    @Test
    public void checkPermutationsSize() {
        checkPermutationsSizeFor(new ArrayList<>());
    }

    @Test
    public void whenCallCreateThenReturnUniqueCollection() {
        checkPermutationsSizeFor(new HashSet<>());
    }

    private void checkPermutationsSizeFor(final Collection<int[]> permutations) {
        final int[] array = {1, 2, 3, 4};
        final int actualPermutationsSize = 24;
        final Iterator<int[]> iterator = new NumberIterator(array);
        while(iterator.hasNext()) {
            permutations.add(iterator.next());
        }
        assertEquals(actualPermutationsSize, permutations.size());
    }
}