require './hiker'
describe "hiker" do
   
  it "acceptance test" do
    expect(combine([934,94,3589,769,940])).to eq "949409347693589"
  end
   
  it "combining a number should return the number" do
    expect(combine([1])).to eq "1"
  end
  it "combining 1 and 2 should return 21  " do
    expect(combine([1,2])).to eq "21"
  end
  it "combines 10 and 2 should return 210" do
    expect(combine([10,2])).to eq "210"
  end
  it "combines 10 and 1 should return 110" do
    expect(combine([10,1])).to eq "110"
  end
  it "combines 1 and 10 should return 110" do
    expect(combine([1,10])).to eq "110"
  end
  it "combines 1 and 10 and 2 should return 110" do
    expect(combine([1,10,2])).to eq "2110"
  end
   
  it "combines 344 and 339 33 should return 110" do
    expect(combine([344,339,33])).to eq "34433933"
  end
  it "according to our sorting function, 2 is less  than 1" do
    expect(compare(1,2)).to eq 2<=>1
  end
  it "according to our sorting function, 1 is greater than 2" do
    expect(compare(2,1)).to eq 2<=>1
  end
  it "according to our sorting function, 10 is greater than 1" do
    expect(compare(1,10)).to eq 1<=>10
  end
  it "according to our sorting function, 20 is greater than 2" do
    expect(compare(20,2)).to eq 2<=>20
  end
  it "according to our sorting function, 10 is less than 2" do
    expect(compare(10,2)).to eq 2<=>10
  end
end