require "test/unit"
require_relative "lexicographic_permutation"

class LexicographicPermutationTest < Test::Unit::TestCase
  def test_permutation_of_a_digit_returns_the_digit_itself
    assert_equal(Array["0"], LexicographicPermutation.new.compute(Array(0)))
  end

  def test_permutation_of_2_digit_should_return_2_cases
    assert_equal(Array["0,1","1,0"], LexicographicPermutation.new.compute(Array(0..1)))
  end

  def test_permutation_of_3_digit_should_return_6_cases
    assert_equal(Array["0,1,2","0,2,1","1,0,2","1,2,0","2,0,1","2,1,0"], LexicographicPermutation.new.compute(Array(0..2)))
  end

end