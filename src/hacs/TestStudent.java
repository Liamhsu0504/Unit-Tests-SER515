package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestStudent {

    @Test
    void createCourseMenu() {
        Person test = new Student();
        Course course = new Course("SER515", 1);
        CourseMenu courseMenu = test.createCourseMenu(course, 1);
        assertNotNull(courseMenu.size());
    }
}
