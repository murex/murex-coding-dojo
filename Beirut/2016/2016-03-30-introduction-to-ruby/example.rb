class Tree
  attr_accessor :children, :node_name
 
  def initializeTree(name, treeMap)
    @node_name = name
	if treeMap!=nil 
		@children = treeMap.values.map{|value| Tree.new(value)}
	end
  end

  def initialize(treeMap)
    parent = treeMap.keys[0]
    initializeTree(parent, treeMap[parent])
  end


  def visit_all(&block)
    visit &block
	if children != nil
    children.each {|c| puts c.visit_all &block}
  end
  end
  
  def visit(&block)
    block.call self
  end
end
# ruby_tree = Tree.new( "Ruby",
#                       [Tree.new("Reia"),
#                        Tree.new("MacRuby")] )
# puts "Visiting a node"
# ruby_tree.visit {|node| puts node.node_name}
# puts
# puts "visiting entire tree"
# ruby_tree.visit_all {|node| puts node.node_name}


#ruby_tree = Tree.new({'grandpa' => {'dad' => { }}})
ruby_tree = Tree.new({'grandpa' => {'dad' => {'child 1' => {}, 'child 2' => {} }, 'uncle' => {'child3' => {}, 'child 4' => {} } } })
ruby_tree.visit_all {|node| puts node.node_name}