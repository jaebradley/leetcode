package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseScheduleTest {

    @Test
    public void coursesWithoutAnyPrerequisitesCanFinish() {
        assertTrue(CourseSchedule.canFinishBFS(10, new int[][]{}));
    }

    @Test
    public void twoCoursesWithCycleCannotFinish() {
        int[][] prerequisites = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
        };
        assertFalse(CourseSchedule.canFinishBFS(2, prerequisites));
    }

    @Test
    public void twoCoursesWithSinglePrerequisiteCanFinish() {
        int[][] prerequisites = new int[][]{
                new int[]{0, 1},
        };
        assertTrue(CourseSchedule.canFinishBFS(2, prerequisites));
    }
}