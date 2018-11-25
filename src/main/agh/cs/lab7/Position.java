package agh.cs.lab7;

/**
 * Created by Student32 on 2018-10-08.
 */
public class Position {
    public final int x;
    public final int y;

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position other) {
        this.x = other.x;
        this.y = other.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean smaller(Position other) {
        if(x <= other.x && y <= other.y) return true;
        return false;
    }

    public boolean larger(Position other){
        if(x >= other.x && y >= other.y) return true;
        return false;
    }

    public Position upperRight(Position other) {
        return new Position(Math.max(other.x, x), Math.max(other.y, y));
    }

    public Position lowerLeft(Position other) {
        return new Position(Math.min(x, other.x), Math.min(y, other.y));
    }

    public Position add(Position other) {
        return new Position(x+other.x, y+other.y);
    }

    public Position sub(Position other) {return new Position(x-other.x, y-other.y);}

    public boolean equals(Object other) {
        if (!(other instanceof Position))
            return false;
        Position that = (Position) other;
        if(x == that.x && y == that.y)
            return true;
        return false;
    }
}
