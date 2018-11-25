package agh.cs.lab7;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Student32 on 2018-10-08.
 */
public class CarSystemTest {

    @Test
    public void optionsCarIntegrationTest() {
        try {
            String[] commends = new String[]{"f", "forward", "b", "l", "", "left", "right", "r", "backward"};
            MoveDirection[] moveDir = OptionsParser.parse(commends);

            IWorldMap map = new RectangularMap(5, 5);

            Car myCar = new Car(map);
            map.place(myCar);
            map.run(moveDir);



            assertEquals(new Position(2, 2), myCar.getPosition());
            assertEquals(MapDirection.NORTH, myCar.getMapDirection());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
