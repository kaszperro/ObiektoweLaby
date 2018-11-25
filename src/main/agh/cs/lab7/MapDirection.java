package agh.cs.lab7;

/**
 * Created by Student32 on 2018-10-08.
 */


enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    @Override
    public String toString() {
        switch (this ){
            case NORTH:
                return "▲";
            case SOUTH:
                return "▼";
            case EAST:
                return "►";
            default:
                return "◄";
        }
    }

    public MapDirection next() {
        switch (this) {
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                return EAST;
        }
    }

    public MapDirection previous() {
        switch (this){
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            default:
                return NORTH;
        }
    }

    public Position toPosition() {
        switch (this) {
            case NORTH:
                return new Position(0, 1);
            case WEST:
                return new Position(-1, 0);
            case EAST:
                return new Position(1, 0);
            default:
                return new Position(0, -1);
        }
    }

}
