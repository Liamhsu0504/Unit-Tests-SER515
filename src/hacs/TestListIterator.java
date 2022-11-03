package hacs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li Che Hsu
 * ASUrite: lhsu16
 * ASU ID: 1225397459
 */
class TestListIterator {
    ListIterator test;
    @BeforeEach
    void init() {
        ArrayList<Object> testlist = new ArrayList<>();
        testlist.add("test1");
        testlist.add("test2");
        testlist.add("test3");
        test = new ListIterator(testlist);
    }
    @Test
    void hasNext() {
        assertTrue(test.hasNext());
    }

    @Test
    void next() {
        assertEquals("test1", test.next());
    }

    @Test
    void remove() {
        test.currentNumber = 1;
        test.remove();
        assertEquals(2, test.theList.size());
    }
}
