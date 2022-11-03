package hacs;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestAssignment {

    @Test
    void setDueDate() {
        Assignment test = new Assignment();
        Date date = new Date();
        test.setDueDate(date);
        assertNotNull(test.dueDate);
    }

    @Test
    void setAssSpec() {
        Assignment test = new Assignment();
        test.setAssSpec("TestAssSpec");
        assertEquals("TestAssSpec", test.assSpec);
    }

    @Test
    void isOverDue() {
        Assignment test = new Assignment();
        Date dueDate = new Date(0, 0, 0);
        test.setDueDate(dueDate);
        assertTrue(test.isOverDue());
    }

    @Test
    void addSolution() {
        Assignment test = new Assignment();
        Solution testSolution = test.addSolution();
        assertNotNull(testSolution);
    }

    @Test
    void testAddSolution() {
        Assignment test = new Assignment();
        Solution testSolution = new Solution();
        test.addSolution(testSolution);
        assertNotNull(test.theSolutionList);
    }

    @Test
    void getSugSolution() {
        Assignment test = new Assignment();
        assertNotNull(test.getSugSolution());
    }

    @Test
    void getSolutionIterator() {
        Assignment test = new Assignment();
        assertNotNull(test.getSolutionIterator());
    }

    @Test
    void testToString() {
        Assignment test = new Assignment();
        test.assName = "liam";
        assertNotNull(test.toString());
    }

    @Test
    void getDueDateString() {
        Assignment test = new Assignment();
        Date dueDate = new Date(0, 0, 0);
        test.setDueDate(dueDate);
        assertEquals(test.getDueDateString(),
                DateFormat.getDateInstance(DateFormat.SHORT).format(dueDate));
    }

    @Test
    void accept() {
        Assignment test = new Assignment();
        NodeVisitor vistor = new ReminderVisitor(new Reminder());
        test.accept(vistor);
    }
}
