package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomizedSetTest {
    @Test
    public void itShouldInsertValue() {
        RandomizedSet set = new RandomizedSet();
        assertTrue(set.insert(1));
    }

    @Test
    public void itShouldNotInsertValue() {
        RandomizedSet set = new RandomizedSet();
        assertTrue(set.insert(1));
        assertFalse(set.insert(1));
    }

    @Test
    public void itShouldRemoveValue() {
        RandomizedSet set = new RandomizedSet();
        assertTrue(set.insert(1));
        assertTrue(set.insert(2));
        assertTrue(set.remove(1));
    }

    @Test
    public void itShouldNotRemoveValue() {
        RandomizedSet set = new RandomizedSet();
        assertFalse(set.remove(1));
    }

    @Test
    public void itShouldThrowWhenGettingRandomValueForEmptySet() {
        RandomizedSet set = new RandomizedSet();
        try {
            set.getRandom();
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void itShouldGetSameRandomValueForSingleElementSet() {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        for (int count = 0; count < 100; count++) {
            assertEquals(1, set.getRandom());
        }
    }
}