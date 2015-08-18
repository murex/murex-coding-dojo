from enum import Enum
 
class Outcome(Enum):
    LOST = 1
    WIN = 2
class Dice(Enum):
    CROW = 1
    BASKET = 2
class Game:
    def __init__(self, sequence):
        self.sequence = sequence
    def play(self):
        crowCount = 0
        basketCount = 0
        while(True):
            if next(self.sequence) == Dice.CROW:
                crowCount += 1
            else:
                basketCount += 1
            if crowCount == 9:
                return Outcome.LOST
            if basketCount == 20:
                return Outcome.WIN