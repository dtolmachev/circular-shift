/**
 * Created by sunlight on 12.10.15.
 */

import org.junit.Test;
import ru.dtolmachev.ShiftUtils;
import ru.dtolmachev.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShiftUtilsTestSuits {

    @Test(expected = IllegalArgumentException.class)
    public void shiftWithNullListTest() {
        ShiftUtils.shift(null, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shiftWithNegativeValueTest() {
        final ArrayList<Shape> source = new ArrayList<>(
                Arrays.asList(
                        new Shape[]{new Circle(), new Triangle(), new Square()}
                )
        );
        ShiftUtils.shift(source, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shiftWithNegativeValueAndNullListTest() {
        ShiftUtils.shift(null, -3);
    }

    @Test
    public void shiftWithZeroShiftTest() {
        final ArrayList<Shape> source = new ArrayList<>(
                Arrays.asList(
                        new Shape[]{new Circle(), new Triangle(), new Square()}
                )
        );
        final List<Shape> result = ShiftUtils.shift(source, 0);
        assertEquals(source, result);
    }

    @Test
    public void shiftWithShiftOfTwoTest() {
        final ArrayList<Shape> source = new ArrayList<>(
                Arrays.asList(
                        new Shape[]{new Circle(), new Triangle(), new Square(), new Rhomb()}
                )
        );
        final List<Shape> result = ShiftUtils.shift(source, 2);

        assertEquals(
                new ArrayList<>(
                        Arrays.asList(
                                new Shape[]{new Square(), new Rhomb(), new Circle(), new Triangle()}
                        )
                ), result);
    }

    @Test
    public void shiftWithShiftMoreThanCollectionSizeTest() {
        final ArrayList<Shape> source = new ArrayList<>(
                Arrays.asList(
                        new Shape[]{new Circle(), new Triangle(), new Square(), new Rhomb()}
                )
        );
        final List<Shape> result = ShiftUtils.shift(source, 25);

        assertEquals(
                new ArrayList<>(
                        Arrays.asList(
                                new Shape[]{new Rhomb(), new Circle(), new Triangle(), new Square()}
                        )
                ), result);
    }

    @Test
    public void shiftWithShiftOfIntMaxValueTest() {
        final ArrayList<Shape> source = new ArrayList<>(
                Arrays.asList(
                        new Shape[]{new Circle(), new Triangle(), new Square(), new Rhomb()}
                )
        );
        final List<Shape> result = ShiftUtils.shift(source, Integer.MAX_VALUE);

        assertEquals(
                new ArrayList<>(
                        Arrays.asList(
                                new Shape[]{new Triangle(), new Square(), new Rhomb(), new Circle()}
                        )
                ), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shiftWithNullElemTest() {
        final ArrayList<Shape> source = new ArrayList<>(
                Arrays.asList(
                        new Shape[]{new Circle(), new Triangle(), null, new Rhomb()}
                )
        );
        ShiftUtils.shift(source, 3);
    }

    @Test
    public void shiftWithEmptyListTest() {
        final ArrayList<Shape> source = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            final List<Shape> result = ShiftUtils.shift(source, i);
            assertEquals(source, result);
        }
    }

    @Test
    public void shiftWithOneElemListTest() {
        final ArrayList<Shape> source = new ArrayList<>(
                Arrays.asList(
                        new Shape[]{new Circle()}
                )
        );
        for(int i = 0; i < 10; i++) {
            final List<Shape> result = ShiftUtils.shift(source, i);
            assertEquals(source, result);
        }
    }
}
