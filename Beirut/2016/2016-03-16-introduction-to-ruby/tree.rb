class Tree
  attr_accessor :children, :node_name
  def initializeNode(name, children=[])
    @children = children
    @node_name = name

    # puts name + children.to_s
  end

  def initializeTree(name, tree={})
    @node_name = name
    @children = tree.each {|key, value| initializeTree(key, value)}
  end

  def initialize(tree={})
    parent = tree.keys[0]
    initializeTree(parent, tree[parent])
  end


  def visit_all(&block)
    visit &block
    children.each {|c| c.visit_all &block}
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

ruby_tree = Tree.new({'grandpa' => {'dad' => {'child 1' => {}, 'child 2' => {} }, 'uncle' => {'child3' => {}, 'child 4' => {} } } })
ruby_tree.visit_all {|node| puts node.node_name}