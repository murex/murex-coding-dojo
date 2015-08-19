module Test_Hiker where
import Test.HUnit
import Hiker
tests = test [
    "43556046902730968 writes 'hello how are you'" ~: "hello how are you" ~=? getSentence [4,3,5,5,6,0,4,6,9,0,2,7,3,0,9,6,8],
    "2 writes 'a'" ~: "a" ~=? getSentence [2],
    "44 writes 'hi'" ~: "hi" ~=? getSentence [4, 4],
    "469 writes 'how'" ~: "how" ~=? getSentence [4,6,9],
    "44044 writes 'hi hi'" ~: "hi hi" ~=? getSentence [4,4,0,4,4],
    "4695456 writes 'how'" ~: "how" ~=? getSentence [4,6,9,5,4,5,6]
   ]
main = do runTestTT tests