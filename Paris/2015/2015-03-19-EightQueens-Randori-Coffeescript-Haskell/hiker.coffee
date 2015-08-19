class exports.Board
  constructor: () ->
    @queens = []
  place: () ->
    @queens.push [0,0]
  placeQueens: (nbQueens) ->
    @place() for num in [1..nbQueens]
    @queens
  check: (coord) ->
    [row,col] = coord
    result = true
    for queen in @queens
       if same_column(coord, queen) || same_row(coord, queen)
          result = false
       if same_diag_fwd(coord, queen) || same_diag_bckw(coord, queen)
          result = false
    result
  same_column: (coord1, coord2) ->
    coord1[1] == coord2[1]
  same_row: (coord1, coord2) ->
    coord1[0] == coord2[0]
     
  same_diag_bckw(coord1, coord2) ->
    coord1[0] - coord2[0] == coord1[1] - coord2[1]
     
  same_diag_fwd(coord1, coord2) ->
    coord1[0] - coord2[1] == coord1[0] - coord2[1]