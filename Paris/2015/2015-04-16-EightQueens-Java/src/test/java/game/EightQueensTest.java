package game;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static game.Position.pos;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EightQueensTest {

    @Test
    public void
    acceptance_test() {
        List<Position> board = Arrays.asList(pos(0, 3),pos(1, 5), pos(2, 7), pos(3, 1),
                pos(4, 6), pos(5, 0), pos(6, 2), pos(7, 4));
        assertTrue(EightQueens.isSolution(board));
    }

    @Test
    public void
    eight_queens_fails() {
        List<Position> board = Arrays.asList(pos(0, 3),pos(1, 5), pos(2, 7), pos(3, 1),
                pos(4, 6), pos(5, 0), pos(7, 2), pos(7, 4));
        assertFalse(EightQueens.isSolution(board));
    }

    @Test
    public void
    it_should_accept_when_there_is_one_queen() {
        List<Position> board = asList(pos(0, 3));
        assertTrue(EightQueens.isSolution(board));
    }

    @Test
    public void
    it_should_refuse_two_queens_with_the_same_x() {
        List<Position> board = asList(pos(0, 3), pos(0, 5));
        assertFalse(EightQueens.isSolution(board));
    }

    @Test
    public void
    it_accepts_two_good_nice_sweet_gorgeous_queens() {
        List<Position> board = asList(pos(0, 0), pos(1, 3));
        assertTrue(EightQueens.isSolution(board));
    }

    @Test
    public void
    it_should_refuse_two_queens_with_same_y(){
        List<Position> board = asList(pos(0, 0), pos(1, 0));
        assertFalse(EightQueens.isSolution(board));
    }

    @Test
    public void
    it_should_refuse_two_queens_on_same_diagonal(){
        List<Position> board = asList(pos(0, 0), pos(1, 1));
        assertFalse(EightQueens.isSolution(board));
    }


    @Test
    public void
    it_should_refuse_two_intersect_among_three(){
        List<Position> board = asList(pos(0, 0), pos(1, 3), pos(0,7));
        assertFalse(EightQueens.isSolution(board));
    }

    @Test
    public void
    it_should_accept_three_nice_queens(){
        List<Position> board = asList(pos(0, 0), pos(1, 3), pos(2,7));
        assertTrue(EightQueens.isSolution(board));
    }

    @Test
    public void
    it_generates_a_solution() {
       System.out.print(EightQueens.findSolution(8).toString());

    }

}
