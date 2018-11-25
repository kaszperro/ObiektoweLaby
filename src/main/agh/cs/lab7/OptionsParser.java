package agh.cs.lab7;

        import java.util.Arrays;

/**
 * Created by Student11 on 2018-10-15.
 */
public class OptionsParser {

    public static MoveDirection[] parse(String [] input) throws IllegalArgumentException{
        MoveDirection[] result = Arrays.stream(input)
                .map(String::toLowerCase)

                .map(s -> {
                    switch (s) {
                        case "forward":
                        case "f":
                            return MoveDirection.FORWARD;
                        case "backward":
                        case "b":
                            return MoveDirection.BACKWARD;
                        case "right":
                        case "r":
                            return MoveDirection.RIGHT;
                        case "l":
                        case "left":
                            return MoveDirection.LEFT;
                        default:
                            throw new IllegalArgumentException(s + " is not legal move specification");
                    }
                })
                .toArray(MoveDirection[]::new);


        return result;
    }
}
