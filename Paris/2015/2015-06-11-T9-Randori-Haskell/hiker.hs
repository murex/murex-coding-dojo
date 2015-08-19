module Hiker where
import Data.List
import Data.Maybe
import Data.List.Split
dico = ["a","hi","i","how", "hello", "are", "you"]
getSentence::[Integer] -> String
getSentence keys = intercalate " " (map getWord (splitOn [0] keys))
getWord::[Integer] -> String
getWord keys = intercalate "|" (getWord' keys)
getWord'::[Integer] -> [String]
getWord' keys = filter (\w -> (signature w) == keys) dico
 
signature::String -> [Integer]
signature = map charToInt
charToInt::Char -> Integer
charToInt 'a' = 2
charToInt 'h' = 4
charToInt 'i' = 4
charToInt 'o' = 6
charToInt 'w' = 9
charToInt 'e' = 3
charToInt 'l' = 5
charToInt 'r' = 7
charToInt 'y' = 9
charToInt 'u' = 8