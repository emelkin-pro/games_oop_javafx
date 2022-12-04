package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {

        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }

        int size = Math.abs(dest.getX() - this.position().getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - this.position().getX()) / (Math.abs(dest.getX() - this.position().getX()));
        int deltaY = (dest.getY() - this.position().getY()) / (Math.abs(dest.getY() - this.position().getY()));
        int x = this.position().getX();
        int y = this.position().getY();
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x += deltaX, y += deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getY() - dest.getY()) == Math.abs(source.getX() - dest.getX());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
