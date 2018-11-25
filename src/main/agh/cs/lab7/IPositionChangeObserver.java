package agh.cs.lab7;

public interface IPositionChangeObserver {
    void positionChanged(Position oldPosition, Position newPosition);
}
