package agh.cs.lab7;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PositionTest {
    @Test
    public void testToString(){
        Position myPos = new Position(3, 3);
        assertEquals(myPos.toString(), "(3, 3)");
    }

    @Test
    public void testSmaller() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(2, 3);
        assertTrue(p1.smaller(p2));
        assertFalse(p2.smaller(p1));

        p2 = new Position(1, 2);
        assertTrue(p1.smaller(p2));
    }

    @Test
    public void testLarger() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(2, 3);
        assertFalse(p1.larger(p2));
        assertTrue(p2.larger(p1));

        p2 = new Position(1, 2);
        assertTrue(p1.larger(p2));
    }

    @Test
    public void testUpperRight() {
        Position p1 = new Position(1, 2);
        Position p2 = new Position(3, 1);

        Position pUR = p1.upperRight(p2);
        assertEquals(new Position(3, 2), pUR);
    }

    @Test
    public void testLowerLeft(){
        Position p1 = new Position(1, 2);
        Position p2 = new Position(3, 1);

        Position pLR = p1.lowerLeft(p2);
        assertEquals(new Position(1, 1), pLR);
    }

    @Test
    public void testAdd() {
        Position p1 = new Position(3, -1);
        Position p2 = new Position(4, 5);

        Position ad = p1.add(p2);

        assertEquals(new Position(7,4), ad);
    }

    @Test
    public void testEquals() {
        Position p1 = new Position(3, -1);
        Position p2 = new Position(4, 5);

        assertNotEquals(p1, p2);
        Position p3 = new Position(3, -1);
        assertEquals(p1, p3);
    }
}
