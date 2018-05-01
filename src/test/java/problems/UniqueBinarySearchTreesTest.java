package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueBinarySearchTreesTest {

    @Test
    public void threeShouldReturn5() {
        assertEquals(5, UniqueBinarySearchTrees.numTrees(3));
    }

    @Test
    public void oneShouldReturn1() {
        assertEquals(1, UniqueBinarySearchTrees.numTrees(1));
    }
}