package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskSchedulerTest {

    @Test
    public void intervalIs8() {
        assertEquals(8, TaskScheduler.leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}