package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

public class LogicTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }


    @Test
    public void testMoveImpossibleMoveExceptionC1toE4() throws Exception {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        thrown.expect(ImpossibleMoveException.class);
        thrown.expectMessage("Could not move by diagonal from C1 to E4");
        logic.move(Cell.C1, Cell.E4);
    }

    @Test
    public void testMoveFigureNotFoundException() throws Exception {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        thrown.expect(FigureNotFoundException.class);
        logic.move(Cell.A1, Cell.E4);
    }

    @Test
    public void testMoveOccupiedCellException() throws Exception {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2));
        thrown.expect(OccupiedCellException.class);
        logic.move(Cell.C1, Cell.E3);
    }
}