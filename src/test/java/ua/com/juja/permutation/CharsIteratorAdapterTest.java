package ua.com.juja.permutation;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CharsIteratorAdapterTest {

    private final char[] array = {'a', 'b', 'c', 'd'};

    @Test
    public void checkPermutationsSize() {
        checkPermutationsSizeFor(new ArrayList<>());
    }

    @Test
    public void whenCallCreateThenReturnUniqueCollection() {
        checkPermutationsSizeFor(new HashSet<>());
    }

    private void checkPermutationsSizeFor(final Collection<String> permutations) {
        final Iterator<char[]> iterator = new CharsIteratorAdapter(getArray(), getIndexIterator());
        while(iterator.hasNext()) {
            permutations.add(String.valueOf(iterator.next()));
        }
        assertEquals(getPermutationsSize(), permutations.size());
    }

    private char[] getArray() {
        return this.array.clone();
    }

    private int getPermutationsSize() {
        final Set<Character> set = new HashSet<>();
        for (char c : getArray()) {
            set.add(c);
        }
        int size = 1;
        for (int i = 1; i <= set.size(); i++) {
            size *= i;
        }
        return size;
    }

    private Iterator<int[]> getIndexIterator() {
        return new NumberIterator(toInts(getArray()));
    }

    private int[] toInts(final char[] chars) {
        final int[] indexes = new int[chars.length];
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Integer index = map.get(chars[i]);
            if (index == null) {
                map.put(chars[i], i);
                index = i;
            }
            indexes[i] = index;
        }
        return indexes;
    }
}
