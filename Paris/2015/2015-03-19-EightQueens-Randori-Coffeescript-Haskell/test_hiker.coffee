imports = require './hiker'
describe 'jasmine-node', ->
  #it 'eight queens fit on a board', ->
  #  board= new imports.Board()
  #  expect(board.place(8)).toEqual [[1, 1], [3,1], (5,1), (1, 1), (3,1), (5,1),(1, 1), (3,1)]
  it 'one queen fits on a board', ->
    board = new imports.Board()
    expect(board.placeQueens(1)).toEqual [[0, 0]]
    expect(board.check([0,0])).toEqual false
  it 'two queens fit on a board', ->
    board = new imports.Board()
    board.placeQueens(1)
    expect(board.check([2,3])).toEqual true
    expect(board.check([0,1])).toEqual false
    expect(board.check([1,0])).toEqual false
    expect(board.check([1,1])).toEqual false