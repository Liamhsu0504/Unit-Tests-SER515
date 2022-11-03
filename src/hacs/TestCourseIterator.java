package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestCourseIterator {
    ClassCourseList courseList;
    CourseIterator courseIterator;
    @BeforeEach
    void init() {
        courseList = new ClassCourseList();
        courseList.initializeFromFile("./src/resources/CourseInfo.txt");
        courseIterator = new CourseIterator(courseList);
        courseIterator.currentCourseNumber = 0;
    }

    @Test
    void hasNext() {
        assertTrue(courseIterator.hasNext());
    }

    @Test
    void next() {
        assertEquals("SER501", courseIterator.next().toString());
    }

    @Test
    void remove() {
        assertEquals(3, courseList.size());
        courseIterator.remove();
        assertEquals(2, courseList.size());
    }

    @Test
    void testNext() {
        assertEquals("SER501", courseIterator.next("SER501").toString());
    }
}
