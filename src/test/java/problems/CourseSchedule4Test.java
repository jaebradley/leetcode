package problems;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CourseSchedule4Test {
    @Test
    public void testTwoCoursesWithSingleDependency() {
        assertEquals(
                List.of(true, false),
                new CourseSchedule4().checkIfPrerequisite(
                        2,
                        new int[][]{
                                new int[]{0, 1}
                        },
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 0}
                        }
                )
        );
    }

    @Test
    public void testNoPrerequisites() {
        assertEquals(
                List.of(false, false),
                new CourseSchedule4().checkIfPrerequisite(
                        2,
                        new int[][]{},
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 0}
                        }
                )
        );
    }

    @Test
    public void testThreeCoursesWhereCourseDependencyCycleBetweenAllThree() {
        assertEquals(
                List.of(true, true, true),
                new CourseSchedule4().checkIfPrerequisite(
                        3,
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{2, 0}
                        },
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{2, 0}
                        }
                )
        );
    }
}