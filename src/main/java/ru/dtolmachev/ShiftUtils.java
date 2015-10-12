package ru.dtolmachev;

import ru.dtolmachev.model.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunlight on 12.10.15.
 */
public class ShiftUtils {

    /**
     * This method makes a circular right shift on a source list.
     * Source list is not modified, new list is created
     *
     * @param source - source list of shapes, should not be null
     * @param shift - shift value, should be >= 0
     * @return circular shifted list of shapes
     */
    public static List<Shape> shift(final ArrayList<Shape> source, final int shift) {

        if(source == null) {
            throw new IllegalArgumentException("list of shapes should not be null");
        }

        if(shift < 0) {
            throw new IllegalArgumentException("shift should be >= 0");
        }

        final Shape[] result = new Shape[source.size()];
        for(int i = 0; i < source.size(); i++) {
            final Shape sh = source.get(i);
            if(sh == null) {
                throw new IllegalArgumentException("shape should not be null");
            }
            final int newIndex = getNewIndex(i, shift, source.size());
            result[newIndex] = sh;
        }

        return Arrays.asList(result);
    }


    private static int getNewIndex(final int curIndex, final int shift, final int totalSize) {
        final long i = ((long) curIndex + shift);
        return (int) (i % totalSize);
    }
}
