package agh.cs.lab7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Student11 on 2018-10-15.
 */
public class CarTest {
    @Test
    public void testCar() {

        IWorldMap map = new RectangularMap(5, 5);
        Car myCar = new Car(map, new Position(2, 2));
        map.place(myCar);

        assertEquals(new Position(2, 2), myCar.getPosition());

        myCar.move(MoveDirection.FORWARD);
        assertEquals(new Position(2, 3), myCar.getPosition());

        myCar.move(MoveDirection.FORWARD);
        assertEquals(new Position(2, 4), myCar.getPosition());

        myCar.move(MoveDirection.FORWARD);
        assertEquals(new Position(2, 4), myCar.getPosition());

        myCar.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, myCar.getMapDirection());

        myCar.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, myCar.getMapDirection());

        myCar.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, myCar.getMapDirection());

        myCar.move(MoveDirection.BACKWARD);
        assertEquals(new Position(1, 4), myCar.getPosition());

        myCar.move(MoveDirection.BACKWARD);
        assertEquals(new Position(0, 4), myCar.getPosition());

        myCar.move(MoveDirection.BACKWARD);
        assertEquals(new Position(0, 4), myCar.getPosition());

        myCar.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, myCar.getMapDirection());

        myCar.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, myCar.getMapDirection());

        myCar.move(MoveDirection.BACKWARD);
        assertEquals(new Position(1, 4), myCar.getPosition());

        myCar.move(MoveDirection.BACKWARD);
        assertEquals(new Position(2, 4), myCar.getPosition());

        myCar.move(MoveDirection.BACKWARD);
        assertEquals(new Position(3, 4), myCar.getPosition());

        myCar.move(MoveDirection.BACKWARD);
        assertEquals(new Position(4, 4), myCar.getPosition());

        myCar.move(MoveDirection.BACKWARD);
        assertEquals(new Position(4, 4), myCar.getPosition());
    }


}
