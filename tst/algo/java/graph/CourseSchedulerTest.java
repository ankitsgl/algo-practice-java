package algo.java.graph;

import algo.java.utils.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CourseSchedulerTest {
    CourseScheduler sut = new CourseScheduler();

    @Test
    public void scheduleCourses_test() {
        int[][] courses = new int[][] {
            {2,0,1},
            {0,3},
            {1},
            {3, 1}
        };

        ArrayList<Integer> courseOrder = sut.scheduleCourses(courses);
        ArrayUtils.printArray(courseOrder);
        assertEquals(4, courseOrder.size());
    }

    @Test
    public void canSchedule_returnsTrue() {
        int[][] courses = new int[][] {
                {2,0,1},
                {0,3},
                {1},
                {3, 1}
        };

        Boolean result = sut.canSchedule(courses);
        assertTrue(result);
    }

    @Test
    public void canSchedule_returnsFalse() {
        int[][] courses = new int[][] {
                {2,0},
                {0,2}
        };

        Boolean result = sut.canSchedule(courses);
        assertFalse(result);
    }
}
