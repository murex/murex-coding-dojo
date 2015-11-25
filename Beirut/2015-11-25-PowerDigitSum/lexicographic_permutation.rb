class LexicographicPermutation
  def compute(digits)
    if (digits.size == 1)
      Array[digits[0].to_s]
    else
      permutations = Array.new
      digits.each do |i|
        digitsToPermute = digits.clone()
        digitsToPermute.delete(i)
        swapBase(digitsToPermute).each do |basePermutation|
          permutations.insert(0, i.to_s + "," + basePermutation)
        end
      end
      permutations.reverse
    end
  end


  def swapBase(digits)
    if (digits.size == 1)
      Array[digits[0].to_s]
    else
      first_digit = digits[0].to_s
      second_digit = digits[1].to_s
      first_digit+ "," +second_digit
      Array[first_digit+ "," +second_digit, second_digit+ "," +first_digit]
    end
  end
end