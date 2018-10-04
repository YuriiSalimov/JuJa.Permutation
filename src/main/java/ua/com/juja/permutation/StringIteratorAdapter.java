package ua.com.juja.permutation;

import java.util.Iterator;

/**
 * Адаптер для итератора массивов символов.
 * Возвращает строковое представление массива символов
 * заданого итератора.
 */
final class StringIteratorAdapter implements Iterator<String> {

    private final Iterator<char[]> charsIterator;

    StringIteratorAdapter(final Iterator<char[]> charsIterator) {
        this.charsIterator = charsIterator;
    }

    @Override
    public boolean hasNext() {
        return this.charsIterator.hasNext();
    }

    @Override
    public String next() {
        return String.valueOf(this.charsIterator.next());
    }
}
