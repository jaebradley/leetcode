    package problems;

    import org.junit.Test;

    import java.util.ArrayList;
    import java.util.List;

    import static org.junit.Assert.*;

    public class AllPathsFromSourceToTargetTest {

        @Test
        public void testTwoPaths() {
            assertEquals(
                    List.of(
                            List.of(0, 1, 3),
                            List.of(0, 2, 3)
                    ),
                    new AllPathsFromSourceToTarget().allPathsSourceTarget(
                            new int[][]{
                                    new int[]{1, 2},
                                    new int[]{ 3 },
                                    new int[]{ 3 },
                                    new int[]{}
                            }
                    )
            );
        }

        @Test
        public void testSinglePath() {
            assertEquals(
                    List.of(List.of(0, 1)),
                    new AllPathsFromSourceToTarget().allPathsSourceTarget(
                            new int[][]{
                                    new int[]{ 1 },
                                    new int[]{}
                            }
                    )
            );
        }

        @Test
        public void testEmptyGraph() {
            assertEquals(
                    new ArrayList<Integer>(),
                    new AllPathsFromSourceToTarget().allPathsSourceTarget(null)
            );
        }

        @Test
        public void testExistentButEmptyGraph() {
            assertEquals(
                    new ArrayList<Integer>(),
                    new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{})
            );
        }

        @Test
        public void testThreeDifferentPaths() {
            assertTrue(
                    List.of(
                            List.of(0, 1, 2, 3),
                            List.of(0, 2, 3),
                            List.of(0, 3)
                    ).containsAll(
                        new AllPathsFromSourceToTarget().allPathsSourceTarget(
                                new int[][]{
                                        new int[]{ 1, 2, 3},
                                        new int[]{ 2 },
                                        new int[]{ 3 },
                                        new int[]{}
                            }
                    )
                )
        );
    }
}