package agh.cs.lab7;

/**
 * Created by Student32 on 2018-10-08.
 */

import java.util.ArrayList;

import static java.lang.System.out;


public class CarSystem {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            ArrayList<HayStack> stacks = new ArrayList<>();
            stacks.add(new HayStack(new Position(-4, -4)));
            stacks.add(new HayStack(new Position(7, 7)));
            IWorldMap map = new UnboundedMap(stacks);
            map.place(new Car(map, new Position(3, 4)));
            //map.place(new Car(map, new Position(3, 4)));
            map.run(directions);

            out.println(map.toString());
        } catch (IllegalArgumentException e) {
            out.println("There is an error: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}
