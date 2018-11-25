package agh.cs.lab7;

import java.util.ArrayList;

/**
 * Created by student11 on 2018-10-29.
 */
public class UnboundedMap extends AbstractWorldMap {

    private void addHayStacks(ArrayList<HayStack> hayStacks) throws IllegalArgumentException {
        for (HayStack hayStack : hayStacks) {
            if (isOccupied(hayStack.getPosition()))
                throw new IllegalArgumentException("Can't place hay stack at position " + hayStack.getPosition().toString() + ", because " + hayStack.getPosition().toString() + "is already occupied");

            allMapElements.put(hayStack.getPosition(), hayStack);
        }
    }


    public UnboundedMap(ArrayList<HayStack> hayStacks) throws IllegalArgumentException {
        super();
        addHayStacks(hayStacks);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    protected Position getLowLeftCorner() {
        Position lowLeft = new Position(0, 0);
        for (IMapElement mapElement : allMapElements.values()) {
            lowLeft = lowLeft.lowerLeft(mapElement.getPosition());
        }
        return lowLeft;
    }

    @Override
    protected Position getUpRightCorner() {
        Position upRight = new Position(0, 0);
        for (IMapElement mapElement : allMapElements.values()) {
            upRight = upRight.upperRight(mapElement.getPosition());
        }
        return upRight;
    }

}
