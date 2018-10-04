package ua.com.juja.permutation;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Итератор перестановок чисел переданого массива
 * от восходящей перестановки до нисходящей.
 * Например:
 * [0, 1, 2, 3] -> [0, 1, 3, 2] -> [0, 2, 1, 3] -> ...
 * ... -> [3, 2, 1, 0] -> [3, 2, 1, 0]
 */
final class NumberIterator implements Iterator<int[]> {

    private final int[] numbers;
    private boolean hasNext;
    // Для хранения текущего набора.
    private int[] iteration;

    NumberIterator(final int[] numbers) {
        this.numbers = numbers;
        if (isNotEmpty(this.numbers)) {
            Arrays.sort(this.numbers);
            this.iteration = new int[this.numbers.length];
            this.hasNext = true;
        }
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public int[] next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.iteration = getNext();
        toNext();
        return this.iteration;
    }

    private int[] getNext() {
        this.hasNext = false;
        return this.numbers.clone();
    }

    private void toNext() {
        for (int i = this.numbers.length - 1; i > 0; i--) {
            if (this.numbers[i - 1] < this.numbers[i]) {
                swapLastMinWithAt(i);
                reversLastFrom(i);
                this.hasNext = true;
                break;
            }
        }
    }

    private void swapLastMinWithAt(final int index) {
        int lastMin = this.numbers.length - 1;
        while (this.numbers[index - 1] >= this.numbers[lastMin]) {
            lastMin--;
        }
        swapNumbers(index - 1, lastMin);
    }

    private void reversLastFrom(final int index) {
        for (int i = index, j = this.numbers.length - 1; i < j; i++, j--) {
            swapNumbers(i, j);
        }
    }

    private void swapNumbers(final int i, final int j) {
        final int temp = this.numbers[i];
        this.numbers[i] = this.numbers[j];
        this.numbers[j] = temp;
    }

    private boolean isNotEmpty(final int[] array) {
        return (array != null) && (array.length > 0);
    }
}
