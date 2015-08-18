module Hiker where
import Data.Char
data Memory = Memory{left::[Int], ptr::Int, right::[Int]}
    deriving(Read,Show,Eq)
 
blankMemory = (Memory (repeat 0) 0 (repeat 0))
 
 
inc (Memory left x xs) = Memory left (x+1) xs
dec (Memory left x xs) = Memory left (x-1) xs
fwd (Memory left x (y:xs)) = Memory (x:left) y xs
bwd (Memory (x:xs) y right) = Memory xs x (y:right)
 
 
eval :: String -> String
eval = eval' blankMemory
 
 
eval' :: Memory -> String -> String
eval' _ "" = ""
eval' mem ('+':expr) = eval' (inc mem) expr
eval' mem ('-':expr) = eval' (dec mem) expr
eval' mem ('.':expr) = (chr(ptr mem):eval' mem expr)
eval' mem ('>':expr) = eval' (fwd mem) expr
eval' mem ('<':expr) = eval' (bwd mem) expr
eval' mem@(Memory _ 0 _) ('[':_:']':expr) = if (ptr mem) == 0
                                then eval' mem expr
                                else eval' mem (loop:'[':loop:']':expr)