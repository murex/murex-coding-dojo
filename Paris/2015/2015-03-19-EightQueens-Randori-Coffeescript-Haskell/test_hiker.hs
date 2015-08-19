module Test_Hiker where
import Test.HUnit
import Hiker
 
tests = test [
    "1x1 is always a solution" ~: True ~=? isSolution [(1,1)],
    "2x2 board has no solution" ~: False ~=? isSolution [(1,1), (2,2)],
    "3x3 board has no solution" ~: False ~=? isSolution [(1,1), (2,2), (3,3)],
    "4x4 solution" ~: True ~=? isSolution [(1,2), (2,4), (3,1), (4,3)],
    "4x4 on same column" ~: False ~=? isSolution [(1,1), (2,4), (3,1), (4,3)],
    "4x4 on same column" ~: False ~=? isSolution [(1,2), (2,4), (3,2), (4,3)],
    "4x4 on same column" ~: False ~=? isSolution [(1,2), (2,2), (3,4), (4,3)],
    "4x4 on same column" ~: False ~=? isSolution [(1,2), (2,1), (3,1), (4,3)],
    "4x4 on same row" ~: False ~=? isSolution [(1,1), (1,2), (3,3), (4,4)],
    "4x4 on same diag" ~: False ~=? isSolution [(1,1), (2,2), (3,3), (4,4)]
    ]
main = do runTestTT tests