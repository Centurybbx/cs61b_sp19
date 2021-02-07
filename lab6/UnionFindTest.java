import org.junit.Test;
import static org.junit.Assert.*;

public class UnionFindTest {

    @Test
    public void findTest() {
        UnionFind test = new UnionFind(5);
        int actual = test.find(3);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void unionTest() {
        UnionFind test = new UnionFind(5);
        test.union(0, 1);
        test.union(3, 1);
        int expected = 3, actual = test.sizeOf(0);
        assertEquals(expected, actual);
    }

    @Test
    public void connectedTest() {
        UnionFind test = new UnionFind(5);
        assertFalse(test.connected(0, 4));
        test.union(0, 4);
        assertTrue(test.connected(0, 4));
    }

    @Test
    public void parentTest() {
        UnionFind test = new UnionFind(5);
        test.union(0, 1);
        test.union(0, 2);
        test.union(3, 4);
        int actual1 = test.parent(3), expected1 = 4;
        assertEquals(expected1, actual1);
        test.union(0, 3);
        int actual = test.parent(0), expected = 1;
        assertEquals(expected, actual);
    }

}
