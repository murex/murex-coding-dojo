package game;

import java.util.ArrayList;
import java.util.List;

import static game.Position.newRandomPosition;

public class EightQueens {

    static boolean isSolution(List<Position> board) {
        int size = board.size();
        for (int i = 0; i < size; i++) {
            Position firstPosition = board.get(i);
            if (firstPosition.intersectPositions(board, i)) {
                return false;
            }
        }
        return true;
    }

    public static List<Position> findSolution(int boardSize) {
        List<Position> generated;
        while (true) {
            generated = generate(boardSize);
            if (isSolution(generated))
                return generated;
        }
    }

    private static List<Position> generate(int size) {
        List<Position> solution = new ArrayList<Position>();
        for (int i = 0; i < size; i++) {
            solution.add(newRandomPosition(size));
        }
        return solution;
    }
}
