import unittest
import ia
import tournament
class TestHiker(unittest.TestCase):
#    def test_life_the_universe_and_everything(self):
#        '''acceptance_test'''
#        ia1 = IA('X')
#        ia2 = IA('O')
#        tournament = hiker.Tournament(ia1, ia2)
#        tournament.launch(100)
#        self.assertEqual(0, tournament.winBy1())
    def test_an_ia_can_play(self):
        ia1 = ia.IA('X')
        self.assertEqual([0,0], ia1.play(empty_grid()))
    def test_an_ia_play_in_order(self):
        ia1 = ia.IA('X')
        grid = empty_grid()
        self.assertEqual([0, 0], ia1.play(grid))
        grid[0][0] = 'X'
        self.assertEqual([1, 0], ia1.play(grid))
     
    def test_a_tournament_can_finish(self):
        self.assertEqual(True, tournament.Tournament.checkGridFinished([['X'] * 3] + [[' '] * 3] * 2))
     
    def test_a_tournament_not_finished(self):
        self.assertEqual(False, tournament.Tournament.checkGridFinished([[' '] * 3] * 3))
    def test_a_tournament_finished_with_col(self):
        self.assertEqual(True, tournament.Tournament.checkGridFinished([['X', ' ', ' ']] * 3))      
    def test_a_tournament_finished_with_diag(self):
        grid = empty_grid()
        grid[0][0] = 'X'
        grid[1][1] = 'X'
        grid[2][2] = 'X'
        self.assertEqual(True, tournament.Tournament.checkGridFinished(grid))
    def test_a_tournament_finished_with_diag(self):
        grid = empty_grid()
        grid[0][2] = 'X'
        grid[1][1] = 'X'
        grid[2][0] = 'X'
        self.assertEqual(True, tournament.Tournament.checkGridFinished(grid))
    def test_a_tournament_finished_with_no_winner(self):
        grid = [['X', 'O', 'O'], ['O', 'X', 'X'], ['O', 'X', 'O']]
        self.assertEqual(True, tournament.Tournament.checkGridFinished(grid))
def empty_grid():
    return [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']]
if __name__ == '__main__':
    unittest.main()