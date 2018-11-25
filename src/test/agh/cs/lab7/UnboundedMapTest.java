package agh.cs.lab7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by student11 on 2018-10-29.
 */
public class UnboundedMapTest {
    @Test
    public void testPlace() {
        ArrayList<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Position(-4, -4)));
        stacks.add(new HayStack(new Position(7, 7)));
        UnboundedMap map = new UnboundedMap(stacks);
        assertTrue(map.place(new Car(map, new Position(10,10))));
        assertThrows(
                IllegalArgumentException.class,
                () -> { map.place(new Car(map, new Position(-4, -4))); }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> {map.place(new Car(map, new Position(10,10))); }
        );

        assertTrue(map.place(new Car(map, new Position(-434,-412312))));
    }

    @Test
    public void testRun() {
        ArrayList<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Position(-4, -4)));
        stacks.add(new HayStack(new Position(7, 7)));
        stacks.add(new HayStack(new Position(3, 6)));
        stacks.add(new HayStack(new Position(2, 0)));
        UnboundedMap map = new UnboundedMap(stacks);
        Car car1 = new Car(map, new Position(2, 2));
        Car car2 = new Car(map, new Position(3, 4));
        map.place(car1);
        map.place(car2);
        String [] seq = {"f", "b" , "r", "l" ,"f" ,"f", "r" ,"r" ,"f" ,"f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = OptionsParser.parse(seq);

        map.run(directions);

        assertEquals(new Position(2,1), car1.getPosition());
        assertEquals(new Position(3,5), car2.getPosition());
    }

    @Test
    public void testIsOccupied() {
        ArrayList<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Position(-4, -4)));
        stacks.add(new HayStack(new Position(7, 7)));
        stacks.add(new HayStack(new Position(3, 6)));
        stacks.add(new HayStack(new Position(2, 0)));
        UnboundedMap map = new UnboundedMap(stacks);

        assertTrue(map.isOccupied(new Position(-4, -4)));
        assertTrue(map.isOccupied(new Position(7, 7)));
        assertTrue(map.isOccupied(new Position(3, 6)));
        assertTrue(map.isOccupied(new Position(2, 0)));
        assertFalse(map.isOccupied(new Position(10, 10)));

        map.place(new Car(map,new Position(10,10)));

        assertTrue(map.isOccupied(new Position(10, 10)));
    }


    @Test
    public void testCanMoveTo() {
        ArrayList<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Position(-4, -4)));
        stacks.add(new HayStack(new Position(7, 7)));
        stacks.add(new HayStack(new Position(3, 6)));
        stacks.add(new HayStack(new Position(2, 0)));
        UnboundedMap map = new UnboundedMap(stacks);

        assertFalse(map.canMoveTo(new Position(-4, -4)));
        assertFalse(map.canMoveTo(new Position(7, 7)));
        assertFalse(map.canMoveTo(new Position(3, 6)));
        assertFalse(map.canMoveTo(new Position(2, 0)));
        assertTrue(map.canMoveTo(new Position(10, 10)));

        map.place(new Car(map,new Position(10,10)));

        assertFalse(map.canMoveTo(new Position(10, 10)));
    }

    @Test
    public void testObjectAt() {
        ArrayList<HayStack> stacks = new ArrayList<>();
        stacks.add(new HayStack(new Position(-4, -4)));
        stacks.add(new HayStack(new Position(7, 7)));
        stacks.add(new HayStack(new Position(3, 6)));
        stacks.add(new HayStack(new Position(2, 0)));
        UnboundedMap map = new UnboundedMap(stacks);

        assertThat(map.objectAt(new Position(-4,-4)), instanceOf(HayStack.class));
        assertNull(map.objectAt(new Position(234,2344)));
        map.place(new Car(map, new Position(100,100)));
        assertThat(map.objectAt(new Position(100,100)), instanceOf(Car.class));
    }

}
