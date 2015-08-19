from hiker import *
def test_complete_score():
    '''a simple example to start you off'''
    assert score("X|X|7/|9/|X|7/|X|9/|X||X7") == 201
def test_miss_give_0():
    assert score("--|--|--|--|--|--|--|--|--|--||") == 0
def test_one_X_give_10():
    assert score("X|--|--|--|--|--|--|--|--|--||") == 10
def test_5_then_miss_gives_5():
    assert score("5-|--|--|--|--|--|--|--|--|--||") == 5
def test_miss_then_gives_5():
    assert score("-5|--|--|--|--|--|--|--|--|--||") == 5
def test_3_then_5_gives_8():
    assert score("35|--|--|--|--|--|--|--|--|--||") == 8
def test_2_rounds_gives_11():
    assert score("35|12|--|--|--|--|--|--|--|--||") == 11
 
def test_3_rounds_gives_14():
    assert score("35|12|--|--|--|--|--|--|12|--||") == 14
def test_5_then_spare_gives_10():
    assert score("5/|--|--|--|--|--|--|--|--|--||") == 10
def test_it_doubles_the_next():
   assert score("5/|1-|--|--|--|--|--|--|--|--||") == 12
def test_3_then_spare_4_then_spare_gives_10():
    assert score("3/|4/|--|--|--|--|--|--|--|--||") == 24
def test_3_then_spare_then_X_then_4_then_spare_gives_50():
    assert score("3/|X|4/|--|--|--|--|--|--|--||") == 50
def test_no_spare_no_strike():
    assert score("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||") == 90
def test_only_spare_no_strike():
    assert score("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5") == 155
def test_only_spare_no_strike():
    assert score("X|X|X|X|X|X|X|X|X|X||XX") == 330