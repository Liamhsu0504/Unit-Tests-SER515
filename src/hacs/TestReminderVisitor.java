package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestReminderVisitor {
    ReminderVisitor test;
    @BeforeEach
    void init() {
        Reminder testReminder = new Reminder();
        test = new ReminderVisitor(testReminder);
    }
    @Test
    void visitFacade() {
        Facade facade = new Facade();
        UserInfoItem liam = new UserInfoItem();
        facade.createCourseList();
        facade.createUser(liam);
        test.visitFacade(facade);
    }

    @Test
    void visitCourse() {
        Course testCourse = new Course("test_course", 1);
        test.visitCourse(testCourse);
    }

    @Test
    void visitAssignment() {
        Assignment testAssignment = new Assignment();
        test.visitAssignment(testAssignment);
    }
}
