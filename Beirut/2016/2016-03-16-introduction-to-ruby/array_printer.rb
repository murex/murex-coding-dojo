class ArrayPrinter
  def printArray
    (1..16).to_a.each_slice(4).
            to_a.map {|subArray| puts "My array #{subArray}"}
  end
end

x = ArrayPrinter.new
x.printArray

