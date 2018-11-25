package agh.cs.lab7;

/**
 * Created by student11 on 2018-10-29.
 */
public class HayStack implements IMapElement {
    private Position position;
    public HayStack(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return new Position(position);
    }

    public String toString() {
        return "s";
    }
}
