 import hiker
import operator
#def test_acceptance_test():
#    '''Acceptance test'''
#    numbers = [100, 5, 5, 2, 6, 8]
#    target = 522
#    result, calc = hiker.countdown(numbers, target)
#    assert result == target
def test_one_plus_two():
    numbers = [100, 1, 5, 2, 6, 8]
    target = 3
    calc = hiker.countdown(numbers, target)
    assert target == eval(calc)
def test_target_in_the_list():
    numbers = [100, 3, 5, 2, 6, 8]
    target = 3
    calc = hiker.countdown(numbers, target)
    assert target == eval(calc)
def test_five_plus_two():
    numbers = [100, 3, 5, 2, 6, 8]
    target = 7
    calc = hiker.countdown(numbers, target)
    assert target == eval(calc)
def test_three_time_hundred():
    numbers = [100, 3, 5, 2, 6, 8]
    target = 300
    calc = hiker.countdown(numbers, target)
    assert target == eval(calc)
def test_apply_op():
    assert eval(hiker.apply_operator("+", [2, 1], 3)) == 3
def test_addition_3_elems():
    numbers = [100, 3, 5, 2, 6, 9]
    target = 108
    calc = hiker.countdown(numbers, target)
    assert target == eval(calc)