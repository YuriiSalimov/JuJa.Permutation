package ua.com.juja.permutation;

import java.util.*;

/**
 * Класс описывает набор методов для создания
 * всех возможных перестановок переданой строки,
 * для получения которых нужно перебрать все
 * варианты перестановок массива символов этой строки.
 * Для перебора уникальных перестановок массива символов
 * используется итератор перебора индексов уникальных
 * символов строки.
 */
public final class StringPermutation implements Permutation {
    
    @Override
    public void print(final String str) {
        if (isNotEmpty(str)) {
            final Iterator<String> permutationIterator = createStringIterator(str);
            while (permutationIterator.hasNext()) {
                System.out.println(permutationIterator.next());
            }
        }
    }

    private Iterator<String> createStringIterator(final String str) {
        return new StringIteratorAdapter(
                new CharsIteratorAdapter(
                        str.toCharArray(),
                        new NumberIterator(createCharacterIndexes(str))
                )
        );
    }

    /**
     * Создает массив индексов для символов строки.
     * Учитывает повторение символов.
     * Это нужно для того, убрать провторение итераций
     * при повторении символов в переданой строке.
     * Пример:
     * "abcde" -> [0, 1, 2, 3, 4];
     * "aaade" -> [0, 0, 0, 3, 4];
     */
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

    private boolean isNotEmpty(final String str) {
        return (str != null) && (!str.isEmpty());
    }
}
