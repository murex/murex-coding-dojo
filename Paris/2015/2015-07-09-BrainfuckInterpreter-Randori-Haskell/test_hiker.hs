module Test_Hiker where
 
 
import Test.HUnit
import Hiker
 
 
tests = test [
    --"It should print Hello World" ~: "Hello World" ~=? eval "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
    "An empty program returns an empty string" ~: "" ~=? eval "",
    "Print start address" ~: "\0" ~=? eval ".",
    "Increment and print" ~: "\1" ~=? eval "+.",
    "Increment twice and print" ~: "\2" ~=? eval "++.",
    "Increment, decrement and print" ~: "\0" ~=? eval "+-.",
    "Increment, forward and print" ~: "\0" ~=? eval "+>.",
    "Double print" ~: "\0\0" ~=? eval "..",
    "Increment, forward, backward and print" ~: "\1" ~=? eval "+><.",
    "Bracket can jump out" ~: "\0" ~=? eval "[+]."
   ]
main = do runTestTT tests