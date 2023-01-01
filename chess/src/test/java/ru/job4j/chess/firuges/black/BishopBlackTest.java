package ru.job4j.chess.firuges.black;

import static ru.job4j.chess.firuges.Cell.*;

import junit.framework.TestCase;
import org.junit.Assert;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest extends TestCase {

    public void testPositionE3() {
        final BishopBlack bishopBlack = new BishopBlack(E3);
        Assert.assertEquals(bishopBlack.position(), Cell.E3);
    }

    public void testWayC1toG5() {
        final Figure bishopBlack1 = new BishopBlack(C1);
        Cell[] res = new Cell[]{D2, E3, F4, G5};
        Cell[] way = bishopBlack1.way(G5);
        Assert.assertArrayEquals(way, res);
    }

    public void testCopyE3toF2() {
        final Figure bishopBlack1 = new BishopBlack(E3);
        final Figure bishopBlack2 = bishopBlack1.copy(F2);
        Assert.assertEquals(bishopBlack2.position(), F2);
    }
}