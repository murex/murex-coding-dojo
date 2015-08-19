from CountCulture import *
 
__author__ = 'rjulien'
import unittest
 
UP_TO_10 = [i for i in range(1, 11)]
 
 
class TestCountCulture(unittest.TestCase):
    def test_acceptance_test(self):
        self.assertEqual(len(twist_count(91)), 20)
 
    def test_count_to_1_should_return_1(self):
        self.assertEqual(twist_count(1), [1])
 
    def test_it_should_incrementally_count_to_10(self):
        self.assertEqual(twist_count(10), UP_TO_10)
 
    def test_count_to_21(self):
        self.assertEqual(twist_count(21), UP_TO_10 + [11, 12, 21])
 
    def test_best_path_return_shortest_path(self):
        self.assertEqual(best_path([[1], [1, 2]]), [1])
 
    def test_best_path_return_shortest_path_not_at_the_beginning(self):
        self.assertEqual(best_path([[1, 2], [2]]), [2])
 
    def test_switch_reverses_the_inputs(self):
        self.assertEqual(switch(45), 54)
 
    def test_switch_drops_the_zeros(self):
        self.assertEqual(switch(320), 23)