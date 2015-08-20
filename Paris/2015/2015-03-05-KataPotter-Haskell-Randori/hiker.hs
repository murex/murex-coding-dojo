module Hiker where
import Data.List
bookPrice = 8.0
discount 2 = 2 * bookPrice * 0.95
discount 3 = 3 * bookPrice * 0.9
 
discountPrice' :: [Double] -> Double
discountPrice' [nbBooks] = bookPrice * nbBooks
discountPrice' (0:books) = discountPrice' books
discountPrice' [x, y] = (discount 2) + discountPrice' [x-1, y-1]
--discountPrice' [x, y] = (x * bookPrice * (discount 2)) + discountPrice' [y-x]
--discountPrice' (x:books) = (x * bookPrice * (discount (length books) + 1)) + discountPrice' (books - 1)
discountPrice' [x, y, z] = (discount 3) + discountPrice' [x-1, y-1, z-1]
 
discountPrice = discountPrice' . sort
split :: [Int] -> [[Int]]
split [] = [[]]
split [nbBooks] = [[nbBooks]]
split (head:books) = (head:books)::