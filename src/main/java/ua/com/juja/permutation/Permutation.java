package ua.com.juja.permutation;

import java.util.Collection;

public interface Permutation<T> {

    /**
     * Возвращает коллекцию всех перестановок переданой строки.
     */
    Collection<T> create(T str);

    /**
     * Печатает в консоль все перестановки переданой строки.
     */
    void print(T str);
}
