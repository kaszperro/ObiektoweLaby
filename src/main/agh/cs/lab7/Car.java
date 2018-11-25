package agh.cs.lab7;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Student11 on 2018-10-15.
 */
public class Car implements IMapElement {
    private MapDirection orientation;
    private Position position;
    private IWorldMap map;

    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public Car(IWorldMap map) {
        this.position = new Position(2, 2);
        this.orientation = MapDirection.NORTH;
        this.map = map;
    }

    public Car(IWorldMap map, Position initialPosition) {
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.map = map;
    }


    public String toString() {
        return this.orientation.toString();
    }

    public void move(MoveDirection direction) {
        Position newPos = new Position(this.getPosition());
        switch (direction) {
            case FORWARD:
                newPos = this.position.add(orientation.toPosition());
                break;
            case BACKWARD:
                newPos = this.position.sub(orientation.toPosition());
                break;
            case LEFT:
                this.orientation = this.orientation.previous();
                break;
            default:
                this.orientation = this.orientation.next();
                break;
        }

        if (map.canMoveTo(newPos) && !this.position.equals(newPos)) {
            //map.updateMapElementPosition(this, this.position, newPos);
            positionChanged(this.position, newPos);
            this.position = newPos;
        }

    }

    @Override
    public Position getPosition() {
        return new Position(this.position);
    }

    public MapDirection getMapDirection() {
        return this.orientation;
    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    void positionChanged(Position oldPos, Position newPos) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(oldPos, newPos);
        }
    }

}
