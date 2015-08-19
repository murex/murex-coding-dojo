package game;

import java.util.List;
import java.util.Random;

public class Position {

    private static Random random = new Random();
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position pos(int x, int y) {
        return new Position(x, y);
    }

    private boolean isSameX(Position position) {
        return this.x == position.x;
    }

    public boolean intersect(Position secondPosition) {
        return isSameX(secondPosition) ||isSameY(secondPosition) || isSameDiagonal(secondPosition);
    }

    private boolean isSameDiagonal(Position position) {
        return Math.abs(this.x - position.x) == Math.abs(this.y - position.y);
    }

    private boolean isSameY(Position position) {
        return this.y == position.y;
    }

    public boolean intersectPositions(List<Position> board, int i) {
        for (int j = i + 1; j < board.size(); j++) {
            if (intersect(board.get(j)))
                return true;
        }
        return false;
    }

    public static Position newRandomPosition(int size) {
        return new Position(randomInt(size), randomInt(size));
    }

    private static int randomInt(int size) {
        return (random.nextInt(size));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
