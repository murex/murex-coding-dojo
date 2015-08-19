require 'matrix'
class TicTacToe
  def self.play(ia1,ia2)
    grid = Grid.new
     
    move1 = ia1.next(grid)
    grid.tick(move1, :x)
    move2 = ia2.next(grid)
     
    raise "Invalid move #{move2} by #{ia2}" if move1 == move2
    ia1
  end
end
class Grid
  def initialize()
   @grid = [[:_,:_,:_],[:_,:_,:_],[:_,:_,:_]]
  end 
   
  def isTicked(position)
    @grid[position[0]][position[1]] != :_
  end
  def tick(move,single)
    @grid[move[0]][move[1]] = single
  end
end