class LRU
  size = 5;
  hash = {};

  def get(key)
  end

  def set(key,value)
  end

end

class Node
  attr_accessor :next_node
  attr_accessor :prev_node
  attr_accessor :data

  def initialize(data=null, n=null, p=null)
    @data = data
    @next_node = n
    @prev_node = p
  end
end

class DoublyLinkedList
  attr_accessor :head, :tail, :max_size, :size

  def initialize(max_size)
      @size = 0
      @head = null
      @tail = null
  end

  def push(node)
    if size == 0
      @tail = node
    end

    node.next_node = @head
    node.prev_node = null
    @head = node
    @size = @size + 1
  end

  def delete(node)

    if @size == 0
      return
    end
    if @size == 1
      @head = null
      @tail = null
    elsif node != @head && node != @tail
      node.prev_node.next_node=node.next_node
      node.next_node.prev_node=node.prev_node
    elsif node == @head
      node.next_node.prev_node=node.prev_node
    elsif node == @tail
      node.prev_node.next_node=node.next_node
    end
    @size = @size - 1
    #node.prev_node = node.next_node = null
    #node = null
  end

end



