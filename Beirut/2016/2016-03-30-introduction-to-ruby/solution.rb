class Tree
  attr_accessor :children, :node_name
 
  def initialize(treeMap,name='**Root**')
	@node_name = name
	@children = []
	treeMap.each{|key,value| @children << Tree.new(value,key)}
  end

  def visit_all(&block)
    block.call self
    children.each {|c| c.visit_all &block}
  end
end

ruby_tree = Tree.new({'grandpa' => {'dad' => {'child 1' => {}, 'child 2' => {} }, 'uncle' => {'child 3' => {}, 'child 4' => {} } } })
ruby_tree.visit_all {|node| puts node.node_name}