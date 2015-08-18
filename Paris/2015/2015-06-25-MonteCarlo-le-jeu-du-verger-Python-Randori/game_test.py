import game
from game import *
import unittest
 
class GameTest(unittest.TestCase):
    # def test_acceptance_test(self):
    # val monteCarlo = new MonteCarlo()
    #val winProba = monteCarlo.winProbability()
    #winProba should be <= 1.0
    #winProba should be >= 0.7
    def test_game_lost_after_nine_crows(self):
        game = Game(iter([Dice.CROW]*9))
        assert game.play() == Outcome.LOST
    def test_game_is_won_after_20_baskets(self):
        game = Game(iter([Dice.BASKET]*20))
        assert game.play() == Outcome.WIN
    def test_game_is_lost_after_20_baskets(self):
        game = Game(iter([Dice.BASKET] + [Dice.CROW]*9))
        assert game.play() == Outcome.LOST
    def test_game_is_won_after_8_crow_then_20_baskets(self):
        game = Game(iter([Dice.CROW]*8 + [Dice.BASKET]*20))
        assert game.play() == Outcome.WIN
    def test_game_is_lost_after_19_baskets_then_9_crows(self):
        game = Game(iter([Dice.BASKET]*19 + [Dice.CROW]*9))
        assert game.play() == Outcome.LOST