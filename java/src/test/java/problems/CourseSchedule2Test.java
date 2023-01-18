package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseSchedule2Test {

    @Test
    public void twoCoursesWithSinglePrerequisiteShouldReturn0_1() {
        assertArrayEquals(new int[]{0, 1}, CourseSchedule2.findOrder(2, new int[][]{
                new int[]{1, 0}
        }));
    }

    @Test
    public void fourCoursesWithFourPrerequisitesShouldReturn0_1_2_3() {
        assertArrayEquals(new int[]{0, 1, 2, 3}, CourseSchedule2.findOrder(4, new int[][]{
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 1},
                new int[]{3, 2},
        }));
    }

    @Test
    public void emptyArrayForCycle() {
        assertArrayEquals(new int[]{}, CourseSchedule2.findOrder(2, new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
        }));
    }

    @Test
    public void twoCoursesWithNoPrerequisitesShouldReturn0_1() {
        assertArrayEquals(new int[]{0, 1}, CourseSchedule2.findOrder(2, new int[][]{}));
    }
}