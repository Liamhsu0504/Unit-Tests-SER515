package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestClassCourseList {

    @Test
    void initializeFromFile() {
        ClassCourseList courseList = new ClassCourseList();
        courseList.initializeFromFile("./src/resources/CourseInfo.txt");
        assertEquals(courseList.get(0).toString(), "SER515");
        assertEquals(courseList.get(1).toString(), "SER501");
        assertEquals(courseList.get(2).toString(), "CSE360");
    }
}
