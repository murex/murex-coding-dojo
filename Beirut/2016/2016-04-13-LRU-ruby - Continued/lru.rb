class LRU
  attr_accessor :capacity, :hash, :list

  def initialize
    @capacity = 5
    @hash = {}
    @list = DoublyLinkedList.new
  end

  def get(key)
    if !hash.has_key?(key)
      return
    end
    node = list.delete(hash[key])
    list.push(node)
    return node.data.value
  end

  def set(key,value)

    if hash.has_key?(key)
      node = list.delete(hash[key])
      node.data.value = value
      list.push(node)
    else
      if @list.size == @capacity
        tail = list.delete(list.tail)
        hash.delete(tail.data.key)
      end
      newNode = Node.new(Pair.new(key, value))
      hash[key] = newNode
      list.push(newNode)
    end

  end

  def display
    puts @hash

    @list.display
  end

end

class Pair
  attr_accessor :key, :value

  def initialize(key,value)
    @key = key
    @value = value
  end


  def to_s
    @key.to_s + ", "+ @value.to_s
  end
end

class Node
  attr_accessor :next_node, :prev_node, :data

  def initialize(data=nil, n=nil, p=nil)
    @data = data
    @next_node = n
    @prev_node = p
  end

  def print
    puts @data
  end

end

class DoublyLinkedList
  attr_accessor :head, :tail, :size

  def initialize()
      @size = 0
      @head = nil
      @tail = nil
  end

  def display
    ptr = @head
    puts 'Linked list:'
    while ptr != nil
      puts ptr.data
      ptr = ptr.next_node
    end
    puts 'end;'
  end
  def displayR
    ptr = @tail
    puts 'Linked list:'
    while ptr != nil
      puts ptr.data
      ptr = ptr.prev_node
    end
    puts 'end;'
  end
  def push(node)
    if size == 0
        @tail = node
        @head = node
    else
       @head.prev_node = node
        node.next_node = @head
    end
    @head = node
    @size = @size + 1
  end

  def delete(node)

    if @size == 0
      return
    end
    if @size == 1
      @head = nil
      @tail = nil
    elsif node != @head && node != @tail
      node.prev_node.next_node=node.next_node
      node.next_node.prev_node=node.prev_node
    elsif node == @head
      @head = @head.next_node
      @head.prev_node = nil
    elsif node == @tail
      @tail = @tail.prev_node
      @tail.next_node = nil
    end
    @size = @size - 1
    node.next_node = nil
    node.prev_node = nil
    return node
  end

end

# dll = DoublyLinkedList.new()
#
# dll.display
#
# node1 = Node.new(Pair.new(1,10))
# dll.push(node1)
# node2 = Node.new(Pair.new(2,20))
# dll.push(node2)
# node3 = Node.new(Pair.new(3,30))
# dll.push(node3)
# node4 = Node.new(Pair.new(4,40))
# dll.push(node4)
#
# dll.display
# puts "removing 2"
# dll.delete(node2)
# dll.display
#
# puts "removing 1"
# dll.delete(node1)
# dll.display
# puts "removing 4"
# dll.delete(node4)
# dll.display
# puts "removing 3"
# dll.delete(node3)
# dll.display

lru = LRU.new()


lru.set(1,10)
lru.set(2,20)
lru.set(3,30)  
lru.set(1,100)

lru.set(4,40)
lru.set(5,50)
lru.set(2,200)
lru.set(6,60)

puts lru.get(5)
puts lru.get(10)

lru.display
