package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestSolution {
    Solution test;

    @BeforeEach
    void init() {
        test = new Solution();
        test.theAuthor = "Test_Author";
        test.solutionFileName = "file name";
        test.theGrade = 100;
        test.setReported(true);
    }
    @Test
    void testToString() {
        assertEquals("Test_Author  file name "
                + "Grade=100  reported", test.toString());
    }

    @Test
    void getGradeString() {
        assertEquals("100", test.getGradeString());
    }

    @Test
    void getGradeInt() {
        assertEquals(100, test.getGradeInt());
    }

    @Test
    void setReported() {
        test.setReported(false);
        assertFalse(test.reported);
    }

    @Test
    void isReported() {
        assertTrue(test.reported);
    }
}
