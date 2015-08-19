module Hiker where
answer :: Int
answer = 6 * 9
 
isSolution [_] = True
isSolution [_, _] = False
isSolution [_, _, _] = False
isSolution cells = (not (hasDuplicates (map toColumn cells))) && (not (hasDuplicates (map toRow cells))) && (not diag cells)
    where toColumn (_,c) = c
          toRow(r, _) = r
          toDiag(x,y) = x-y
hasDuplicates (v1:tail) = elem v1 tail || (hasDuplicates tail)
hasDuplicates [] = False