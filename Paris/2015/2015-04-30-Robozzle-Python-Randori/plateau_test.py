import unittest
from plateau import *
TURN_RIGHT = "turn_right"
TURN_LEFT = "turn_left"
FWD = "fwd"
 
class Test(unittest.TestCase):
    # def test_life_the_universe_and_everything(self):
    #     '''a simple example to start you off'''
    #     plateau = Plateau([[]])
    #     assert plateau.move([FWD, FWD, TURN_LEFT, FWD]) == 1
    def test_fwd_make_it_advance(self):
        plateau = Plateau([[0, 1]])
        assert plateau.move([FWD]) == 1
    def test_fwd_make_it_advance_without_star(self):
        plateau = Plateau([[0, 2]])
        assert plateau.move([FWD]) == 0
    def test_2_times_fwd_can_reach_further_stars(self):
        plateau = Plateau([[0, 2]])
        assert plateau.move([FWD, FWD]) == 1
    def test_3_turn_right(self):
        plateau = Plateau([[1, 0]])
        assert plateau.move([TURN_RIGHT, FWD]) == 1
    def test_2_times_fwd_can_step_over_stars(self):
        plateau = Plateau([[0, 1]])
        assert plateau.move([FWD, FWD]) == 1
    def test_turn_left(self):
        plateau = Plateau([[-1, 0]])
        assert plateau.move([TURN_LEFT, FWD]) == 1
    def test_star_not_reaching_star(self):
        plateau = Plateau([[1, 1]])
        assert plateau.move([FWD, FWD]) == 0
    def test_4_turns_left_reaching_start(self):
        plateau = Plateau([[0, 1]])
        assert plateau.move([TURN_LEFT, TURN_LEFT, TURN_LEFT, TURN_LEFT, FWD]) == 1
    def test_reaching_2_stars(self):
        plateau = Plateau([[0, 1], [0, 2]])
        assert plateau.move([FWD, FWD]) == 2
    def test_not_eating_starts_twice(self):
        plateau = Plateau([[0, 1]])
        assert plateau.move([FWD, TURN_RIGHT, TURN_RIGHT, FWD, TURN_RIGHT, TURN_RIGHT, FWD]) == 1
if __name__ == "__main__":
    suite = unittest.defaultTestLoader.loadTestsFromTestCase(Test)
    unittest.TextTestRunner().run(suite)