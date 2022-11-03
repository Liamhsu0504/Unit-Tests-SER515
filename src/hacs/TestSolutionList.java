package hacs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestSolutionList {
    @Test
    void test() {
        SolutionList test = new SolutionList();
        assertEquals(0, test.size());
        test.add(new Solution());
        assertNotNull(test);
    }
}
