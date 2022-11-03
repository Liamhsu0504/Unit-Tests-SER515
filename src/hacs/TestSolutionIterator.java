package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestSolutionIterator {
    SolutionList solutionList;
    SolutionIterator solutionIterator;
    @BeforeEach
    void init() {
        solutionList = new SolutionList();
        Solution solution1 = new Solution();
        Solution solution2 = new Solution();
        Solution solution3 = new Solution();
        solution1.theAuthor = "author1";
        solution2.theAuthor = "author2";
        solution3.theAuthor = "author3";
        solutionList.add(solution1);
        solutionList.add(solution2);
        solutionList.add(solution3);
        solutionIterator = new SolutionIterator(solutionList);
    }
    @Test
    void moveToHead() {
        solutionIterator.moveToHead();
        assertEquals(-1, solutionIterator.currentSolutionNumber);
    }

    @Test
    void hasNext() {
        assertTrue(solutionIterator.hasNext());
    }

    @Test
    void next() {
        assertEquals("author1   Grade=0  "
                + "not reported", solutionIterator.next().toString());
    }

    @Test
    void testNext() {
        assertEquals("author2   Grade=0  not reported",
                solutionIterator.next("author2").toString());
    }

    @Test
    void remove() {
        assertEquals(3, solutionList.size());
        solutionIterator.currentSolutionNumber = 1;
        solutionIterator.remove();
        assertEquals(2, solutionList.size());
    }
}
