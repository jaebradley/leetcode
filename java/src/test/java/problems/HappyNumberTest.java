package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class HappyNumberTest {
    @Test
    public void itShouldReturnTrueFor19() {
        assertTrue(HappyNumber.isHappy(19));
    }

    @Test
    public void itShouldReturnFalseFor2() {
        assertFalse(HappyNumber.isHappy(2));
    }

    @Test
    public void itShouldReturnTrueFor7() {
        assertTrue(HappyNumber.isHappy(7));
    }

    @Test
    public void itShouldReturnFalseFor0() {
        assertFalse(HappyNumber.isHappy(0));
    }

    @Test
    public void itShouldReturnTrueFor1() {
        assertTrue(HappyNumber.isHappy(1));
    }

    @Test
    public void itShouldConstruct() {
        assertNotNull(new HappyNumber());
    }
}