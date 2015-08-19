import power4
#def test_final():
#    assert power4.isOver([
#        [0, 1, 2, 1, 2, 1, 1],
#        [0, 2, 1, 1, 1, 2, 2],
#        [0, 1, 2, 2, 2, 1, 1],
#        [1, 2, 1, 1, 1, 2, 2],
#        [2, 1, 1, 2, 2, 2, 1],
#        [1, 2, 2, 1, 2, 1, 2],
#    ]) == True
def test_p1_win_one_line():
    assert power4.isOver([[0, 1, 1, 1, 1, 2, 1]]) == True
def test_p2_win_one_line():
    assert power4.isOver([[0, 1, 2, 2, 2, 2, 1]]) == True
def test_draw_one_line():
    assert power4.isOver([[0, 1, 2, 1, 2, 2, 1]]) == False
def test_p1_win_with_two_lines():
    assert power4.isOver([
        [0, 1, 2, 1, 2, 2, 1],
        [0, 1, 1, 1, 1, 2, 1]
    ]) == True
def test_p1_wins_one_column():
    assert power4.isOver([
        [0],
        [0],
        [1],
        [1],
        [1],
        [1]
    ]) == True
def test_p2_wins_one_column():
    assert power4.isOver([
        [0],
        [0],
        [2],
        [2],
        [2],
        [2]
    ]) == True
def test_p2_wins_one_column():
    assert power4.isOver([
        [0,0],
        [0,0],
        [0,1],
        [2,1],
        [2,1],
        [2,1]
    ]) == True
def test_diagonal():
    assert power4.isOver([
        [0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 1],
        [0, 0, 0, 0, 0, 1, 2],
        [0, 0, 0, 0, 1, 2, 1],
        [0, 0, 0, 1, 2, 1, 2],
    ]) == True