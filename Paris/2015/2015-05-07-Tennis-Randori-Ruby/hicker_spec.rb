require './hiker'
describe "hiker" do
  it "starts at O-O" do
    expect(score(0,0)).to eq "0-0"
  end
  it "the first point make 15-O" do
    expect(score(1,0)).to eq "15-0"
  end
  it "the first point make 0-15" do
    expect(score(0,1)).to eq "0-15"
  end
  it "the second point make 0-30" do
    expect(score(0,2)).to eq "0-30"
  end
  it "the third point make 0-40" do
    expect(score(0,3)).to eq "0-40"
  end
  it "the 15 tie make 15-A" do
    expect(score(1,1)).to eq "15-A"
  end
  it "the 40 tie make 40-A" do
    expect(score(3,3)).to eq "40-A"
  end
  it "the serving player at 4 points wins" do
    expect(score(4,1)).to eq "win in"
  end
  it "the receiving player at 4 points wins" do
    expect(score(2,4)).to eq "win out"
  end
  it "the serving player needs 2 more points to win" do
    expect(score(4,3)).to eq "ad in"
  end
  it "the receiving player needs 2 more points to win" do
    expect(score(3,4)).to eq "ad out"
  end
  it "the serving player needs 2 more points to win 2" do
    expect(score(5,4)).to eq "ad in"
  end
  it "the receiving player needs 2 more points to win" do
    expect(score(4,5)).to eq "ad out"
  end
  it "the second tie at 40 make deuce" do
    expect(score(4,4)).to eq "deuce"
  end
   
end