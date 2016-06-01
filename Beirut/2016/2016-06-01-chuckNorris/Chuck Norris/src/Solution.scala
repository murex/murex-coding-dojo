import math._
import scala.util._

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
object Solution extends App {

    val result = toChuckNorris(convertToBits(readLine()))
    Console.err.println(result)
    println(result)

    def toChuckNorris(binaryString : String) : String = {
        var currentValue = ' '

       val ret = binaryString.split("").map(c => {
            if (currentValue == c) {
                return "0"
            } else {
                if (c == '1') {
                    currentValue = '1'
                    return " 0 0"
                } else {
                    currentValue = '0'
                    return " 00 0"
                }
            }
        }).mkString("")
        Console.err.print(ret)
        return ret
    }

    def convertToBits(message : String) : String = {
        val ret = message.split("").map( c => {
              c.toInt.toBinaryString
          }).mkString("")
        Console.err.println(ret)
        return ret
    }
}