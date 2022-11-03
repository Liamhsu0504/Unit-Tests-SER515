package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestCourse {
    Course test;
    @BeforeEach
    void init() {
        test = new Course("test", 1);
    }
    @Test
    void getAssignmentList() {

        assertEquals(0, test.getAssignmentList().size());
    }
    @Test
    void addAssignment() {
        Assignment assignment = new Assignment();
        test.addAssignment(assignment);
        assertNotNull(test.getAssignmentList());
    }

    @Test
    void testToString() {
        assertEquals("test", test.toString());
    }

    @Test
    void accept() {
        NodeVisitor vistor = new ReminderVisitor(new Reminder());
        test.accept(vistor);
    }
}
