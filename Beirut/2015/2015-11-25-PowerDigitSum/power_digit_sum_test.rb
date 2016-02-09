require "test/unit"
require_relative "power_digit_sum"

class PowerDigitSumTest < Test::Unit::TestCase
  def test_digital_sum_of_2_0_is_1
    assert_digital_sum(1, 0)
  end


  def test_digital_sum_of_2_1_is_2
    assert_digital_sum(2, 1)
  end

  def test_digital_sum_of_2_4_is_7
    assert_digital_sum(7, 4)
  end

  def test_digital_sum_of_2_15_is_26
    assert_digital_sum(26, 15)
  end

  def test_digital_sum_of_2_1000_is_1366
    assert_digital_sum(1366, 1000)
  end

  def assert_digital_sum(expected, power)
    assert_equal(expected, PowerDigitSum.new.compute(power))
  end


end