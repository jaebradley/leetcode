package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {

    @Test
    public void returnTwo() {
        assertEquals(2, MissingNumber.missingNumber(new int[]{ 3, 0, 1 }));
    }
}