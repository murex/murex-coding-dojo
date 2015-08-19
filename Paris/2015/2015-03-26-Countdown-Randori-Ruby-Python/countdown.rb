class Countdown
  def self.solve(numbers, target)   
    search(expressions(numbers.map &:to_s), target)
  end
  def self.expressions(numbers)
    return [] if numbers.empty?
  
    numbers.map do | number |
      generate(numbers, number)
    end.flatten
  end
  def self.generate(numbers, number)
    exps = expressions(numbers.reject {|x| x == number} )
      [number] +
        exps +
        exps.map { |exp| "(#{number}+#{exp})" } +
        exps.map { |exp| "#{number}*#{exp}" }
  end
  def self.search(expressions, target)
    expressions.each do |expression|
      if eval(expression) == target
        return "#{expression} = #{target}"
      end
    end
    return expressions
  end
end