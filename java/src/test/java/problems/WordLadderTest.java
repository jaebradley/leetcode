package problems;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordLadderTest {
    @Test
    public void testZeroLadderLengthWhenNoMatches() {
        assertEquals(
                0,
                new WordLadder().ladderLength(
                        "hit",
                        "cog",
                        List.of("hot", "dot", "dog", "lot", "log")
                )
        );
    }

    @Test
    public void testMultipleTransformations() {
        assertEquals(
                5,
                new WordLadder().ladderLength(
                        "hit",
                        "cog",
                        List.of("hot", "dot", "dog", "lot", "log", "cog")
                )
        );

    }
}
