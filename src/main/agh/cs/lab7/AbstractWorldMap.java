package agh.cs.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by student11 on 2018-10-29.
 */
public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected List<Car> cars = new ArrayList<>();
    protected HashMap<Position, IMapElement> allMapElements = new HashMap<>();

    protected final MapVisualizer visualizer;

    protected AbstractWorldMap() {
        this.visualizer = new MapVisualizer(this);
    }

    protected abstract Position getLowLeftCorner();

    protected abstract Position getUpRightCorner();

    @Override
    public boolean place(Car car) throws IllegalArgumentException {
        Position carPosition = car.getPosition();
        if (!isOccupied(carPosition)) {
            cars.add(car);
            allMapElements.put(carPosition, car);
            car.addObserver(this);
            return true;
        }
        throw new IllegalArgumentException(car.getPosition().toString() + " is occupied");

    }

    @Override
    public void run(MoveDirection[] directions) {
        int carsLen = cars.size();
        if (carsLen == 0)
            return;

        for (int i = 0; i < directions.length; ++i) {
            Car myCar = cars.get(i % carsLen);
            myCar.move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Position position) {
        return allMapElements.getOrDefault(position, null);
    }

    public String toString() {
        return visualizer.draw(this.getLowLeftCorner(), this.getUpRightCorner());
    }

    @Override
    public void positionChanged(Position oldPosition, Position newPosition) {
        IMapElement myElement = allMapElements.get(oldPosition);
        allMapElements.remove(oldPosition);
        allMapElements.put(newPosition, myElement);
    }
}
