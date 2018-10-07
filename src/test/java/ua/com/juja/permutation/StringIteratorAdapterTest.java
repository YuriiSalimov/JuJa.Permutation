package ua.com.juja.permutation;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StringIteratorAdapterTest {

    @Test
    public void alwaysGenerateUniqueString() {
        final String str = "aabbcc";
        final StringIteratorAdapter sia = create(str);
        final Collection<String> allStrings = new HashSet<>();
        while (sia.hasNext()) {
            final String temp = sia.next();
            assertFalse(allStrings.contains(temp));
            allStrings.add(temp);
        }
    }

    @Test
    public void forEqualsCharsGenerateOneString() {
        final String str = "aaaaa";
        final StringIteratorAdapter sia = create(str);
        int count = 0;
        while (sia.hasNext()) {
            count++;
            sia.next();
        }
        assertEquals(count, 1);
    }


    private StringIteratorAdapter create(final String str) {
        return new StringIteratorAdapter(
                new CharsIteratorAdapter(
                        str.toCharArray(),
                        new NumberIterator(createCharacterIndexes(str))
                )
        );
    }

    private int[] createCharacterIndexes(final String str) {
        final int[] indexes = new int[str.length()];
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer index = map.get(str.charAt(i));
            if (index == null) {
                map.put(str.charAt(i), i);
                index = i;
            }
            indexes[i] = index;
        }
        return indexes;
    }
}