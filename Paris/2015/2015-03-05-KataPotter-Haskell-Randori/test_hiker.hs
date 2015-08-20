module Test_Hiker where
import Test.HUnit
import Hiker
--acceptance_test = TestCase (assertEqual "2 packs of 4" (51.20) discountPrice [2, 2, 2, 1, 1])
tests = TestList [
              TestCase (assertEqual "1" (8.0) (discountPrice [1])),
              TestCase (assertEqual "2" (16.0) (discountPrice [2])),
              TestCase (assertEqual "1 1" (15.20) (discountPrice [1, 1])),
              TestCase (assertEqual "5 7" (92) (discountPrice [5, 7])),
              TestCase (assertEqual "7 5" (92) (discountPrice [7, 5])),
              TestCase (assertEqual "1 1 1" (21.6) (discountPrice [1, 1, 1])),
              TestCase (assertEqual "1 2 1" (29.6) (discountPrice [1, 2, 1]))]
main = do runTestTT tests