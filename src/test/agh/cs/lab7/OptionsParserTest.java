package agh.cs.lab7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;



public class OptionsParserTest {
    @Test
    public void testOptionsParser() {
        try {
            String[] commends = new String[]{"f", "forward", "b", "l", "left", "right", "r", "backward"};
            MoveDirection[] mv = OptionsParser.parse(commends);
            assertArrayEquals(new MoveDirection[]{
                    MoveDirection.FORWARD,
                    MoveDirection.FORWARD,
                    MoveDirection.BACKWARD,
                    MoveDirection.LEFT,
                    MoveDirection.LEFT,
                    MoveDirection.RIGHT,
                    MoveDirection.RIGHT,
                    MoveDirection.BACKWARD
            }, mv);


            commends = new String[] {};
            mv = OptionsParser.parse(commends);
            assertArrayEquals(new MoveDirection[]{}, mv);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
