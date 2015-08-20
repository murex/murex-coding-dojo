TURN_LEFT = "turn_left"
TURN_RIGHT = "turn_right"
FWD = "fwd"
 
class Plateau:
    orientations = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    def __init__(self, starPositions):
        self.starPositions = starPositions
        self.pos = [0, 0]
        self._orientation = 0
    def move(self, moves):
        count = 0
        for move in moves:
            count += self.step(move)
        return count
    def step(self, move):
        if move == FWD:
            self.pos = self.sum(self.pos, self.orientation())
            if self.pos in self.starPositions:
                self.starPositions.remove(self.pos)
                return 1
        if move == TURN_RIGHT:
            self._orientation = (self._orientation + 1) % 4
        if move == TURN_LEFT:
            self._orientation = (self._orientation - 1) % 4
        return 0
    def orientation(self):
        return self.orientations[self._orientation]
    @classmethod
    def sum(self, a, b):
        return [a[0] + b[0], a[1] + b[1]]