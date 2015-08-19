__author__ = 'rjulien'
 
 
def twist_count(target):
    return best_path(all_paths_to(target))
 
 
def all_paths_to(target):
    return all_paths(1, target)
 
 
def all_paths(start, target):
    if start == target:
        return [[target]]
    if start > target:
        return []
    possible = next_steps(start)
    res = []
    for step in possible:
        res += all_paths(step, target)
    return [[start] + x for x in res]
 
 
def best_path(paths):
    return min(paths, key=len)
 
def switch(input):
    return int(str(input)[::-1])
 
def next_steps(start):
    switchvar = switch(start)
    start_ = start + 1
    if switchvar > start_:
        return [start_, switch(start)]
    return [start_]