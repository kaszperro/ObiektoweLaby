package agh.cs.lab7;

public class RectangularMap extends AbstractWorldMap{ //implements IWorldMap {
    private final Position lowLeftCorner;
    private final Position upRightCorner;


    public RectangularMap(int width, int height) {
        super();
        this.lowLeftCorner = new Position(0, 0);
        this.upRightCorner = new Position(width-1, height-1);
    }


    @Override
    public boolean canMoveTo(Position position) {
        Position goodPos = position.upperRight(lowLeftCorner).lowerLeft(upRightCorner);
        return goodPos.equals(position) && !isOccupied(position);
    }

    @Override
    protected Position getLowLeftCorner() {
        return lowLeftCorner;
    }

    @Override
    protected Position getUpRightCorner() {
        return upRightCorner;
    }

    @Override
    public boolean place(Car car) throws IllegalArgumentException {
        if (lowLeftCorner.smaller(car.getPosition()) && upRightCorner.larger(car.getPosition()))
            return super.place(car);
        throw new IllegalArgumentException("poza mapa");

    }
}
