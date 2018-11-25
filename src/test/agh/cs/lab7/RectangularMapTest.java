package agh.cs.lab7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class RectangularMapTest {

    @Test
    public void testPlace() {
        RectangularMap map = new RectangularMap(5,5);
        assertTrue(map.place(new Car(map, new Position(3,3))));
        assertThrows(
                IllegalArgumentException.class,
                () -> { map.place(new Car(map, new Position(3,3))); }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> { map.place(new Car(map, new Position(-10,10))); }
        );
//        assertFalse(map.place(new Car(map, new Position(3,3))));
  //      assertFalse(map.place(new Car(map, new Position(-10,10))));
        assertTrue(map.place(new Car(map, new Position(0,0))));
        assertThrows(
                IllegalArgumentException.class,
                () -> {map.place(new Car(map, new Position(0,0))); }
        );
    //    assertFalse(map.place(new Car(map, new Position(0,0))));
    }

    @Test
    public void testCanMoveTo() {
        RectangularMap map = new RectangularMap(5,5);
        assertFalse(map.canMoveTo(new Position(2309, 2390)));
        assertTrue(map.canMoveTo(new Position(3,3)));
        assertTrue(map.place(new Car(map, new Position(3,3))));
        assertFalse(map.canMoveTo(new Position(3,3)));
    }

    @Test
    public void testObjectAt() {
        RectangularMap map = new RectangularMap(5,5);
        assertTrue(map.place(new Car(map, new Position(3,3))));

        assertThat(map.objectAt(new Position(3,3)), instanceOf(Car.class));
        assertNull(map.objectAt(new Position(0,0)));
    }

    @Test
    public void testIsOccupied() {
        RectangularMap map = new RectangularMap(5,5);
        assertTrue(map.place(new Car(map, new Position(3,3))));
        assertFalse(map.isOccupied(new Position(0,0)));
        assertTrue(map.isOccupied(new Position(3,3)));
    }

    @Test
    public void testRectangularMap() {
        RectangularMap rm = new RectangularMap(5,5);
        Car myCar = new Car(rm, new Position(3,3));
        assertTrue(rm.place(myCar));
//        assertFalse(rm.place(myCar));

        rm.run(new MoveDirection[]{
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD
        });

        assertEquals(new Position(3,4),myCar.getPosition());

        rm.run(new MoveDirection[]{
                MoveDirection.RIGHT,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD,
                MoveDirection.FORWARD
        });

        assertEquals(new Position(4,4),myCar.getPosition());
    }
}
