package problems;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PartitionLabelsTest {
    @Test
    public void testRepeatedPartitionLabels() {
        assertEquals(
                new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"),
                List.of(9, 7, 8)
        );
    }

    @Test
    public void testUniqueCharacters() {
        assertEquals(
                new PartitionLabels().partitionLabels("abcdefghij"),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        );
    }
}
