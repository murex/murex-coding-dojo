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
class NotDumbIA
  def initialize()
    default = LineIA.new
  end
   
  def alignedHelper(table)
    [:x, :o].each do |s|
      index = table.index([:_, s, s])
      return [index, 0] unless index == nil
      index = table.index([s, :_, s])
      return [index, 1] unless index == nil
      index = table.index([s, s, :_])
      return [index, 2] unless index == nil
    end
    return nil
  end
   
  def getPositionToPlay(aGrid)
    grid = aGrid.instance_variable_get(:@grid)
    position = alignedHelper(grid)
    return position unless position==nil
     
    position = alignedHelper(grid.transpose)
    return position.reverse unless position==nil
    return nil
  end
  def next(grid)
    table = grid + grid.transpose + grid.diagonals
    [:x, :o].each do |s|
      return s if table.include?([_, s, s]) || table.include?([s, s, _]) || table.include([s, _, s])
    end
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
describe "IA" do
  it "alignedHelper find two aligned in second and third columns" do
    ia = NotDumbIA.new
    aTable = [
      [:_,:_,:_],
      [:_,:x,:x],
      [:_,:_,:_]]
    expect(ia.alignedHelper(aTable)).to eq([1, 0])
  end
  it "alignedHelper find two aligned box in first and third columns" do
    ia = NotDumbIA.new
    aTable = [
      [:_,:_,:_],
      [:_,:_,:_],
      [:x,:_,:x]]
    expect(ia.alignedHelper(aTable)).to eq([2, 1])
  end
  it "alignedHelper find two aligned box in first and second columns" do
    ia = NotDumbIA.new
    aTable = [
      [:x,:x,:_],
      [:_,:_,:_],
      [:_,:_,:_]]
    expect(ia.alignedHelper(aTable)).to eq([0, 2])
  end
  it "getPositionToPlayfind two aligned box" do
    ia = NotDumbIA.new
    aGrid = Grid.new([
      [:_,:_,:_],
      [:_,:x,:x],
      [:_,:_,:_]])
    expect(ia.getPositionToPlay(aGrid)).to eq([1, 0])
  end
  it "getPositionToPlayfind two aligned box" do
    ia = NotDumbIA.new
    aGrid = Grid.new([
      [:_,:_,:o],
      [:_,:_,:_],
      [:_,:_,:o]])
    expect(ia.getPositionToPlay(aGrid)).to eq([1, 2])
  end
  #it "getPositionToPlay find two aligned box in diagonal" do
  #  ia = NotDumbIA.new
  #  aGrid = Grid.new([
  #    [:x,:_,:_],
  #    [:_,:_,:_],
  #    [:_,:_,:x]])
  #  expect(ia.getPositionToPlay(aGrid)).to eq(true)
  #end
  it "getPositionToPlay should return false for no box aligned" do
    ia = NotDumbIA.new
    aGrid = Grid.new([
      [:x,:_,:o],
      [:_,:_,:_],
      [:_,:_,:_]])
    expect(ia.getPositionToPlay(aGrid)).to eq(nil)
  end
  #it "getPositionToPlay should return false for two different aligned" do
  #  ia = NotDumbIA.new
  #  aGrid = Grid.new([
  #    [:x,:_,:_],
  #    [:_,:_,:_],
  #    [:_,:_,:o]])
  #  expect(ia.getPositionToPlay (aGrid)).to eq(false)
  #end
  #it "NotDumbIA should tick the third box to finish a game" do
  #  aGrid = Grid.new([
  #    [:_,:_,:_],
  #    [:_,:x,:x],
  #    [:_,:_,:_]])
  #  ia = NotDumbIA
  #  expect(ia.next(aGrid))
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