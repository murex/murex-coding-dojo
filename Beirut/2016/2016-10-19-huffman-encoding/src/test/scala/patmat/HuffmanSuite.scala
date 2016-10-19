package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
    val charsList = List('a', 'b', 'c', 'c', 'b', 'a', 'a', 'd')
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("times or a larger tree") {
    new TestTrees {
      assert(times(charsList) === List(('a',3), ('b',2), ('c',2), ('d',1)))
    }
  }
  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("createCodeTree of some leaf list") {
    new TestTrees {
      assert(createCodeTree(charsList) === Fork(Fork(Fork(Leaf('d',1),Leaf('b',2),List('d', 'b'),3), Leaf('c',2), List('d', 'b', 'c'), 5), Leaf('a',3), List('d', 'b', 'c', 'a'), 8))
    }
  }

  test("decode a very short message") {
    new TestTrees {
      assert(decode(t2, List(0,0,0,1,1)) === "abd".toList)
    }
  }

  test("encode a very short message") {
    new TestTrees {
      assert(encode(t2) (List('b', 'd', 'a', 'a')) === List(0,1,1,0,0,0,0))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

}
