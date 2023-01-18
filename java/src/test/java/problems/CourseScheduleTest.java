package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseScheduleTest {

    @Test
    public void coursesWithoutAnyPrerequisitesCanFinishBFS() {
        assertTrue(CourseSchedule.canFinishBFS(10, new int[][]{}));
    }

    @Test
    public void twoCoursesWithCycleCannotFinishBFS() {
        int[][] prerequisites = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
        };
        assertFalse(CourseSchedule.canFinishBFS(2, prerequisites));
    }

    @Test
    public void twoCoursesWithSinglePrerequisiteCanFinishBFS() {
        int[][] prerequisites = new int[][]{
                new int[]{0, 1},
        };
        assertTrue(CourseSchedule.canFinishBFS(2, prerequisites));
    }

    @Test
    public void coursesWithoutAnyPrerequisitesCanFinishDFS() {
        assertTrue(CourseSchedule.canFinishDFS(10, new int[][]{}));
    }

    @Test
    public void twoCoursesWithCycleCannotFinishDFS() {
        int[][] prerequisites = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
        };
        assertFalse(CourseSchedule.canFinishDFS(2, prerequisites));
    }

    @Test
    public void twoCoursesWithSinglePrerequisiteCanFinishDFS() {
        int[][] prerequisites = new int[][]{
                new int[]{0, 1},
        };
        assertTrue(CourseSchedule.canFinishDFS(2, prerequisites));
    }
}