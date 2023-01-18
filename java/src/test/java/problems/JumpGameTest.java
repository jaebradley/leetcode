package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {
    @Test
    public void canJumpToEnd() {
        assertTrue(JumpGame.canJump(new int[] {2, 3, 1, 1, 4}));
    }

    @Test
    public void cannotJumpToEnd() {
        assertFalse(JumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void canJumpToEndForSingleElement() {
        assertTrue(JumpGame.canJump(new int[] {1}));
    }

    @Test
    public void canJump2ToEnd() {
        assertTrue(JumpGame.canJump2(new int[] {2, 3, 1, 1, 4}));
    }

    @Test
    public void cannotJump2ToEnd() {
        assertFalse(JumpGame.canJump2(new int[]{3, 2, 1, 0, 4}));
    }

    @Test
    public void canJump2ToEndForSingleElement() {
        assertTrue(JumpGame.canJump2(new int[] {1}));
    }
}