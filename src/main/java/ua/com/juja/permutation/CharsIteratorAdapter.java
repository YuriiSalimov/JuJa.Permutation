package ua.com.juja.permutation;

import java.util.Iterator;

/**
 * Итератор перестановок символов переданого массива.
 * Из переданного итератора получает массив чисел.
 * Используя этот массив как индексы в массиве символов,
 * выбирает новый набор символов (новая перестановка).
 * Пример для [a, b, c, d]:
 * Значение итератора -> новая перестановка:
 * [1, 2, 0, 3] -> [b, c, a, d]
 * [0, 2, 3, 1] -> [a, c, d, b]
 */
final class CharsIteratorAdapter implements Iterator<char[]> {

    private final char[] chars;
    private final Iterator<int[]> indexIterator;
    private final char[] iteration;

    CharsIteratorAdapter(
            final char[] chars,
            final Iterator<int[]> indexIterator
    ) {
        this.chars = chars.clone();
        this.indexIterator = indexIterator;
        this.iteration = new char[this.chars.length];
    }

    @Override
    public boolean hasNext() {
        return this.indexIterator.hasNext();
    }

    @Override
    public char[] next() {
        return createChars(getNextIndexes());
    }

    private int[] getNextIndexes() {
        return this.indexIterator.next();
    }

    private char[] createChars(final int[] indexes) {
        for (int i = 0; i < this.iteration.length; i++) {
            this.iteration[i] = this.chars[indexes[i]];
        }
        return this.iteration;
    }
}
