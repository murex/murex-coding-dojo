import hiker
import unittest
class TestHiker(unittest.TestCase):
    #def test_acceptance(self):
    #    douglas = hiker.SaddlePoints()
    #    self.assertEqual([[0,2],[1,1]], douglas.getSaddlePoints([[1,2,3,2,1],[1,8,4,5,7],[1,10,5,1,1],[1,11,4,1,1],[1,10,4,1,1]]))
     
    def test_empty_input_should_return_empty_list(self):
        saddle = hiker.SaddlePoints()
        self.assertEqual([], saddle.getSaddlePoints([]))
    def test_1_1_matrix_should_return_itself(self):
        saddle = hiker.SaddlePoints()
        self.assertEqual([[0,0]], saddle.getSaddlePoints([[1]]))
  
    def test_1_2_matrix_should_return_itself(self):
        saddle = hiker.SaddlePoints()
        self.assertEqual([[0,1]], saddle.getSaddlePoints([[1, 2]]))
    def test_1_5_matrix_should_return_itself(self):
        saddle = hiker.SaddlePoints()
        self.assertEqual([[0,2], [0, 4]], saddle.getSaddlePoints([[1, 2, 3, 2, 3]]))
    def test_2_1_matrix_should_return_itself(self):
        saddle = hiker.SaddlePoints()
        self.assertEqual([[1,0]], saddle.getSaddlePoints([[2],[1]]))
if __name__ == '__main__':
    unittest.main()