class PowerDigitSum
  def compute(power)
    sum=0
    to_power = (2**power).to_s
    digits = to_power.split("").each do |i|
      sum = sum+ i.to_i
    end
    sum
  end
end