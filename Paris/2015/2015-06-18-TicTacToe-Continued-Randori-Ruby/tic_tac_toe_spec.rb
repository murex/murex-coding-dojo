require './tic_tac_toe'
class SinglePositionIA
  include IA
  def next(grid)
    [0,0]
  end
end
class StraightIA
  include IA
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
    expect(TicTacToe.play(byColumns, byLines)).to eq(:x)
  end
  it "forbids invalid move" do
    single= SinglePositionIA.new
    expect { TicTacToe.play(single, single) }.to raise_error
  end
  it "the second IA will win" do
    byColumns = ColumnIA.new
    middleLine = MiddleLineIA.new
    expect(TicTacToe.play(byColumns,middleLine)).to eq(:o)
  end
end
describe Grid do
  it "empty game is on going" do
    aGrid = Grid.new
    expect(aGrid.outcome).to eq(:on_going)
  end
  it "game with a line of x is won by x" do
    aGrid = Grid.new([
      [:x,:x,:x],
      [:_,:_,:_],
      [:_,:_,:_]])
    expect(aGrid.outcome).to eq(:x)
  end
  it "game with the second line of x is won by x" do
    aGrid = Grid.new([
      [:_,:_,:_],
      [:x,:x,:x],
      [:_,:_,:_]])
    expect(aGrid.outcome).to eq(:x)
  end
  it "game with a line of o is won by o" do
    aGrid = Grid.new([
      [:o,:o,:o],
      [:_,:_,:_],
      [:_,:_,:_]])
    expect(aGrid.outcome).to eq(:o)
  end
  it "game with a column of x is won by x" do
    aGrid = Grid.new([
      [:x,:_,:_],
      [:x,:_,:_],
      [:x,:_,:_]])
    expect(aGrid.outcome).to eq(:x)
  end
  it "game with a column of o is won by o" do
    aGrid = Grid.new([
      [:o,:_,:_],
      [:o,:_,:_],
      [:o,:_,:_]])
    expect(aGrid.outcome).to eq(:o)
  end
  it "game with a diagonal of x is won by x" do
    aGrid = Grid.new([
      [:x,:_,:_],
      [:_,:x,:_],
      [:_,:_,:x]])
    expect(aGrid.outcome).to eq(:x)
  end
   
   it "game with a diagonal of o is won by o" do
    aGrid = Grid.new([
      [:_,:_,:o],
      [:_,:o,:_],
      [:o,:_,:_]])
    expect(aGrid.outcome).to eq(:o)
  end
   it "game with a full grid and none wins" do
    aGrid = Grid.new([
      [:o,:x,:o],
      [:x,:x,:o],
      [:o,:o,:x]])
    expect(aGrid.outcome).to eq(:draw)
  end
end