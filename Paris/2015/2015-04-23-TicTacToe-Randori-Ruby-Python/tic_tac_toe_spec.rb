require './tic_tac_toe'
class SinglePositionIA
  def next(grid)
    [0,0]
  end
end
class StraightIA
  def initialize()
    @counter = -1
  end
  def next(grid)
    @counter += 1
    return position() unless grid.isTicked(position())
    self.next(grid)
  end
end
class ColumnIA < StraightIA
  def position()
    [@counter/3,@counter%3]
  end
end
class LineIA < StraightIA
  def position()
    [@counter%3,@counter/3]
  end
end
class MiddleLineIA < LineIA
  def initialize()
    super()
    @counter += 3
  end
end
 
describe "TicTacToe" do
  #it "2 IAs can compete" do
  #   expect(TicTacToe.compete(11,ColumnIA.new, LineIA.new)).to eq(columns: 6, lines: 5, draws: 0)
  #end
  it "runs one game" do
    byColumns = ColumnIA.new
    byLines = LineIA.new
    expect(TicTacToe.play(byColumns, byLines)).to eq(byColumns)
  end
  it "forbids invalid move" do
    single= SinglePositionIA.new
    expect { TicTacToe.play(single, single) }.to raise_error
  end
  it "the second IA will win" do
    byColumns = ColumnIA.new
    middleLine = MiddleLineIA.new
    expect(TicTacToe.play(byColumns,middleLine)).to eq(middleLine)
  end
end