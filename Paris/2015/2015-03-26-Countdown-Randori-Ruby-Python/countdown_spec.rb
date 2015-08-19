require './countdown'
describe "countdown" do
   
  it "acceptance test" do
    expect(Countdown.solve([100, 5, 5, 2, 6, 8], 522)).to eq("5*100+(5+6)*2 = 522")
  end
  it "solving with numbers 1 on target 1 should return 1 = 1" do
    expect(Countdown.solve([1], 1)).to eq("1 = 1")
  end
  it "solving with numbers 2 on target 2 should return 2 = 2" do
    expect(Countdown.solve([2], 2)).to eq("2 = 2")
  end
  it "solving with numbers 1 and 2 on target 2 should return 2 = 2" do
    expect(Countdown.solve([1,2], 2)).to eq("2 = 2")
  end
  it "solving with numbers 1 and 2 on target 3 should return 1 + 2 = 3" do
    expect(Countdown.solve([1,2], 3)).to eq("(1+2) = 3")
  end
  it "solving with numbers 2, 3 and 4 on target 5 should return 2 + 3 + 4 = 9" do
    expect(Countdown.solve([2,3,4], 9)).to eq("(2+(3+4)) = 9")
  end
  it "solving with numbers 2, 4 on target 8 should return 2*4= 8" do
    expect(Countdown.solve([2,4], 8)).to eq("2*4 = 8")
  end
  it "solving with numbers 2, 3 and 5 on target 25 should return (2+3)*5 = 25" do
    expect(Countdown.solve([2,3,5], 25)).to eq("5*(2+3) = 25")
  end
end