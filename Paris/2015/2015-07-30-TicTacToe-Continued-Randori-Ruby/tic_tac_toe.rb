require 'matrix'
module IA
  attr_accessor :symbol
end
class TicTacToe
  def self.play(ia1,ia2)
    grid = Grid.new
    ia1.symbol = :x
    ia2.symbol = :o
    nextPlayer = ia1
    other = ia2
    while (outcome = grid.outcome) == :on_going
      move = nextPlayer.next(grid)
      symbol = nextPlayer.symbol
      raise "Invalid move #{move} by #{symbol}" if grid.isTicked(move)
      grid.tick(move, symbol)     
      nextPlayer, other = [other, nextPlayer]
    end 
    outcome
  end
end
class Array
  def diagonals()
    [[self[0][0], self[1][1], self[2][2]],[self[2][0], self[1][1], self[0][2]]]
  end
end
class Grid
  def initialize(grid = [[:_,:_,:_],[:_,:_,:_],[:_,:_,:_]])
   @grid = grid
  end 
   
  def isTicked(position)
    @grid[position[0]][position[1]] != :_
  end
  def tick(move,single)
    @grid[move[0]][move[1]] = single
  end
  def outcome
    table = @grid + @grid.transpose + @grid.diagonals
    [:x, :o].each do |s|
      return s if table.include?([s, s, s])
    end
    return :draw unless @grid.flatten.include?(:_)
    :on_going
  end
   
end